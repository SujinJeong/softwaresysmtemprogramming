package com.dongduk.myfancy.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	private Map<Product, Integer> cartList;
	private int quantity;
	private int cartTotalQuantity;	//카트 내 물품들 총 수량
	
	public Cart() {
		super();
		cartList = new HashMap<Product, Integer>();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCartList(Map<Product, Integer> cartList) {
		this.cartList = cartList;
	}

	public HashMap<Product, Integer> getCartList() {
		return (HashMap<Product, Integer>) cartList;
	}

	public void setCartTotalQuantity(int cartTotalQuantity) {
		this.cartTotalQuantity = cartTotalQuantity;
	}

	//카트에 담긴 물품들 총 수량 가져옴
	public int getCartTotalQuantity() {
		cartTotalQuantity = 0;
		cartList = getCartList(); // cart에 담긴 물품들
		for(Map.Entry<Product, Integer> elem : cartList.entrySet()) { // cart에 담긴 물품들
		         cartTotalQuantity += elem.getValue();	//카트 내 수량들 모두 더해줌
		}
		return cartTotalQuantity;	//카트 내 물품들 총 수량 returns
	}

	//카트(오른쪽 분활화면)에 소비자가 선택한 상품들 추가
	public void addProductForSale(Product product, int quantity) {
		cartList.put(product, quantity);	
	}
	
	public void addProductForOrder(Product product, int quantity) { // cart에 담기
		cartList.put(product, quantity);
	}
	
	public Product checkInStock(Product product, Map<Product, Integer> cartList) {	//재고가 부족한 물품 넘겨줌
		
		Set<Entry<Product,Integer>> set = cartList.entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			if (product.getQuantity() < e.getValue() || product.isInStock() == false) {
				return product;
			}
		}
		return null;
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

	public int getSubSaleTotal() {
		int subTotal = 0;
		cartList = getCartList();
		Set<Entry<Product, Integer>> set = cartList.entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			subTotal += (e.getKey().getList_price() * e.getValue());
		}
		return subTotal;
	}

	//cart내 물품들 삭제
	public void removeSale() {
		cartList = getCartList();
		cartList.clear();
		boolean isEmpty = cartList.isEmpty();
	}
	
	public Product findProduct(HashMap<Product, Integer> list, int pid) { 
		   Set<Product> set = list.keySet(); 
		   Iterator<Product> iter = set.iterator(); 
		   Product p = null; 
		   while(iter.hasNext()) { 
		     p = iter.next(); 
		     if(p.getProduct_id() == pid) break; 
		  } 
		  return p; 
		} 

}
