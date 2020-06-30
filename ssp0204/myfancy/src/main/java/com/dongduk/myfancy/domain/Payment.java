package com.dongduk.myfancy.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Payment implements Serializable {

	private int sale_id;
	private int payment_code;
	private int cardAmount;
	private int cashAmount;
	private int amount;
	private int card_num;
	
	public Payment(int subSaleTotal) {
		// TODO Auto-generated constructor stub
		this.amount = subSaleTotal;
	}
	public Payment() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int getCardAmount() {
		return cardAmount;
	}
	public void setCardAmount(int cardAmount) {
		this.cardAmount = cardAmount;
	}
	public int getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}
	public int getCard_num() {
		return card_num;
	}
	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}
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
