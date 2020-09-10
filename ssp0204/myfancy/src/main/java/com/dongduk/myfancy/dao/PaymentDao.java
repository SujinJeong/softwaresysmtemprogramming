package com.dongduk.myfancy.dao;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Payment;

public interface PaymentDao {
	
	void insertPayment(Payment payment) throws DataAccessException;
	//간이영수증 출력을 위해 결제수단 저장하는 메소드
	Payment getPayment() throws DataAccessException;
}
