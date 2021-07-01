package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.Product;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, Integer> {

}
