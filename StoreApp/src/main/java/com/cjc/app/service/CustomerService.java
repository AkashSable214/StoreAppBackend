package com.cjc.app.service;

import java.util.List;

import com.cjc.app.entity.Customer;
import com.cjc.app.entity.Product;

public interface CustomerService {

	Customer save(Customer c);

	List<Customer> getAll();

	Customer getById(Long id);

	Customer update(Long id, Customer c);

	void delete(Long id);
	
	public long countCustomers();
	
	
    Customer addToCart(Long customerId, Long productId);
    Customer removeFromCart(Long customerId, Long productId);
    List<Product> getCart(Long customerId);

}
