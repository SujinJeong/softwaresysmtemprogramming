package com.dongduk.myfancy.domain;

import java.util.Map;


public class Cart {
	
	private Map<Product, Integer> cartList;

	public Cart() {
		super();
		
	}

	public Map<Product, Integer> getCartList() {
		return cartList;
	}
	
	public void addProductForOrder(Product product, int quantity) { // cart에 담기
		cartList.put(product, quantity);
	}
	
	public void checkInStock(Map list) {
		
	}
	
	public void setQuantityByProductId(int product_id) {

	}
	
	public int getSubOrderTotal(Product product) { // 카트에 담긴 총 금액
		int total = 0;
		Map<Product, Integer> cartList = getCartList(); // cart에 담긴 물품들
		for(Map.Entry<Product, Integer> elem : cartList.entrySet()) { // cart에 담긴 물품들 발주
			int order_product_quantity = elem.getValue();
			int order_price = product.getOrder_price();
			total += order_price * order_product_quantity;
		}
		return total;
	}

}
