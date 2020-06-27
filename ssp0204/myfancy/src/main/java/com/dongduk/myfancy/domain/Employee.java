package com.dongduk.myfancy.domain;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int emp_id;
	private int store_id;
	private String emp_name;
	private String address;
	private String phonenum;
	private String email;
	private double worktime;
	private String bankaccount;
	private int salary; //시급
	
	public Employee(int emp_id, int store_id) {
		super();
		this.emp_id = emp_id;
		this.store_id = store_id;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getWorktime() {
		return worktime;
	}
	public void setWorktime(double worktime) {
		this.worktime = worktime;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
