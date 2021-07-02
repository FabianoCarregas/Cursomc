package com.fabiano.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiano.curso.domain.Client;
import com.fabiano.curso.repositories.RepositoryClient;
import com.fabiano.curso.services.exception.ObjectNotFoundException;

@Service
public class ServiceClient {
	
	@Autowired
	private RepositoryClient repo;
	
	
	public Client find(Integer id) {
		Optional<Client>obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
		
		
				
		
		
	}

}
