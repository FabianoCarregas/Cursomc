package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.Address;

@Repository
public interface RepositoryAddress extends JpaRepository<Address, Integer> {

}
