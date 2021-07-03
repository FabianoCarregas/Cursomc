package com.fabiano.curso.services;

import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.curso.domain.Tb_Order;
import com.fabiano.curso.repositories.RepositoryOrder;
import com.fabiano.curso.services.exception.ObjectNotFoundException;

@Service
public class ServiceOrder {
	
	@Autowired
	private RepositoryOrder repo;
	
	
	public Tb_Order find(Integer id) {
		Optional<Tb_Order>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tb_Order.class.getName()));
		
		
				
		
		
	}

}
