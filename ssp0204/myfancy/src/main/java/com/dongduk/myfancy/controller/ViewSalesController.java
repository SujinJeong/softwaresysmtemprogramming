package com.dongduk.myfancy.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.SalesService;

@Controller
@RequestMapping("/store")
public class ViewSalesController {

	@Autowired
	private SalesService salesService;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public String list(@RequestParam(value="year", required=false) String year, 
			@RequestParam(value="month", required=false) String month,
			Model model, HttpSession session, HttpServletRequest request) throws Exception
	{
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		
		Calendar cal = Calendar.getInstance();
		if (year == null && month == null) {
			int inityear = cal.get(Calendar.YEAR);
			int initmonth = cal.get(Calendar.MONTH);
			int initdate = cal.get(Calendar.DATE);
			cal.set(inityear, initmonth, initdate);
		}
		else {
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println("year: " + Integer.parseInt(year));
			System.out.println("month: " + Integer.parseInt(month));
			System.out.println("lastday: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println(cal.getTime().getDate());
		}

		//일별매출 구하기
		model.addAttribute("salesbyday", salesService.getSalesByDay(cal.getTime(), store.getStore_id()));
		//주별매출 구하기
		// model.addAttribute("salesbyweek", salesService.getSalesByWeek(now, store.getStore_id()));
		//월별매출구하기
		model.addAttribute("salesbymonth", salesService.getSalesByMonth(cal.getTime(), store.getStore_id()));

		return "/store/sales";
	}
}
