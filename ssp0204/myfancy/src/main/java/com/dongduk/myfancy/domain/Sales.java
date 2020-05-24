package com.dongduk.myfancy.domain;

import java.sql.Date;

public class Sales {
	
	private int sales_code;
	private Date sales_date;
	private int store_id;
	private int amount;
	
	
	public int getSales_code() {
		return sales_code;
	}
	public void setSales_code(int sales_code) {
		this.sales_code = sales_code;
	}
	public Date getSales_date() {
		return sales_date;
	}
	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
