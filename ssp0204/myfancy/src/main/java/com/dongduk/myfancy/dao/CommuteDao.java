package com.dongduk.myfancy.dao;

import org.springframework.dao.DataAccessException;

public interface CommuteDao {

	void insertStartTime(int emp_id) throws DataAccessException; 
	// 출근시간기록
	void insertFinishTime(int emp_id) throws DataAccessException; 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출

}
