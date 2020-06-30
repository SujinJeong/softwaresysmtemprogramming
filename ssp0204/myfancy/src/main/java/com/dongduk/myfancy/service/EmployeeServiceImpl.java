package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.CommuteDao;
import com.dongduk.myfancy.dao.EmployeeDao;
import com.dongduk.myfancy.dao.SalaryDao;
import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private CommuteDao commuteDao;
	
	@Override
	public List<Employee> getEmployeeList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeList(store_id);
	}

	@Override
	public Employee getEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(emp_id, store_id);
	}

	@Override
	public void insertEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void removeEmployee(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeDao.removeEmployee(emp_id, store_id);
	}

	@Override
	public void insertSalary(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeDao.insertSalary(employee);
	}

	@Override
	public List<Salary> getSalaryListByMonth(int store_id, String date) throws DataAccessException {
		// TODO Auto-generated method stub
		return salaryDao.getSalaryListByMonth(store_id, date);
	}

	@Override
	public void resetSalary() throws DataAccessException {
		// TODO Auto-generated method stub
		salaryDao.resetSalary();
	}

	@Override
	public void insertStartTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteDao.insertStartTime(emp_id, store_id);
	}

	@Override
	public void insertFinishTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteDao.insertFinishTime(emp_id, store_id);
	}

	@Override
	public String getStartTimeToString(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getStartTimeToString(emp_id, store_id);
	}

	@Override
	public String getFinishTimeToString(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getFinishTimeToString(emp_id, store_id);
	}

	@Override
	public List<Commute> getCommuteList(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getCommuteList(emp_id, store_id);
	}

	@Override
	public void updateWorkTime(int emp_id, int store_id, double time) throws DataAccessException {
		// TODO Auto-generated method stub
		employeeDao.updateWorkTime(emp_id, store_id, time);
	}

	@Override
	public void updateWorkTimeForSalary(int emp_id, int store_id, double time) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryDao.updateWorkTimeForSalary(emp_id, store_id, time);
	}

	@Override
	public Commute getCommuteOfToday(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getCommuteOfToday(emp_id, store_id);
	}

	@Override
	public double getWorkTimeByNow(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getWorkTimeByNow(emp_id, store_id);
	}

	@Override
	public double getWorkTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteDao.getWorkTime(emp_id, store_id);
	}

	@Override
	public void updateAmount(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryDao.updateAmount(emp_id, store_id);
	}

	@Override
	public void updateBankAndSalary(Employee employee) throws DataAccessException {
		// TODO Auto-generated method stub
		salaryDao.updateBankAndSalary(employee);
	}

	@Override
	public int getEmpSequence() throws DataAccessException {
		// TODO Auto-generated method stub
		return employeeDao.getEmpSequence();
	}

}
