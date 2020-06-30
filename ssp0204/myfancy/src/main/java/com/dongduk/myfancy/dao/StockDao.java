package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Product;

public interface StockDao {

	List<Product> getProductStock(int store_id) throws DataAccessException; 
	// 지점 내 모든 상품 재고 리스트
	Product getOneProductStock(int store_id, int product_id);
	// 지점의 한 상품 재고 출력을 위한 product반환 타입 메소드
	void updateStock(int quantity, int product_id, int store_id) throws DataAccessException;
	// 지점 내 재고 업데이트
}
