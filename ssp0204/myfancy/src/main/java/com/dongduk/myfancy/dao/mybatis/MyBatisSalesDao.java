package com.dongduk.myfancy.dao.mybatis;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.SalesDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SalesMapper;

public class MyBatisSalesDao implements SalesDao {

	@Override
	public int getSalesByMonth(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSalesByWeek(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSalesByDay(int store_id, Date sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertSalesAmount(int store_id, int sales_date) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


}
