package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Receive_product;

public interface ReceiveProductDao {

	void addLossQuantity(List<Receive_product> rProductList) throws DataAccessException; 
	// 차이수량을 조사해서 입고가 안된 만큼 재발주를 수행해주기 위한 method
	void calLossQuantity(List<Receive_product> rProductList, List<Order_product> oProductList) throws DataAccessException; 
	// 입고수량과 발주수량의 차이를 조사해주기 위한 method
	void insertReciveQuantity(int store_id, Receive_product receiveProduct) throws DataAccessException; 
	// 입고대기 목록에 있는 물품들의 입고수량을 직접 입력 받아 그 수량을 조사하는 method
	List<Order_product> getOrderList(int store_id) throws DataAccessException; 
	// 발주한 물품들의 List를 받아 입고대기 목록에 추가시켜 주기 위한 method
	List<Receive_product> getReceiveList(int store_id) throws DataAccessException; 
	// 발주한 물품들의 List를 받아 입고대기 목록에 추가시켜 주기 위한 method

}
