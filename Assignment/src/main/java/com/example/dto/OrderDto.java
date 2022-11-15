package com.example.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDto {
	
	private String orderDate;
	
	private Set<ItemDto> items = new HashSet<>();


	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	

	public OrderDto(String orderDate, Set<ItemDto> items) {
		super();
		this.orderDate = orderDate;
		this.items = items;
	}

	public Set<ItemDto> getItems() {
		return items;
	}

	public void setItems(Set<ItemDto> items) {
		this.items = items;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
