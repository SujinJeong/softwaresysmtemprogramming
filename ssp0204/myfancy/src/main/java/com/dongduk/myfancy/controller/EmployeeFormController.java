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
		
	@ModelAttribute("employeeForm")
	public EmployeeForm employeeForm() 
			throws Exception {
		return new EmployeeForm();
	}

	@RequestMapping(value = "/store/emp/employer/register", method = RequestMethod.GET)
	public String showFormRegister(@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
		formViewName = "store/emp/register";
		employeeForm.setEmployee(new Employee());
		employeeForm.setNewEmployee(true);
		return formViewName;
	}

	@RequestMapping(value = "/store/emp/employer/update/{emp_id}", method = RequestMethod.GET)
	public ModelAndView showFormUpdate(HttpServletRequest request, @PathVariable int emp_id, @ModelAttribute("employeeForm") EmployeeForm employeeForm) {
		formViewName = "store/emp/update";
		ModelAndView mav = new ModelAndView(formViewName);
		Employee emp = employeeService.getEmployee(emp_id, ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id());
		employeeForm.setEmployee(emp);
		employeeForm.setNewEmployee(false);
		mav.addObject("emp", emp);
		return mav;
	}
	
	@RequestMapping(value = {"/store/emp/employer/register", "/store/emp/employer/update/{emp_id}"}, method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult result) throws Exception {

		final int store_id = ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id();
		
//		validator.validate(employeeForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			if (employeeForm.isNewEmployee()) {
				employeeForm.getEmployee().setStore_id(store_id);
				employeeService.insertEmployee(employeeForm.getEmployee());
			}
			else {
				employeeService.updateEmployee(employeeForm.getEmployee());
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("employee.emp_name", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		return "redirect:" + successViewName;
		
	}
}
