package com.dongduk.myfancy.controller;

import java.io.Serializable;

import com.dongduk.myfancy.domain.Employee;

public class EmployeeForm implements Serializable {

	private Employee employee;

	private boolean newEmployee;
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setNewEmployee(boolean newEmployee) {
		this.newEmployee = newEmployee;
	}

	public EmployeeForm() {
		super();
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public boolean isNewEmployee() {
		return newEmployee;
	}
}
