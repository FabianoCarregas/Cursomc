package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.OrderItem;

@Repository
public interface RepositoryOrderItem extends JpaRepository<OrderItem, Integer> {

	

}
