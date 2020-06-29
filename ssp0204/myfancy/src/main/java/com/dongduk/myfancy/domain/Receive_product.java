package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.util.Date;

public class Receive_product implements Serializable {
	
	private int send_id;
	private Date receive_date;
	private int product_id;
	private String product_name;
	private int sale_id;
	private int receive_quantity;
	private int order_quantity;
	public Date getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	private int loss_quantity;
	
	
	public int getSend_id() {
		return send_id;
	}
	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getReceive_quantity() {
		return receive_quantity;
	}
	public void setReceive_quantity(int receive_quantity) {
		this.receive_quantity = receive_quantity;
	}
	public int getLoss_quantity() {
		return loss_quantity;
	}
	public void setLoss_quantity(int loss_quantity) {
		this.loss_quantity = loss_quantity;
	}

}
