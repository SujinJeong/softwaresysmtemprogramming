package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.sql.Date;

public class Receive_삭제예정 implements Serializable {
	
	private int send_id;
	private Date receive_date;
	
	
	public int getSend_id() {
		return send_id;
	}
	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}
	public Date getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}


}
