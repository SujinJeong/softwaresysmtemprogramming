package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.sql.Date;


public class Salary implements Serializable {
	
	private int salary_id;
	private int emp_id;
	private Date salary_date;
	private int amount; //월급(한달의 급여금액)
	
	
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Date getSalary_date() {
		return salary_date;
	}
	public void setSalary_date(Date salary_date) {
		this.salary_date = salary_date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
