package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Product;

public interface StockMapper {

	List<Product> getProductStock(int store_id); 
	// 지점 내 모든 상품 재고 리스트
	void updateStock(int quantity, int product_id, int store_id);
	// 지점 내 재고 업데이트
	Product getOneProductStock(int store_id, int product_id);
}
