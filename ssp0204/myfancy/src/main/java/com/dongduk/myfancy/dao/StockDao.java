package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Product;

public interface StockDao {

	List<Product> getProductStock(int store_id) throws DataAccessException; 
	// 지점 내 모든 상품 재고 리스트

}
