package com.cjc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.entity.Customer;
import com.cjc.app.entity.Product;
import com.cjc.app.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping
	public Customer save(@RequestBody Customer c) {
		return service.save(c);
	}

	@GetMapping("/all")
	public List<Customer> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Customer get(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public Customer update(@PathVariable Long id, @RequestBody Customer c) {
		return service.update(id, c);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	  @PostMapping("/{customerId}/add-to-cart/{productId}")
	    public Customer addToCart(@PathVariable Long customerId, @PathVariable Long productId) {
	        return service.addToCart(customerId, productId);
	    }

	    @DeleteMapping("/{customerId}/remove-from-cart/{productId}")
	    public Customer removeFromCart(@PathVariable Long customerId, @PathVariable Long productId) {
	        return service.removeFromCart(customerId, productId);
	    }

	    @GetMapping("/{customerId}/cart")
	    public List<Product> getCart(@PathVariable Long customerId) {
	        return service.getCart(customerId);
	    }
	
}
