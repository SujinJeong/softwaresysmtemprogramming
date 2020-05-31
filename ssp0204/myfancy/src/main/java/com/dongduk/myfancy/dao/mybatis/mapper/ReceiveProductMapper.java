package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Receive_product;

public interface ReceiveProductMapper {

	void addLossQuantity(List<Receive_product> rProductList); 
	// 차이수량을 조사해서 입고가 안된 만큼 재발주를 수행해주기 위한 method
	void calLossQuantity(List<Receive_product> rProductList, List<Order_product> oProductList)  ; 
	// 입고수량과 발주수량의 차이를 조사해주기 위한 method
	void insertReciveQuantity(int store_id, Receive_product receiveProduct)  ; 
	// 입고대기 목록에 있는 물품들의 입고수량을 직접 입력 받아 그 수량을 조사하는 method
	List<Product> getOrderList(int store_id)  ; 
	// 발주한 물품들의 List를 받아 입고대기 목록에 추가시켜 주기 위한 method

}
