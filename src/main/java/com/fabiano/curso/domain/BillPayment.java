package com.fabiano.curso.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fabiano.curso.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BillPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
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
