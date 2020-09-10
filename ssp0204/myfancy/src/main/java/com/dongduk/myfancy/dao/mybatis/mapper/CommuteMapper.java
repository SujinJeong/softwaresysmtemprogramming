package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Commute;

public interface CommuteMapper {

	void insertStartTime(int emp_id, int store_id); 
	// 출근시간기록
	void insertFinishTime(int emp_id, int store_id); 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출
	String getStartTimeToString(int emp_id, int store_id);
	String getFinishTimeToString(int emp_id, int store_id);
	List<Commute> getCommuteList(int emp_id, int store_id);
	Commute getCommuteOfToday(int emp_id, int store_id);
	double getWorkTimeByNow(int emp_id, int store_id);
	double getWorkTime(int emp_id, int store_id);
}
