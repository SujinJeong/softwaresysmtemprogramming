package com.dongduk.myfancy.dao;

import org.springframework.dao.DataAccessException;

public interface PaymentDao {
	
	int makeSaleByPaymentCode(int paymentCode) throws DataAccessException;
	// 카드or현금 (수단)으로 실제 결제를 하는 method

}
