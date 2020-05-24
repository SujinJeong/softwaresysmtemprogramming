package com.dongduk.myfancy.domain;

import java.sql.Date;

public class Send {

	private int send_id;
	private int supplier_id;
	private int order_id;
	private Date send_date;
	private int check_receive;
	
	
	public int getSend_id() {
		return send_id;
	}
	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public int getCheck_receive() {
		return check_receive;
	}
	public void setCheck_receive(int check_receive) {
		this.check_receive = check_receive;
	}
}
