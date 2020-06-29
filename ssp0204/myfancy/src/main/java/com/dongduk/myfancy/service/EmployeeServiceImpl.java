package com.dongduk.myfancy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.EmployeeDao;
import com.dongduk.myfancy.dao.SalaryDao;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private SalaryDao salaryDao;
	
	@Override
	public List<Employee> getEmployeeList(int store_id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeList(store_id);
	}

	@Override
	public Employee getEmployee(int emp_id, int store_id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(emp_id, store_id);
	}

	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void removeEmployee(int emp_id, int store_id) {
		// TODO Auto-generated method stub
		employeeDao.removeEmployee(emp_id, store_id);
	}

	@Override
	public void insertSalary(Employee employee) {
		// TODO Auto-generated method stub
		salaryDao.insertSalary(employee);
	}

	@Override
	public List<Salary> getSalaryListByMonth(int store_id, String date) {
		// TODO Auto-generated method stub
		return salaryDao.getSalaryListByMonth(store_id, date);
	}

	@Override
	public void resetSalary() {
		// TODO Auto-generated method stub
		salaryDao.resetSalary();
	}

}
