package com.dongduk.myfancy.dao;

import org.springframework.dao.DataAccessException;

public interface StoreDao {

	String getStoreName(int store_id) throws DataAccessException;
	// 지점 이름
	String getStoreAddress(int store_id) throws DataAccessException;
	// 지점 주소
	
}
