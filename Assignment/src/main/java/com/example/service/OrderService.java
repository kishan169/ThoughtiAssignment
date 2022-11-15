package com.example.service;

import java.util.List;

import com.example.Exception.OrdersException;
import com.example.dto.OrderDto;
import com.example.model.Orders;

public interface OrderService {
	
	public Orders createNewOrder(OrderDto order);
	
	public Orders getOrderById(Integer orderId) throws OrdersException;
	
	public List<Orders> findAllOrders();
}
