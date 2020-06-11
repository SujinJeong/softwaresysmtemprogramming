package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Product;

public interface ProductMapper {

	List<Product> getProductListByCategory(int category_id);
	// 카테고리에 해당하는 상품 리스트
	Product getProduct(int product_id);
	// 상품 정보
	List<Product> getProductList (int store_id);
	// 지점 내 모든 상품 리스트 
}
