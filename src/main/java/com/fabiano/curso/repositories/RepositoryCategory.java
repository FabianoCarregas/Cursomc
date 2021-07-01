package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.curso.domain.Category;

@Repository
public interface RepositoryCategory extends JpaRepository<Category, Integer> {

}
