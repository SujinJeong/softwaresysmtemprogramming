package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

public interface EmployeeService {

	int getEmpSequence() throws DataAccessException;
	List<Employee> getEmployeeList(int store_id) throws DataAccessException; 
	// 해당 지점의 모든 직원 리스트
	Employee getEmployee(int emp_id, int store_id) throws DataAccessException;
	// 한 명의 직원 정보
	void insertEmployee(Employee employee) throws DataAccessException; 
	// 직원 등록
	void updateEmployee(Employee employee) throws DataAccessException; 
	// 직원 정보수정
	void removeEmployee(int emp_id, int store_id) throws DataAccessException; 
	// 직원 삭제
	void insertSalary(Employee employee) throws DataAccessException; 
	// 직원 한 명에 대한 급여
	List<Salary> getSalaryListByMonth(int store_id, String date) throws DataAccessException;  
	// 월별 급여 조회 리스트
	void resetSalary() throws DataAccessException; 
	// 모든 직원의 근무시간 초기화 (매월 1일마다 자동적으로 수행)
	void insertStartTime(int emp_id, int store_id) throws DataAccessException; 
	// 출근시간기록
	void insertFinishTime(int emp_id, int store_id) throws DataAccessException; 
	// 퇴근 시 출근시간과 비교하여 addWorkTime()호출
	String getStartTimeToString(int emp_id, int store_id) throws DataAccessException;
	String getFinishTimeToString(int emp_id, int store_id) throws DataAccessException;
	List<Commute> getCommuteList(int emp_id, int store_id) throws DataAccessException;
	void updateWorkTime(int emp_id, int store_id, double time) throws DataAccessException; 
	void updateWorkTimeForSalary(int emp_id, int store_id, double time) throws DataAccessException;
	Commute getCommuteOfToday(int emp_id, int store_id) throws DataAccessException; 
	double getWorkTimeByNow(int emp_id, int store_id) throws DataAccessException;
	double getWorkTime(int emp_id, int store_id) throws DataAccessException;
	void updateAmount(int emp_id, int store_id) throws DataAccessException; 
	void updateBankAndSalary(Employee employee) throws DataAccessException; 
}
