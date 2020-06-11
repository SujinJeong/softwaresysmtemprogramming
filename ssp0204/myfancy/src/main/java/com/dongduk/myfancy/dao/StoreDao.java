package com.dongduk.myfancy.dao;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Store;

public interface StoreDao {

	String getStoreName(int store_id) throws DataAccessException;
	// 지점 이름
	String getStoreAddress(int store_id) throws DataAccessException;
	// 지점 주소
	Store getStore(int store_id) throws DataAccessException;
	Store getStoreByStoreIdAndPassword(int store_id, String pw) throws DataAccessException;
	
}
