package com.ty.ProductService.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.ProductService.Repository.ProductRepository;
import com.ty.ProductService.model.Product;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
}
