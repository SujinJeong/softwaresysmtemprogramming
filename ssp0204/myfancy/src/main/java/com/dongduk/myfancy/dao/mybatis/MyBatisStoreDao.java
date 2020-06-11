package com.dongduk.myfancy.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.StoreDao;
import com.dongduk.myfancy.dao.mybatis.mapper.StoreMapper;
import com.dongduk.myfancy.domain.Store;

@Repository
public class MyBatisStoreDao implements StoreDao {
	
	@Autowired
	protected StoreMapper storeMapper;

	@Override
	public String getStoreName(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return storeMapper.getStoreName(store_id);
	}

	@Override
	public String getStoreAddress(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return storeMapper.getStoreAddress(store_id);
	}

	@Override
	public Store getStore(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return storeMapper.getStoreByStoreId(store_id);
	}

	@Override
	public Store getStore(int store_id, String pw) throws DataAccessException {
		// TODO Auto-generated method stub
		return storeMapper.getStoreByStoreIdAndPassword(store_id, pw);
	}

}
