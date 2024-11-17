package com.ty.OrderService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ty.OrderService.model.Product;
import com.ty.OrderService.model.User;

import reactor.core.publisher.Mono;

@Service
public class OrderService {

	private final WebClient webClient;

	@Value("${user-service.url}") // Get User Service URL from application.properties
	private String userServiceUrl;

	@Value("${product-service.url}") // Get Product Service URL from application.properties
	private String productServiceUrl;

	public OrderService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build(); // Base URL for Order Service
	}

	// Call User Service to verify the user placing the order
	public Mono<User> getUser(Long userId) {
		return webClient.get().uri(userServiceUrl + "/users/" + userId).retrieve().bodyToMono(User.class);
	}

	// Call Product Service to check product availability
	public Mono<Product> getProduct(Long productId) {
		return webClient.get().uri(productServiceUrl + "/products/" + productId).retrieve().bodyToMono(Product.class);
	}
}
