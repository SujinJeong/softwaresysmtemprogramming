package com.dongduk.myfancy.service;

import java.util.List;


import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

public interface EmployeeService {

	List<Employee> getEmployeeList(int store_id); 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id);
	// 한 명의 직원 정보
	void insertEmployee(Employee employee); 
	// 직원 등록
	void updateEmployee(Employee employee); 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id); 
	// 직원 삭제
	void insertSalary(int emp_id); 
	// 직원 한 명에 대한 급여
	List<Salary> getSalary(int store_id);  
	// 월별 급여 조회 리스트
	void resetSalary(); 
	// 모든 직원의 근무시간 초기화 (매월 1일마다 자동적으로 수행)
}
