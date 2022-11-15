package com.example.repotest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Orders;
import com.example.repository.OrderDao;
import com.example.service.OrderService;

@SpringBootTest
public class OrderRepoTest {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	void isExistsById(Integer OrderId) {
		Orders order = new Orders(1,LocalDate.now(),"Yes");
		orderDao.save(order);
		
		Boolean actualResult = orderDao.existsById(1);
		assertThat(actualResult).isTrue();
		
	}
	
	@Test
	void findAllOrders() {
		orderService.findAllOrders();
		verify(orderDao).findAll();
	}
	
	
}
