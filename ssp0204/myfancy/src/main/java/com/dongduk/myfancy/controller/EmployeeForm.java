package com.dongduk.myfancy.controller;

import java.io.Serializable;

import com.dongduk.myfancy.domain.Employee;

@SuppressWarnings("serial")
public class EmployeeForm implements Serializable {

	private Employee employee;

	private boolean newEmployee;
	
	public EmployeeForm(Employee employee) {
		this.employee = employee;
		this.newEmployee = false;
	}
	
	public EmployeeForm() {
		this.employee = new Employee();
		this.newEmployee = true;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public boolean isNewEmployee() {
		return newEmployee;
	}
}
