package com.fabiano.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiano.curso.domain.Address;
import com.fabiano.curso.domain.BillPayment;
import com.fabiano.curso.domain.CardPayment;
import com.fabiano.curso.domain.Category;
import com.fabiano.curso.domain.City;
import com.fabiano.curso.domain.Client;
import com.fabiano.curso.domain.OrderItem;
import com.fabiano.curso.domain.Payment;
import com.fabiano.curso.domain.Product;
import com.fabiano.curso.domain.State;
import com.fabiano.curso.domain.Tb_Order;
import com.fabiano.curso.domain.enums.ClientType;
import com.fabiano.curso.domain.enums.PaymentStatus;
import com.fabiano.curso.repositories.RepositoryAddress;
import com.fabiano.curso.repositories.RepositoryCategory;
import com.fabiano.curso.repositories.RepositoryCity;
import com.fabiano.curso.repositories.RepositoryClient;
import com.fabiano.curso.repositories.RepositoryOrder;
import com.fabiano.curso.repositories.RepositoryOrderItem;
import com.fabiano.curso.repositories.RepositoryPayment;
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
	@Autowired
	private RepositoryOrder repositoryOrder;
	@Autowired
	private RepositoryPayment repositoryPayment;
	@Autowired
	private RepositoryOrderItem repositoryOrderItem;
	
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
		State st2 = new State(null, "S??o Paulo");
		
		City c1 = new City(null, "Uberl??ndia", st1);
		City c2 = new City(null, "S??o Paulo", st2);
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Tb_Order ord1 = new Tb_Order(null,sdf.parse("12/12/2020 12:12"), cli1, e1);
		Tb_Order ord2 = new Tb_Order(null,sdf.parse("10/10/2020 10:10"), cli1, e2);
		
		Payment pto1= new CardPayment(null, PaymentStatus.QUITADO, ord1, 6);
		ord1.setPayment(pto1);
		
		Payment pto2= new BillPayment(null, PaymentStatus.PEDENDE, ord2, sdf.parse("11/11/2020 11:11"), null);
		ord2.setPayment(pto2);
		
		cli1.getOrders().addAll(Arrays.asList(ord1,ord2));
		
		repositoryOrder.saveAll(Arrays.asList(ord1, ord2));
		repositoryPayment.saveAll(Arrays.asList(pto1, pto2));
		
		OrderItem oi1= new OrderItem(ord1, p1, 0.00, 1, 2000.00);
		OrderItem oi2= new OrderItem(ord1, p3, 0.00, 2, 80.00);
		OrderItem oi3= new OrderItem(ord2, p2, 100.0, 1, 800.0);
		
		ord1.getItens().addAll(Arrays.asList(oi1, oi2));
		ord2.getItens().addAll(Arrays.asList(oi2));
		
		p1.getItens().addAll(Arrays.asList(oi1));
		p2.getItens().addAll(Arrays.asList(oi3));
		p3.getItens().addAll(Arrays.asList(oi2));
		
		repositoryOrderItem.saveAll(Arrays.asList(oi1,oi2,oi3));
		
		
		
		
		
		
		
		
	
		
		
		
	}

}

 