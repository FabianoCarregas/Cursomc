package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.State;

@Repository
public interface RepositoryState extends JpaRepository<State, Integer> {

}
