package com.dongduk.myfancy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.EmployeeServiceImpl;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@ModelAttribute("employeeForm")
	public EmployeeForm createEmployeeForm() {
		return new EmployeeForm();
	}
	
//	@ModelAttribute("date")
//	public Date setDate() {
//		Date date = new Date();
//		date.setYear(date.getYear()+1900);
//		date.setMonth(date.getMonth()+1);
//		return date;
//		return new Date();
//	}
	
	@RequestMapping("store/emp")
	public String goEmp() {
		return "store/emp/emp";
	}
	
	@RequestMapping("store/emp/employer")
	public ModelAndView viewEmployeeList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("store/emp/employer");
//		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
//		int store_id = store.getStore_id();
		mav.addObject("employeeList", employeeService.getEmployeeList(((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id()));
		return mav;
	}
	
	@RequestMapping("store/emp/employer/salary")
	public ModelAndView viewSalary(HttpServletRequest request, @RequestParam int move, @RequestParam String year, @RequestParam String month) {
		ModelAndView mav = new ModelAndView("store/emp/salary");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		boolean now;
//		if (Integer.parseInt(year) == new Date().getYear() && Integer.parseInt(month) == new Date().getMonth())
		if (move < 0 && month.equals("0")) {
			year = Integer.toString(Integer.parseInt(year) - 1);
			month = "11";
		} else if (move > 0 && month.equals("11")) {
			year = Integer.toString(Integer.parseInt(year) + 1);
			month = "0";
		} else {
			month = Integer.toString(Integer.parseInt(month) + move);
		}
		if (Integer.parseInt(month) < 10) month = "0" + month;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		if ((year+month).equals(sdf.format(new Date())))
			now = true;
		else
			now = false;
		System.out.println(now);
		mav.addObject("employeeSalaryList", employeeService.getSalaryListByMonth(store_id, year+month));
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("now", now);
		return mav;
	}

	@RequestMapping("store/emp/employer/remove/{emp_id}")
	public ModelAndView removeEmp(HttpServletRequest request, @PathVariable int emp_id ) {
		ModelAndView mav = new ModelAndView("redirect:/store/emp/employer");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		employeeService.removeEmployee(emp_id, store_id);
		return mav;
	}

	@RequestMapping("store/emp/employer/update")
	public String updateEmp(@RequestParam int empId ) {
//		ModelAndView mav = new ModelAndView("redirect:/store/emp/employer/update/" + empId);
//		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
//		int store_id = store.getStore_id();
//		Employee emp = employeeService.getEmployee(empId, store_id);
//		mav.addObject("emp", emp);
		return "redirect:/store/emp/employer/update/" + empId;
	}
//	@RequestMapping("/store/emp/commute")
//	public void 

	
}
