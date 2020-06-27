package com.dongduk.myfancy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.dao.SalesDao;
import com.dongduk.myfancy.domain.Sale;

@Service
public class SalesService {
	
	@Autowired
	private SalesDao salesdao;
	
	@Autowired
	private SaleDao saledao;
	
	@SuppressWarnings("deprecation")
	public List<Integer> getSalesByDay(Date sales_date, int store_id)
	{
		List<Integer> dayTotal = new ArrayList<Integer>();
		for (int day = 1; day < sales_date.getDate(); day++)
			{
				// 그날의 매출 집계
				int salestotal = 0;
				sales_date.setDate(day);
				List<Sale> list = saledao.getSaleList(store_id, sales_date);
				
				for (int i= 0; i < list.size(); i++)
				{
					salestotal += list.get(i).getTotalamount();
					dayTotal.add(salestotal);
				}
			}
			
		return dayTotal;
	}
	
	@SuppressWarnings("deprecation")
	public List<Integer> getSalesByWeek(Date sales_date, int store_id)
	{
		List<Integer> weekTotal = new ArrayList<Integer>();
		int salesTotal = 0;
		for (int day = 1; day < sales_date.getDate(); day++)
		{
			sales_date.setDate(day);
			salesTotal += this.getSalesByDay(sales_date, store_id).get(day-1);
			// 만약 일주일의 끝인 토요일이면 주매출 추가해준 뒤, 매출값 초기화
			if (sales_date.getDay() == 6)
			{
				weekTotal.add(salesTotal);
				salesTotal = 0;
			}
		}
		return weekTotal;
	}
	
	public int getSalesByMonth(Date sales_date, int store_id)
	{
		int salesTotal = 0;
		for (int day = 1; day < this.getSalesByDay(sales_date, store_id).size(); day++)
		{
			salesTotal += this.getSalesByDay(sales_date, store_id).get(day-1);
		}
		return salesTotal;
	}
}
