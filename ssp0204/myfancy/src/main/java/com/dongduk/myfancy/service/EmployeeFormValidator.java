package com.dongduk.myfancy.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dongduk.myfancy.controller.EmployeeForm;
import com.dongduk.myfancy.domain.Employee;
/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Component
public class EmployeeFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {

		//나중에 내용 바꾸기
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.emp_name", "EMP_NAME_REQUIRED", "Employee name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.phonenum", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmpty(errors, "employee.address", "ADDRESS_REQUIRED", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.bankaccount", "BANK_ACCOUNT_REQUIRED", "Bankaccount is required.");
		
		
	}
}