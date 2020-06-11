package com.dongduk.myfancy.dao.mybatis.mapper;


public interface CommuteMapper {

	void insertStartTime(int emp_id); 
	// 출근시간기록
	void insertFinishTime(int emp_id); 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출
	void addWorkTime(int emp_id); 
	// 해당 직원의 근무시간 추가
	int getStartTime(int emp_id);
	int getFinishTime(int emp_id);
}
