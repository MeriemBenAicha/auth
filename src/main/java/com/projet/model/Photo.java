package com.projet.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPhoto;
	@OneToMany
	private List<Product> listProducts;
	public Long getIdPhoto() {
		return idPhoto;
	}
	public void setIdPhoto(Long idPhoto) {
		this.idPhoto = idPhoto;
	}
	public List<Product> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}


}
