package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;

public interface CommuteDao {

	void insertStartTime(int emp_id, int store_id) throws DataAccessException; 
	// 출근시간기록
	void insertFinishTime(int emp_id, int store_id) throws DataAccessException; 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출
	String getStartTimeToString(int emp_id, int store_id) throws DataAccessException;
	String getFinishTimeToString(int emp_id, int store_id) throws DataAccessException;
	List<Commute> getCommuteList(int emp_id, int store_id) throws DataAccessException;
	Commute getCommuteOfToday(int emp_id, int store_id) throws DataAccessException;
	double getWorkTimeByNow(int emp_id, int store_id) throws DataAccessException;
	double getWorkTime(int emp_id, int store_id) throws DataAccessException;

}
