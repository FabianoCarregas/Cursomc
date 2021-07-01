package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.City;
@Repository
public interface RepositoryCity extends JpaRepository<City, Integer> {

}
