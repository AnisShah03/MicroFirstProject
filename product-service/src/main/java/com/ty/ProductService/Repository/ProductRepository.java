package com.ty.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ProductService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
