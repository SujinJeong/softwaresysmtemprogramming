package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.sql.Date;


public class Salary implements Serializable {
	
	private String salary_id;
	private int emp_id;
	private String emp_name;
	private String bankaccount;
	private String worktime;
	private String salary; //시급
	private Date salary_date;
	private int amount; //월급(한달의 급여금액)
	
	
	public String getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(String salary_id) {
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
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

}
