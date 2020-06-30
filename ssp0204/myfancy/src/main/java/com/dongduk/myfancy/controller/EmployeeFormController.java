package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.service.EmployeeFormValidator;
import com.dongduk.myfancy.service.EmployeeServiceImpl;
import com.dongduk.myfancy.controller.EmployeeForm;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Store;

@Controller
public class EmployeeFormController {
	
	private String formViewName;
	@Value("/store/emp/employer")
	private String successViewName;
	
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	public void setEmployeeService(EmployeeServiceImpl employeeService) {
		this.employeeService = employeeService;
	}
	
	@Autowired
	private EmployeeFormValidator validator;
	public void setValidator(EmployeeFormValidator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(value = "/store/emp/employer/register", method = RequestMethod.GET)
	public ModelAndView showFormRegister(HttpSession session) {
		if (session.getAttribute("employerCheck") == null) return new ModelAndView("store/emp/emp");
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return new ModelAndView("store/emp/emp");
			else {
				formViewName = "store/emp/register";
				ModelAndView mav = new ModelAndView(formViewName);
				EmployeeForm employeeForm = new EmployeeForm();
				mav.addObject("employeeForm", employeeForm);
				return mav;
			}
		}		
	}
	
	@RequestMapping(value = "/store/emp/employer/update/{emp_id}", method = RequestMethod.GET)
	public ModelAndView showFormUpdate(HttpServletRequest request, HttpSession session, @PathVariable int emp_id) {
		if (session.getAttribute("employerCheck") == null) return new ModelAndView("store/emp/emp");
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return new ModelAndView("store/emp/emp");
			else {
				formViewName = "store/emp/update";
				ModelAndView mav = new ModelAndView(formViewName);
				Employee emp = employeeService.getEmployee(emp_id, ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id());
				EmployeeForm employeeForm = new EmployeeForm(emp);
				mav.addObject("employeeForm", employeeForm);
				return mav;
			}
		}		
	}
	
	@RequestMapping(value = "/store/emp/employer/register", method = RequestMethod.POST)
	public String onSubmitRegister(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult result) throws Exception {

		int store_id = ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id();
		
		validator.validate(employeeForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			employeeForm.getEmployee().setEmp_id(employeeService.getEmpSequence());
			employeeForm.getEmployee().setStore_id(store_id);
			employeeService.insertEmployee(employeeForm.getEmployee());
		}
		catch (DataIntegrityViolationException ex) {
			return formViewName; 
		}
		return "redirect:" + successViewName;
		
	}
	
	@RequestMapping(value = "/store/emp/employer/update/{emp_id}", method = RequestMethod.POST)
	public String onSubmitUpdate(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult result) throws Exception {
		
		validator.validate(employeeForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			employeeForm.getEmployee().setStore_id(((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id());
			employeeService.updateEmployee(employeeForm.getEmployee());
		}
		catch (DataIntegrityViolationException ex) {
			return formViewName; 
		}
		return "redirect:" + successViewName;
		
	}
}
