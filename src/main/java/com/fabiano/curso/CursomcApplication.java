package com.fabiano.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.curso.domain.Category;
import com.fabiano.curso.domain.Product;
import com.fabiano.curso.repositories.RepositoryCategory;
import com.fabiano.curso.repositories.RepositoryProduct;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private RepositoryCategory repositoryCategory;
	@Autowired
	private RepositoryProduct repositoryProduct;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
				
		repositoryCategory.saveAll(Arrays.asList(cat1, cat2));
		repositoryProduct.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
	}

}

 