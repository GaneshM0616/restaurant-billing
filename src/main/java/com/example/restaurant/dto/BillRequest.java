package com.example.restaurant.dto;

import java.util.List;



public class BillRequest {
	
	private List<BillItemRequest> items;
	private Double discount;
	private Double tax;
	
	public void setItems(List<BillItemRequest> items) {
		this.items = items;
	}
	public List<BillItemRequest> getItems() {
		return items;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	

}
