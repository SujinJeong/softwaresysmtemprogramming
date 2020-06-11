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
		EmployeeForm employeeForm = (EmployeeForm)obj; 
		Employee employee = employeeForm.getEmployee();

		//나중에 내용 바꾸기
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.firstName", "FIRST_NAME_REQUIRED", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.lastName", "LAST_NAME_REQUIRED", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.email", "EMAIL_REQUIRED", "Email address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.phone", "PHONE_REQUIRED", "Phone number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.address1", "ADDRESS_REQUIRED", "Address (1) is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.city", "CITY_REQUIRED", "City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.state", "STATE_REQUIRED", "State is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.zip", "ZIP_REQUIRED", "ZIP is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account.country", "COUNTRY_REQUIRED", "Country is required.");
		
		if (employeeForm.isNewEmployee()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.empname", "EMP_ID_REQUIRED", "Emp ID is required.");
		}
	}
}