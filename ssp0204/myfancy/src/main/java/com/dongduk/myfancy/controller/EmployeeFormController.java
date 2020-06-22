package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.service.EmployeeFormValidator;
import com.dongduk.myfancy.service.EmployeeServiceImpl;
import com.dongduk.myfancy.controller.EmployeeForm;
import com.dongduk.myfancy.domain.Store;

@Controller
@RequestMapping({"/store/emp/employer/register","/store/emp/employer/update/{emp_id}"})
public class EmployeeFormController {
	
	@Value("store/emp/register")
	private String registerViewName;
	@Value("store/emp/update")
	private String updateViewName;
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
	public EmployeeForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		return new EmployeeForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return registerViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult result) throws Exception {

		final int store_id = ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id();
		
//		validator.validate(employeeForm, result);
		
		if (result.hasErrors()) return registerViewName;
		try {
			if (employeeForm.isNewEmployee()) {
				employeeForm.getEmployee().setStore_id(store_id);
				employeeService.insertEmployee(employeeForm.getEmployee());
				return "redirect:" + registerViewName;  
			}
			else {
				employeeService.updateEmployee(store_id, employeeForm.getEmployee());
				return "redirect:" + updateViewName;  
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("employee.emp_name", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return registerViewName; 
		}
		
	}
}
