package com.dongduk.myfancy.domain;

public class Receive_product {
	
	private int send_id;
	private int product_id;
	private int sale_id;
	private int receive_quantity;
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
