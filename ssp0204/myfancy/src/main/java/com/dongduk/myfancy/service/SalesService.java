package com.dongduk.myfancy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.SalesDao;

@Service("salesService")
public class SalesService {
	
	@Autowired
	private SalesDao salesdao;
	
	public int getSalesByDay(Date sales_date, int store_id)
	{
		return salesdao.getSalesByDay(store_id, sales_date);
	}
	
	public int getSalesByWeek(Date sales_date, int store_id)
	{
		return salesdao.getSalesByWeek(store_id, sales_date);
	}
	
	public int getSalesByMonth(Date sales_date, int store_id)
	{
		return salesdao.getSalesByMonth(store_id, sales_date);
	}
}
