package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.EmployeeDao;
import com.dongduk.myfancy.dao.mybatis.mapper.EmployeeMapper;
import com.dongduk.myfancy.domain.Employee;

@Repository
public class MyBatisEmployeeDao implements EmployeeDao {
	
	@Autowired
	protected EmployeeMapper employeeMapper;

	@Override
	public List<Employee> getEmployeeList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployeeList(store_id);
	}

	@Override
	public Employee getEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployee(emp_id, store_id);
	}

	@Override
	public void insertEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.updateEmployee(employee);
	}

	@Override
	public void removeEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.removeEmployee(emp_id, store_id);
	}


}
