package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Product;

public interface SaleProductDao {

	void insertSaleProduct(Cart cart)  throws DataAccessException;
	// 최종적으로 판매되는 상품 리스트 저장
	List<Product> getSaleProductListBySaleId(int store_id, int sale_id) throws DataAccessException;
	// Receipt에서 상품명, 가격, 수량 보여주기 위한 method

}
