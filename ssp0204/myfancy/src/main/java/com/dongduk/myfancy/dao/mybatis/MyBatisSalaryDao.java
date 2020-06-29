package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SalaryDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SalaryMapper;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

@Repository
public class MyBatisSalaryDao implements SalaryDao {
	
	@Autowired
	SalaryMapper salaryMapper;

	@Override
	public void insertSalary(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.insertSalary(employee);
	}

	@Override
	public List<Salary> getSalaryListByMonth(int store_id, String date) throws DataAccessException {
		// TODO Auto-generated method stub
		return salaryMapper.getSalaryListByMonth(store_id, date);
	}

	@Override
	public void resetSalary() throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.resetSalary();
	}
	
	@Override
	public void updateWorkTimeForSalary(int emp_id, double time) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.updateWorkTimeForSalary(emp_id, time);
	}


}
