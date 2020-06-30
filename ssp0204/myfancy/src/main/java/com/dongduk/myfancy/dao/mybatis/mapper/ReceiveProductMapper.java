package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Receive_product;

public interface ReceiveProductMapper {

	List<Order_product> getOrderList(int store_id); 
	// 발주한 물품들의 List를 받아 입고대기 목록에 추가시켜 주기 위한 method
	Order_product getOrderProduct(int order_id, int product_id) throws DataAccessException; 
	// Order Product를 하나씩 가져오기 위한 list
	List<Receive_product> getReceiveList(int store_id);
	// 입고된 물품들의 List를 받아오기 위한 리스트
	void removeOrderProduct(int order_id, int product_id);
	// 지점 내 재고 업데이트, 입고된 물품 발주 목록에서 삭제

}
