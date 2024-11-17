package com.ty.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.OrderService.model.Product;
import com.ty.OrderService.model.User;
import com.ty.OrderService.service.OrderService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/verify/{userId}")
	public Mono<User> verifyUser(@PathVariable Long userId) {
		return orderService.getUser(userId);
	}

	@GetMapping("/check-product/{productId}")
	public Mono<Product> checkProduct(@PathVariable Long productId) {
		return orderService.getProduct(productId);
	}
}
