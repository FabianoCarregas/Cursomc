package com.fabiano.curso.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fabiano.curso.domain.enums.PaymentStatus;

@Entity
public class BillPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Date dueDate;
	private Date payDate;
	
	public BillPayment() {
		
	}

	public BillPayment(Integer id, PaymentStatus status, Tb_Order order,Date dueDate, Date payDate ) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payDate = payDate;
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	
}
