package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Employee;

public interface EmployeeMapper {
	
	List<Employee> getEmployeeList(int store_id); 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id);
	// 한 명의 직원 정보
	void addWorkTime(int emp_id); 
	// 해당 직원의 근무시간 추가
	void insertEmployee(int store_id); 
	// 직원 등록
	void updateEmployee(int emp_id, int store_id); 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id); 
	// 직원 삭제

}
