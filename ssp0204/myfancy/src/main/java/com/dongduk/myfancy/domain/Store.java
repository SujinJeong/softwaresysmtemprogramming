package com.dongduk.myfancy.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;

public class Store implements Serializable {

	private int store_id;
	private String password;
	private String store_name;
	private String address;
	private String store_num;
	
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
		store_id = 1000;
		password = "ssd1000";
		store_name = "홍대점";
		address = "홍대역 1번출구";
		store_num = "02-909-1234";
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStore_num() {
		return store_num;
	}
	public void setStore_num(String store_num) {
		this.store_num = store_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
