package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Employee;

public interface EmployeeMapper {

	int getEmpSequence();	
	List<Employee> getEmployeeList(int store_id); 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id);
	// 한 명의 직원 정보
	void insertEmployee(Employee employee); 
	// 직원 등록
	void insertSalary(Employee employee) ; 
	void updateEmployee(Employee employee); 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id); 
	// 직원 삭제
	void updateWorkTime(int emp_id, int store_id, double time); 

}
