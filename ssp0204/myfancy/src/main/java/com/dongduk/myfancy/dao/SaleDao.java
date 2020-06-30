package com.dongduk.myfancy.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

public interface SaleDao {
	//기존 method
//	void insertSale(int store_id, List<Sale_product>saleProductList, int amount) throws DataAccessException;
	//DB 모든 필드 정의
//	void insertSale(int sale_id, int store_id, Date sale_time,int totalamount) throws DataAccessException;
	//DB에서 자동생성되는 시퀀스,오늘날짜 지정해주는 sysdate빼고 정의
	void insertSale(int store_id, int subSaleTotal) throws DataAccessException;
   	// 결제가 이루어진 시간 등 정보 저장
	void insertSale(Sale sale)throws DataAccessException;
	
   	Sale getSale(int sale_id, int store_id) throws DataAccessException;
   	// 판매 정보
   	List<Sale> getSaleList(int store_id, Date date) throws DataAccessException;
   	// 판매 리스트
}