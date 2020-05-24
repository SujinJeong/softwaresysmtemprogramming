package com.dongduk.myfancy.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

public interface SaleDao {
	
	void insertSale(int store_id, List<Sale_product>saleProductList, int amount) throws DataAccessException;
   	// 결제가 이루어진 시간 등 정보 저장
   	Sale getSale(int sale_id, int store_id) throws DataAccessException;
   	// 판매 정보
   	List<Sale> getSaleList(int store_id, Date date) throws DataAccessException;
   	// 판매 리스트

}
