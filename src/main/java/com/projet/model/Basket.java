package com.projet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "baskets")
public class Basket implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBasket;
	private Double fullPriceBasket ;

	@OneToMany
	@JoinColumn(name = "idProduct")
	private List<Product> productsBasket=new ArrayList<>();
	@OneToOne
	private Utilisateur userBasket;

	public Long getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(Long idBasket) {
		this.idBasket = idBasket;
	}

	public List<Product> getProductsBasket() {
		return productsBasket;
	}

	public void setProductsBasket(List<Product> productsBasket) {
		this.productsBasket = productsBasket;
	}

	public Utilisateur getPuserBasket() {
		return userBasket;
	}

	public void setPuserBasket(Utilisateur puserBasket) {
		this.userBasket = puserBasket;
	}

	public Double getFullPriceBasket() {
		return fullPriceBasket;
	}

	public void setFullPriceBasket(Double fullPriceBasket) {
		this.fullPriceBasket = fullPriceBasket;
	}

	public Double fullPrice() {
		Double d = 0.0;
		for (Product p : productsBasket) {
			d += p.getPriceProduct();
		}
		return d;
	}

}
