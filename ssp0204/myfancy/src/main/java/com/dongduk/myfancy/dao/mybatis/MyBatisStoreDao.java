package com.dongduk.myfancy.dao.mybatis;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.StoreDao;
import com.dongduk.myfancy.dao.mybatis.mapper.StoreMapper;

public class MyBatisStoreDao implements StoreDao {

	@Override
	public String getStoreName(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStoreAddress(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
