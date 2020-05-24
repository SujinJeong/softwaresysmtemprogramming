package com.dongduk.myfancy.dao;

import java.util.Date;

import org.springframework.dao.DataAccessException;

public interface SalesDao {

	int getSalesByMonth(int store_id, Date sales_date) throws DataAccessException;
	 // 월별 매출 집계
	int getSalesByWeek(int store_id, Date sales_date) throws DataAccessException;
	// 주별 매출 집계
	int getSalesByDay(int store_id, Date sales_date) throws DataAccessException;
	// 요일별 매출 집계
	void insertSalesAmount(int store_id, int sales_date) throws DataAccessException; 
	// 판매내역을 실시간으로 매출에 추가시키기 위한 method

}
