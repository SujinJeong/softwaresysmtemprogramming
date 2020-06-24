package com.dongduk.myfancy.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SalesDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SalesMapper;

@Repository
public class MyBatisSalesDao implements SalesDao {

	@Autowired
	protected SalesMapper salesMapper;
	
	@Override
	public int getSalesByMonth(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return salesMapper.getSalesByMonth(store_id, sales_date);
	}

	@Override
	public List<Integer> getSalesByWeek(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return salesMapper.getSalesByWeek(store_id, sales_date);
	}

	@Override
	public List<Integer> getSalesByDay(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return salesMapper.getSalesByDay(store_id, sales_date);
	}

	@Override
	public void insertSalesAmount(int store_id, int sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
	}


}
