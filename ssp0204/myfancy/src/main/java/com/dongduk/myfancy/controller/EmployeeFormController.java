package com.dongduk.myfancy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongduk.myfancy.service.EmployeeFormValidator;
import com.dongduk.myfancy.service.EmployeeService;
import com.dongduk.myfancy.controller.EmployeeForm;

@Controller
@RequestMapping({"/store/emp/employer/register","/store/emp/employer/update/{emp_id}"})
public class EmployeeFormController {
	
	@Value("EditAccountForm")
	private String formViewName;
	@Value("index")
	private String successViewName;
	
	@Autowired
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
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
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			HttpServletRequest request, HttpSession session,
			@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult result) throws Exception {

//		if (request.getParameter("account.listOption") == null) {
//			accountForm.getAccount().setListOption(false);
//		}
//		if (request.getParameter("account.bannerOption") == null) {
//			accountForm.getAccount().setBannerOption(false);
//		}
//		
//		validator.validate(accountForm, result);
//		
//		if (result.hasErrors()) return formViewName;
//		try {
//			if (accountForm.isNewAccount()) {
//				petStore.insertAccount(accountForm.getAccount());
//			}
//			else {
//				petStore.updateAccount(accountForm.getAccount());
//			}
//		}
//		catch (DataIntegrityViolationException ex) {
//			result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
//					"User ID already exists: choose a different ID.");
//			return formViewName; 
//		}
//		
//		UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(
//			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
		return successViewName;  
	}
}
