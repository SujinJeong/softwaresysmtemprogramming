package com.dongduk.myfancy.dao.mybatis.mapper;

import com.dongduk.myfancy.domain.Store;

public interface StoreMapper {

	String getStoreName(int store_id);
	// 지점 이름
	String getStoreAddress(int store_id);
	// 지점 주소
	Store getStoreByStoreId(int store_id);
	Store getStoreByStoreIdAndPassword(int store_id, String pw);
	
}
