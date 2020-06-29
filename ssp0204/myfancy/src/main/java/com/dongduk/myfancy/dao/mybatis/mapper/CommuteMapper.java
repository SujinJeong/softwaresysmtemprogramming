package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;

public interface CommuteMapper {

	void insertStartTime(int emp_id); 
	// 출근시간기록
	void insertFinishTime(int emp_id); 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출
	int getStartTime(int emp_id);
	int getFinishTime(int emp_id);
	List<Commute> getCommuteList(int emp_id);
	Commute getCommuteOfToday(int emp_id);
}
