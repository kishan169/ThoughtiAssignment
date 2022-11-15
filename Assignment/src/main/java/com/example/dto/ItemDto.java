package com.example.dto;

public class ItemDto {
	
	private String itemName;
	private Double itemUnitPrice;
	private Integer itemQuantity;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemUnitPrice() {
		return itemUnitPrice;
	}
	public void setItemUnitPrice(Double itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public ItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDto(String itemName, Double itemUnitPrice, Integer itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemUnitPrice = itemUnitPrice;
		this.itemQuantity = itemQuantity;
	}
	
	
}
