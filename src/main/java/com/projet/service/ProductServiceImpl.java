package com.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.model.Product;
import com.projet.repository.ProductRepository;

import lombok.Data;

@Data
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public void deleateProduct(Product p) {
		productRepository.delete(p);

	}

	@Override
	public void deleateProduct(Long id) {
		productRepository.deleteById(id);

	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
