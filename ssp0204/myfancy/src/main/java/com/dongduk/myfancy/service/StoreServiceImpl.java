package com.dongduk.myfancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.StoreDao;
import com.dongduk.myfancy.domain.Store;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDao storeDao;
	
	@Override
	public String getStoreName(int store_id) {
		// TODO Auto-generated method stub
		return storeDao.getStoreName(store_id);
	}

	@Override
	public String getStoreAddress(int store_id) {
		// TODO Auto-generated method stub
		return storeDao.getStoreAddress(store_id);
	}

	@Override
	public Store getStore(int store_id) {
		// TODO Auto-generated method stub
		return storeDao.getStore(store_id);
	}

	@Override
	public Store getStore(int store_id, String pw) {
		// TODO Auto-generated method stub
		return storeDao.getStore(store_id, pw);
	}

}
