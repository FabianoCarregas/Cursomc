package com.fabiano.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.curso.domain.Category;
import com.fabiano.curso.repositories.RepositoryCategory;

@Service
public class ServiceCategory {
	
	@Autowired
	private RepositoryCategory repo;
	
	
	public Category buscar(Integer id) {
		Optional<Category>obj = repo.findById(id);
		return obj.get();
		
		
	}

}
