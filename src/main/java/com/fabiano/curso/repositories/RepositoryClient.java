package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.Client;

@Repository
public interface RepositoryClient extends JpaRepository<Client, Integer> {

}
