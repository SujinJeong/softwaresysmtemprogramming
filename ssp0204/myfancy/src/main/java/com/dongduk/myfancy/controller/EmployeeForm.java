package com.dongduk.myfancy.controller;

import com.dongduk.myfancy.domain.Employee;

public class EmployeeForm {

	private Employee employee;
	
	public EmployeeForm() {
		this.employee = new Employee();
	}
	
	public EmployeeForm(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
}
