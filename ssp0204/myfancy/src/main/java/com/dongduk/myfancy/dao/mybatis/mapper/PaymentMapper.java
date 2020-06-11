package com.dongduk.myfancy.dao.mybatis.mapper;


public interface PaymentMapper {

	int makeSaleByPaymentCode(int paymentCode);
	// 카드or현금 (수단)으로 실제 결제를 하는 method

}
