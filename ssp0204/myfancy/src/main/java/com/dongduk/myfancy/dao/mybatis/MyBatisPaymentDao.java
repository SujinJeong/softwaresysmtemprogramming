package com.dongduk.myfancy.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.PaymentDao;
import com.dongduk.myfancy.dao.mybatis.mapper.PaymentMapper;
import com.dongduk.myfancy.domain.Payment;

@Repository
public class MyBatisPaymentDao implements PaymentDao {

	@Autowired
	private PaymentMapper paymentMapper;
	
	@Override
	public void insertPayment(Payment payment) throws DataAccessException {
		// TODO Auto-generated method stub
		paymentMapper.insertPayment(payment);
	}

	@Override
	public Payment getPayment() throws DataAccessException {
		// TODO Auto-generated method stub
		return paymentMapper.getPayment();
	}

	
}
