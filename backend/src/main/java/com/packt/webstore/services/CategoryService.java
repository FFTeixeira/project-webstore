package com.packt.webstore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.entities.Category;
import com.packt.webstore.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Transactional()
	public List<Category> findAll() {
		
		return repository.findAll();
	}
}
