package com.dongduk.myfancy.domain;

public class Payment {

	private int sale_id;
	private int payment_code;
	private int amount;
	
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getPayment_code() {
		return payment_code;
	}
	public void setPayment_code(int payment_code) {
		this.payment_code = payment_code;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
