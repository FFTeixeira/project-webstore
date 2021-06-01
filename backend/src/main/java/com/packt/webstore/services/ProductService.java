package com.packt.webstore.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.dto.ProductDTO;
import com.packt.webstore.entities.Product;
import com.packt.webstore.repositories.ProductRepository;
import com.packt.webstore.services.exceptions.DatabaseException;
import com.packt.webstore.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {

		Page<Product> list = repository.findAll(pageRequest);

		return list.map(cat -> new ProductDTO(cat));

	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {

		Optional<Product> obj = repository.findById(id);

		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));

		return new ProductDTO(entity, entity.getCategories());
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {

		Product entity = new Product();

		entity.setName(dto.getName());

		entity = repository.save(entity);

		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {

		try {

			Product entity = repository.getOne(id);

			entity.setName(dto.getName());

			entity = repository.save(entity);

			return new ProductDTO(entity);

		} catch (EntityNotFoundException e) {

			throw new ResourceNotFoundException("Id " + id + " not found!");

		}
	}

	public void delete(Long id) {

		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException("Id " + id + " not found!");

		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException("Integrity violation!");
			
		}
	}
}