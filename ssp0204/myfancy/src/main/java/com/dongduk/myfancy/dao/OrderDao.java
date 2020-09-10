package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;

public interface OrderDao { //Service에 의해 호출되어 DB CRUD를 담당,,단일 데이터의 접근과 갱신만 처리한다(CRUD)

	List<Order> getOrderListByStore(int store_id) throws DataAccessException;
	// 지점에서 발주 신청한 목록 리스트
	Order getOrder(int order_id, int store_id) throws DataAccessException; 
	// 발주 조회 ex. 발주 번호 3 : 펜1 지우개 2
	void insertOrder(Order order) throws DataAccessException; 
	// 발주 등록
	
}
