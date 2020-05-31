package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;

public interface OrderMapper {

	List<Order> getOrderListByStore(int store_id);
	// 지점에서 발주 신청한 목록 리스트
	Order getOrder(int order_id, int store_id); 
	// 발주 조회 ex. 발주 번호 3 : 펜1 지우개 2
	void insertOrder(List<Order_product> orderProductList, int store_id, int amount); 
	// 발주 등록

}
