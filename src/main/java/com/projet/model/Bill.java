package com.projet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBill;
	@OneToOne
	@JoinColumn(name = "idOrder")
	private Order orderBill;
	private String paymentMethod;

	public long getIdBill() {
		return idBill;
	}

	public void setIdBill(long idBill) {
		this.idBill = idBill;
	}

	public Order getOrderBill() {
		return orderBill;
	}

	public void setOrderBill(Order idOrderBill) {
		this.orderBill = idOrderBill;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
