package com.projet.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.projet.model.Order;
import com.projet.model.Photo;
import com.projet.model.Product;
import com.projet.repository.OrderRepository;
import com.projet.repository.ProductRepository;

//import java.util.List;

@Service
public class EcommerceService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private SessionFactory sessionFactory;

	/* PRODUCT */
	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long id) {
		return productRepository.findById(id).get();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public String addProductImage(final String productId, final String filename) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Photo image = new Photo();
		//image.setIdProductPhoto(getProduct(Long.parseLong(productId)));
		//image.setPathPhoto(filename);

		try {
			String res = session.save(image).toString();
			session.getTransaction().commit();
			return res;
		} catch (HibernateException e) {
			System.out.print(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return "";
	}

//	/* ORDERS */
//	public List<Order> getOrders() {
//		return orderRepository.findAll();
//	}
//
//	public Order getOrder(long id) {
//		return orderRepository.findById(id).get();
//	}
//
//	public Order saveOrder(Order order) {
//		return orderRepository.save(order);
//	}
}
