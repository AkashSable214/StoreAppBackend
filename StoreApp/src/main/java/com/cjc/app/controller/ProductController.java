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

import com.cjc.app.entity.Product;
import com.cjc.app.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/dealer/{dealerId}")
	public Product save(@RequestBody Product product, @PathVariable Long dealerId) {
		return service.saveProduct(product, dealerId);
	}

	@GetMapping("/all")
	public List<Product> getAll() {
	    return service.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product get(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteProduct(id);
		return "Product Deleted";
	}
}
