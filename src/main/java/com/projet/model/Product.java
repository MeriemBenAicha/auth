package com.projet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduct;
    private String nameProduct;
    private float priceProduct;
    private String descriptionProduct;
    @OneToOne
    @JoinColumn(name = "idPhoto")
    private Photo photoProduct;
    @ManyToOne
    @JoinColumn(name="idCategory")
	private Category categoryProduct;

	public Product(){ }

    public Product(Long id){
        this.idProduct = id;
    }

    public Product(String name,float price,Date date){
    	this.nameProduct=name;
    	this.priceProduct=price;
    }




    public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public Photo getPhotoProduct() {
		return photoProduct;
	}

	public void setPhotoProduct(Photo photoProduct) {
		this.photoProduct = photoProduct;
	}

	public Category getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(Category categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	@Override
	public String toString() {
        return getNameProduct();
    }


}