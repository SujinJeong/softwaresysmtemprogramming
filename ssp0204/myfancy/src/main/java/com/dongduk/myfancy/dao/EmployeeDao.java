package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Employee;

public interface EmployeeDao {

	List<Employee> getEmployeeList(int store_id) throws DataAccessException; 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id) throws DataAccessException;
	// 한 명의 직원 정보
	void addWorkTime(int emp_id) throws DataAccessException; 
	// 해당 직원의 근무시간 추가
	void insertEmployee(int store_id) throws DataAccessException; 
	// 직원 등록
	void updateEmployee(int emp_id, int store_id) throws DataAccessException; 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id) throws DataAccessException; 
	// 직원 삭제

}