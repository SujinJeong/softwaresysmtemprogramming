package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.dongduk.myfancy.domain.Product;

public interface ProductDao {

	List<Product> getProductListByCategory(int category_id) throws DataAccessException;
	// 카테고리에 해당하는 상품 리스트
	Product getProduct(int product_id) throws DataAccessException;
	// 상품 정보
	List<Product> getProductList (int store_id) throws DataAccessException;
	// 지점 내 모든 상품 리스트  
}
