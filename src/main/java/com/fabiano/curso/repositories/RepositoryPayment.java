package com.fabiano.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fabiano.curso.domain.Payment;

@Repository
public interface RepositoryPayment extends JpaRepository<Payment, Integer> {

}
