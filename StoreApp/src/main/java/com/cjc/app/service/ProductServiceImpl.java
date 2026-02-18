package com.cjc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.entity.Dealer;
import com.cjc.app.entity.Product;
import com.cjc.app.repo.DealerRepo;
import com.cjc.app.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private DealerRepo dealerRepo;

	@Override
	public Product saveProduct(Product product, Long dealerId) {

		Dealer dealer = dealerRepo.findById(dealerId).orElseThrow();
		product.setDealer(dealer);

		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public Product updateProduct(Long id, Product product) {

	    Product existing = productRepo.findById(id).orElseThrow();

	    existing.setProductName(product.getProductName());
	    existing.setProductCategory(product.getProductCategory());
	    existing.setProductPrice(product.getProductPrice());
	    existing.setAvailable(product.isAvailable());

	    return productRepo.save(existing);
	}


	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	public long countProducts() {
	    return productRepo.count(); 
	}



}
