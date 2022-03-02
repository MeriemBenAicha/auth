package com.projet.service;

import org.springframework.stereotype.Service;

import com.projet.model.Product;

@Service
public interface ProductService {
	Product saveProduct(Product p);
	Product updateProduct(Product p);
	void deleateProduct (Product p);
	void deleateProduct (Long id);
	Product getProduct(Long id);
	Iterable<Product> getAllProducts();

}
