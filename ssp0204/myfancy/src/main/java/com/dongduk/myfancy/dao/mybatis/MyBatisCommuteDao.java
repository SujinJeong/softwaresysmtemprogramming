package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.CommuteDao;
import com.dongduk.myfancy.dao.mybatis.mapper.CommuteMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.EmployeeMapper;
import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;

@Repository
public class MyBatisCommuteDao implements CommuteDao {
	
	@Autowired
	protected CommuteMapper commuteMapper;

	@Autowired
	protected EmployeeMapper employeeMapper;

	@Override
	public void insertStartTime(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteMapper.insertStartTime(emp_id);
	}

	@Override
	public void insertFinishTime(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		commuteMapper.insertFinishTime(emp_id);
	}

	@Override
	public int getStartTime(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getStartTime(emp_id);
	}

	@Override
	public int getFinishTime(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getFinishTime(emp_id);
	}

	@Override
	public List<Commute> getCommuteList(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getCommuteList(emp_id);
	}

	@Override
	public Commute getCommuteOfToday(int emp_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return commuteMapper.getCommuteOfToday(emp_id);
	}


}
