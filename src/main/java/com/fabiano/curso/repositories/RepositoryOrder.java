package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.Tb_Order;

@Repository
public interface RepositoryOrder extends JpaRepository<Tb_Order, Integer> {

}
