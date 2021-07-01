package com.fabiano.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.curso.domain.Category;
import com.fabiano.curso.repositories.RepositoryCategory;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private RepositoryCategory repositoryCategory;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		
		repositoryCategory.saveAll(Arrays.asList(cat1, cat2));
		
	}

}

 