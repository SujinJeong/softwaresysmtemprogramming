package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order_product;

public interface OrderProductMapper {

	List<Order_product> getOrderProductList(int store_id, int order_id);
	// 발주 상품 리스트
	void insertOrderProduct(Cart cart);
	// 발주 상품 저장

}
