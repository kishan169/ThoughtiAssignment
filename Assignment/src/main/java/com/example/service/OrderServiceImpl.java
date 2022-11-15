package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.OrdersException;
import com.example.dto.ItemDto;
import com.example.dto.OrderDto;
import com.example.model.Item;
import com.example.model.Orders;
import com.example.repository.ItemDao;
import com.example.repository.OrderDao;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public Orders createNewOrder(OrderDto order) {
		
		Orders orders = new Orders();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(order.getOrderDate(), formatter);
		
		orders.setOrderDate(date);
		orders.setOrderStatus("Yes");
		Orders savedOrder =  orderDao.save(orders);
		
		Set<ItemDto> dto = order.getItems();
			
			for(ItemDto item:dto) {
				Item newItem = new Item();
				BeanUtils.copyProperties(item, newItem);
				Item savedItem =  itemDao.save(newItem);
				savedItem.setOrders(savedOrder);
				orders.getItems().add(savedItem);
			}
			
		Orders finalSaved =  orderDao.save(orders);
		
		return finalSaved;
	}

	@Override
	public Orders getOrderById(Integer orderId) throws OrdersException {
		Optional<Orders> order = orderDao.findById(orderId);
		if(!order.isPresent()) throw new OrdersException("Order is not found in the List");
		return order.get();
	}

	@Override
	public List<Orders> findAllOrders() {
		List<Orders> orders =  orderDao.findAll();
		return orders;
	}

}
