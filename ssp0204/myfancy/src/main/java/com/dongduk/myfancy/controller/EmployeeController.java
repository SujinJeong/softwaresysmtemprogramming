package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.EmployeeService;
import com.dongduk.myfancy.service.EmployeeServiceImpl;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@ModelAttribute("employeeForm")
	public EmployeeForm createEmployeeForm() {
		return new EmployeeForm();
	}
	
	@RequestMapping("/store/emp")
	public String goEmp() {
		return "emp";
	}
	
	@RequestMapping("/store/emp/employer")
	public ModelAndView viewEmployeeList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("employer");
//		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
//		int store_id = store.getStore_id();
		mav.addObject("employeeList", employeeService.getEmployeeList(((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id()));
		return mav;
	}
	
	@RequestMapping("/store/emp/employer/salary")
	public ModelAndView viewSalary(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("salary");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		mav.addObject("employeeSalaryList", employeeService.getSalary(store_id));
		return mav;
	}
	
//	@RequestMapping("/store/emp/commute")
//	public void 

	
}
