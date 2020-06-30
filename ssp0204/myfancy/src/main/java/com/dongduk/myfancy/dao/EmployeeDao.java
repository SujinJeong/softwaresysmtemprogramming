package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Employee;

public interface EmployeeDao {

	int getEmpSequence() throws DataAccessException;
	List<Employee> getEmployeeList(int store_id) throws DataAccessException; 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id) throws DataAccessException;
	// 한 명의 직원 정보
	void insertEmployee(Employee employee) throws DataAccessException; 
	// 직원 등록
	void insertSalary(Employee employee) throws DataAccessException; 
	// 직원 등록과 동시에 SALARY 정보 등록
	void updateEmployee(Employee employee) throws DataAccessException; 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id) throws DataAccessException; 
	// 직원 삭제
	void updateWorkTime(int emp_id, int store_id, double time) throws DataAccessException; 

}
