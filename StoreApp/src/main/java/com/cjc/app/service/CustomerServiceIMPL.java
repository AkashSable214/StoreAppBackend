package com.cjc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.entity.Customer;
import com.cjc.app.entity.Product;
import com.cjc.app.repo.CustomerRepo;
import com.cjc.app.repo.ProductRepo;

@Service
public class CustomerServiceIMPL implements CustomerService {
	
	 @Autowired
	    CustomerRepo repo;
	 
	 

	    @Autowired
	    private ProductRepo productRepo;

	    public Customer save(Customer c){
	        return repo.save(c);
	    }

	    public List<Customer> getAll(){
	        return repo.findAll();
	    }

	    public Customer getById(Long id){
	        return repo.findById(id).orElse(null);
	    }

	    public Customer update(Long id, Customer c){
	        c.setId(id);
	        return repo.save(c);
	    }

	    public void delete(Long id){
	        repo.deleteById(id);
	    }
	    
	    public long countCustomers() {
	        return repo.count();
	    }
	    
	    
	    @Override
	    public Customer addToCart(Long customerId, Long productId) {
	        Customer customer = repo.findById(customerId).orElseThrow();
	        Product product = productRepo.findById(productId).orElseThrow();

	        if (!customer.getProducts().contains(product)) {
	            customer.getProducts().add(product);
	            repo.save(customer);
	        }
	        return customer;
	    }

	    @Override
	    public Customer removeFromCart(Long customerId, Long productId) {
	        Customer customer = repo.findById(customerId).orElseThrow();
	        Product product = productRepo.findById(productId).orElseThrow();

	        customer.getProducts().remove(product);
	        repo.save(customer);
	        return customer;
	    }

//	    @Override
//	    public List<Product> getCart(Long Id) {
//	        Customer customer = repo.findById(Id).orElseThrow();
//	        return customer.getProducts();
//	    }
	    
	    @Override
	    public List<Product> getCart(Long customerId) {
	        Customer customer = repo.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
	        return customer.getProducts() != null ? customer.getProducts() : new ArrayList<>();
	    }


}
