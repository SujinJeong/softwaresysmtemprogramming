package com.dongduk.myfancy.service;

import com.dongduk.myfancy.domain.Store;

public interface StoreService {

	String getStoreName(int store_id);
	// 지점 이름
	String getStoreAddress(int store_id);
	// 지점 주소
	Store getStore(int store_id);
	Store getStore(int store_id, String pw);
	
}
