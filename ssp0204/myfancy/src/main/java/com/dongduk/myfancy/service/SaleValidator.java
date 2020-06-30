package com.dongduk.myfancy.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dongduk.myfancy.domain.Payment;

@Component
public class SaleValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Payment.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {

		Payment payment = (Payment)obj;
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_num","cardNumError");
		
		if (payment.getPayment_code() == 2 && payment.getAmount() != 0 ) {
			errors.rejectValue("amount", "EXIST_AMOUNT", "결제를 완료해주세요.");
		}
		
		if (payment.getCard_num() == 0 && payment.getPayment_code() == 1 ) {
			errors.rejectValue("card_num", "CARDNUM_REQUIRED", "카드 번호를 입력해주세요.");
		}

//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.emp_name", "EMP_NAME_REQUIRED", "Employee name is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.email", "EMAIL_REQUIRED", "Email address is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.phonenum", "PHONE_REQUIRED", "Phone number is required.");
//		ValidationUtils.rejectIfEmpty(errors, "employee.address", "ADDRESS_REQUIRED", "Address is required.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employee.bankaccount", "BANK_ACCOUNT_REQUIRED", "Bankaccount is required.");
		
		
	}
}