package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.EmployeeDao;
import com.dongduk.myfancy.dao.mybatis.mapper.EmployeeMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.SalaryMapper;
import com.dongduk.myfancy.domain.Employee;

@Repository
public class MyBatisEmployeeDao implements EmployeeDao {
	
	@Autowired
	protected EmployeeMapper employeeMapper;
	@Autowired
	protected SalaryMapper salaryMapper;

	@Override
	public void insertSalary(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.insertSalary(employee);
	}
	
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

	@Transactional
	public void insertEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.insertEmployee(employee);
		employeeMapper.insertSalary(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.updateEmployee(employee);
		salaryMapper.updateBankAndSalary(employee); 
		salaryMapper.updateWorkTimeForSalary(employee.getEmp_id(), employee.getStore_id(), employee.getWorktime());
		salaryMapper.updateAmount(employee.getEmp_id(), employee.getStore_id());
	}

	@Override
	public void removeEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.removeEmployee(emp_id, store_id);
	}

	@Transactional
	public void updateWorkTime(int emp_id, int store_id, double time) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeMapper.updateWorkTime(emp_id, store_id, time);
		salaryMapper.updateWorkTimeForSalary(emp_id, store_id, time);
	}

	@Override
	public int getEmpSequence() throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeMapper.getEmpSequence();
	}


}
