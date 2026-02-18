package com.cjc.app.service;

import java.util.List;

import com.cjc.app.entity.Product;

public interface ProductService {

	Product saveProduct(Product product, Long dealerId);

	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);

	public long countProducts();

}
