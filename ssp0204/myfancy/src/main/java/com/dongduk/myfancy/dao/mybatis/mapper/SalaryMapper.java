package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;

import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Salary;

public interface SalaryMapper {

	void insertSalary(Employee employee) ; 
	// 직원 한 명에 대한 급여
	List<Salary> getSalaryListByMonth(int store_id, String date);  
	// 월별 급여 조회 리스트
	void resetSalary(); 
	// 모든 직원의 근무시간 초기화 (매월 1일마다 자동적으로 수행)


}
