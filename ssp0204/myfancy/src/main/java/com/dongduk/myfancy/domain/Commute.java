package com.dongduk.myfancy.domain;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Commute implements Serializable {
	
	private String commute_id;
	private int emp_id;
	private Date start_time;
	private Date finish_time;
	private double worktimeOfDay;
	private String startStr;
	private String finishStr;
	private int complete;
	
	
	public String getStartStr() {
		return startStr;
	}
	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}
	public String getFinishStr() {
		return finishStr;
	}
	public void setFinishStr(String finishStr) {
		this.finishStr = finishStr;
	}
	public String getCommute_id() {
		return commute_id;
	}
	public void setCommute_id(String commute_id) {
		this.commute_id = commute_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}
	public double getWorktimeOfDay() {
		return worktimeOfDay;
	}
	public void setWorktimeOfDay(double worktimeOfDay) {
		this.worktimeOfDay = worktimeOfDay;
	}
	
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}

}
