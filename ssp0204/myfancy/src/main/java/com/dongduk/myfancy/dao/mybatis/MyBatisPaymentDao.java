package com.dongduk.myfancy.dao.mybatis;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.PaymentDao;
import com.dongduk.myfancy.dao.mybatis.mapper.PaymentMapper;

public class MyBatisPaymentDao implements PaymentDao {

	@Override
	public int makeSaleByPaymentCode(int paymentCode) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}


}
