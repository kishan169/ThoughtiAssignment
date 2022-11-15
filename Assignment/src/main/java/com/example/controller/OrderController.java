package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.OrdersException;
import com.example.dto.OrderDto;
import com.example.model.Orders;
import com.example.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Orders> createNewOrder(@RequestBody OrderDto order){
		Orders orders = orderService.createNewOrder(order);
		return new ResponseEntity<Orders>(orders,HttpStatus.CREATED);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable("id") Integer orderId) throws OrdersException{
		Orders orders = orderService.getOrderById(orderId);
		return new ResponseEntity<Orders>(orders,HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrder() throws OrdersException{
		List<Orders> allOrders = orderService.findAllOrders();
		return new ResponseEntity<List<Orders>>(allOrders,HttpStatus.CREATED);
	}
	
	
}
