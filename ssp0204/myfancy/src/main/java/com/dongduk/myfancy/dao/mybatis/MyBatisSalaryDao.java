package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.SalaryDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SalaryMapper;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

@Repository
public class MyBatisSalaryDao implements SalaryDao {
	
	@Autowired
	SalaryMapper salaryMapper;


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
	
	@Transactional
	public void updateWorkTimeForSalary(int emp_id, int store_id, double time) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.updateWorkTimeForSalary(emp_id, store_id, time);
		salaryMapper.updateAmount(emp_id, store_id);
	}

	@Override
	public void updateAmount(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.updateAmount(emp_id, store_id);
	}

	@Override
	public void updateBankAndSalary(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryMapper.updateBankAndSalary(employee);
	}


}
