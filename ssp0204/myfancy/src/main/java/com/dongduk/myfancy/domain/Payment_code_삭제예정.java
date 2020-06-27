package com.dongduk.myfancy.domain;

import java.io.Serializable;

public class Payment_code_삭제예정 implements Serializable {
	
	private int payment_code;
	private String payment_name;
	
	public int getPayment_code() {
		return payment_code;
	}
	public void setPayment_code(int payment_code) {
		this.payment_code = payment_code;
	}
	public String getPayment_name() {
		return payment_name;
	}
	public void setPayment_name(String payment_name) {
		this.payment_name = payment_name;
	}

}
