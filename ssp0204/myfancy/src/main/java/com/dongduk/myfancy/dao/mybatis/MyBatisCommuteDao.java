package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.CommuteDao;
import com.dongduk.myfancy.dao.mybatis.mapper.CommuteMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.EmployeeMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.SalaryMapper;
import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;

@Repository
public class MyBatisCommuteDao implements CommuteDao {
	
	@Autowired
	protected CommuteMapper commuteMapper;

	@Autowired
	protected EmployeeMapper employeeMapper;

	@Autowired
	protected SalaryMapper salaryMapper;

	@Override
	public void insertStartTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteMapper.insertStartTime(emp_id, store_id);
	}

	@Transactional
	public void insertFinishTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteMapper.insertFinishTime(emp_id, store_id);
		employeeMapper.updateWorkTime(emp_id, store_id, commuteMapper.getWorkTime(emp_id, store_id));
		salaryMapper.updateWorkTimeForSalary(emp_id, store_id, employeeMapper.getEmployee(emp_id, store_id).getWorktime());
		salaryMapper.updateAmount(emp_id, store_id);
	}

	@Override
	public String getStartTimeToString(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getStartTimeToString(emp_id, store_id);
	}

	@Override
	public String getFinishTimeToString(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getFinishTimeToString(emp_id, store_id);
	}

	@Override
	public List<Commute> getCommuteList(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getCommuteList(emp_id, store_id);
	}

	@Override
	public Commute getCommuteOfToday(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getCommuteOfToday(emp_id, store_id);
	}

	@Override
	public double getWorkTimeByNow(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getWorkTimeByNow(emp_id, store_id);
	}

	@Override
	public double getWorkTime(int emp_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getWorkTime(emp_id, store_id);
	}


}
