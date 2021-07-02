package com.fabiano.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.curso.domain.Address;
import com.fabiano.curso.domain.Category;
import com.fabiano.curso.domain.City;
import com.fabiano.curso.domain.Client;
import com.fabiano.curso.domain.Product;
import com.fabiano.curso.domain.State;
import com.fabiano.curso.domain.enums.ClientType;
import com.fabiano.curso.repositories.RepositoryAddress;
import com.fabiano.curso.repositories.RepositoryCategory;
import com.fabiano.curso.repositories.RepositoryCity;
import com.fabiano.curso.repositories.RepositoryClient;
import com.fabiano.curso.repositories.RepositoryProduct;
import com.fabiano.curso.repositories.RepositoryState;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private RepositoryCategory repositoryCategory;
	@Autowired
	private RepositoryProduct repositoryProduct;
	@Autowired
	private RepositoryState repositoryState; 
	@Autowired
	private RepositoryCity repositoryCity;
	@Autowired
	private RepositoryClient repositoryClient;
	@Autowired
	private RepositoryAddress repositoryAddress;
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
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		repositoryState.saveAll(Arrays.asList(st1, st2));
		repositoryCity.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "32435465", ClientType.PESSOAFISICA);
		
		cli1.getPhones().addAll(Arrays.asList("1909980998", "198765898"));
		
		Address e1= new Address(null, "Rua Flores", "300", "Apto. 100", "Jardim", "232343", cli1, c1);
		Address e2= new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "232245", cli1, c2);
		
		cli1.getAddress().addAll(Arrays.asList(e1, e2));
		
		repositoryClient.saveAll(Arrays.asList(cli1));
		repositoryAddress.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
		
	}

}

 