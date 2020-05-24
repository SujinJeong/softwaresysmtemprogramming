package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order_product;

public interface OrderProductDao {

	List<Order_product> getOrderProductList(int store_id, int order_id) throws DataAccessException;
	// 발주 상품 리스트
	void insertOrderProduct(Cart cart) throws DataAccessException;
	// 발주 상품 저장

}
