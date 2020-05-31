package com.dongduk.myfancy.dao.mybatis.mapper;

public interface StoreMapper {

	String getStoreName(int store_id);
	// 지점 이름
	String getStoreAddress(int store_id);
	// 지점 주소
	
}
