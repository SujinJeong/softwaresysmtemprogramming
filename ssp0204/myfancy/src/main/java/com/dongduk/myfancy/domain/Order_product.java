package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.sql.Date;

public class Order_product implements Serializable {

	private int product_id;
	private int order_id;
	private int sale_id;
	private int quantity;
	private Date order_date;
	private int amount;
	private String product_name;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
