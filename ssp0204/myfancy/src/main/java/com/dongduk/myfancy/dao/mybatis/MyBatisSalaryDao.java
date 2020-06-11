package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SalaryDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SalaryMapper;
import com.dongduk.myfancy.domain.Salary;

@Repository
public class MyBatisSalaryDao implements SalaryDao {

	@Override
	public void insertSalary(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Salary> getSalary(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetSalary() throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


}
