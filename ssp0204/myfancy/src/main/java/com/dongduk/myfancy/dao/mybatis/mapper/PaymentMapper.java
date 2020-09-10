package com.dongduk.myfancy.dao.mybatis.mapper;

import com.dongduk.myfancy.domain.Payment;

public interface PaymentMapper {

	void insertPayment(Payment payment);
	Payment getPayment();
}
