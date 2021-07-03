package com.fabiano.curso.domain;

import javax.persistence.Entity;

import com.fabiano.curso.domain.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallments;
	
	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentStatus status, Tb_Order order, Integer numberOfInstallments) {
		super(id, status, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	
	
	
}
