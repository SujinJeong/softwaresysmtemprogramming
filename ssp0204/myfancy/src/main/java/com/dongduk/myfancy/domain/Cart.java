package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.util.Map;

public class Cart implements Serializable {
	private Map<Product, Integer> cartList;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<Product, Integer> getCartList() {
		return cartList;
	}
	
	void addProduct(int product_id, int quantity) {
		
	}
	
	void checkInStock(Map list) {
		
	}
	
	void setQuantityByProductId(int product_id) {
		
	}
	
	int getSubTotal() {
		return 0;
	}

}
