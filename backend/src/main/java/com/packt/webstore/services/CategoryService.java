package com.packt.webstore.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.dto.CategoryDTO;
import com.packt.webstore.entities.Category;
import com.packt.webstore.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {

		List<Category> list = repository.findAll();

		return list.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());

	}
}