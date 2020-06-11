package com.dongduk.myfancy.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dongduk.myfancy.service.StoreService;

public class Cart {
	private Map<Product, Integer> cartList;
	private int quantity;	//사용자가 타이핑하는 수량 사용하기 위한 필드
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCartList(Map<Product, Integer> cartList) {
		this.cartList = cartList;
	}

	public Map<Product, Integer> getCartList() {
		return cartList;
	}
	
	public Cart() {
		super();
	}

	//카트(오른쪽 분활화면)에 소비자가 선택한 상품들 추가
	public void addProductForSale(Product product) {
		cartList.put(product, 1);	//처음 수량은 1로 고정
	}
	
	//카트에서 소비자가 타이핑한 값으로 수량 설정
	public void setQuantityByProductId(Product product) {
//		product.setQuantity(quantity);	//소비자가 타이핑한 값으로 설정
		cartList.put(product, quantity);
	}
	
	public void checkInStock(Map list) {
		for (int i = 0; i < list.size(); i++) {
			 Product p = (Product) list.get(i);
			  if ( p.getQuantity() < quantity) {
				  //역할????
			  }
		}
	}

	public int getSubSaleTotal() {
		int subTotal = 0;
		cartList = getCartList();
		Set<Entry<Product, Integer>> set = cartList.entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			subTotal += e.getKey().getList_price() * e.getValue();
		}
		return subTotal;
	}

}
