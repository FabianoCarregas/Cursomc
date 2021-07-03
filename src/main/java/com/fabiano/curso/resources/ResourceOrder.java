package com.fabiano.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.curso.domain.Tb_Order;
import com.fabiano.curso.services.ServiceOrder;


@RestController
@RequestMapping(value="/orders")
public class ResourceOrder {

	@Autowired
	private ServiceOrder service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Tb_Order obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
	}
}
