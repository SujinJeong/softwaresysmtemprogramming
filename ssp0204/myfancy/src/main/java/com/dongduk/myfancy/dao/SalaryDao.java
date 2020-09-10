package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

public interface SalaryDao {

	// 직원 한 명에 대한 급여
	List<Salary> getSalaryListByMonth(int store_id, String date) throws DataAccessException;  
	// 월별 급여 조회 리스트
	void resetSalary() throws DataAccessException; 
	// 모든 직원의 근무시간 초기화 (매월 1일마다 자동적으로 수행)
	void updateWorkTimeForSalary(int emp_id, int store_id, double time) throws DataAccessException; 
	void updateAmount(int emp_id, int store_id) throws DataAccessException; 
	void updateBankAndSalary(Employee employee) throws DataAccessException; 

}
