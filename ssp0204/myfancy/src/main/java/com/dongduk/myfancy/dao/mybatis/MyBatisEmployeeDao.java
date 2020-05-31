package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.EmployeeDao;
import com.dongduk.myfancy.dao.mybatis.mapper.EmployeeMapper;
import com.dongduk.myfancy.domain.Employee;

public class MyBatisEmployeeDao implements EmployeeDao {

	@Override
	public List<Employee> getEmployeeList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWorkTime(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEmployee(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


}
