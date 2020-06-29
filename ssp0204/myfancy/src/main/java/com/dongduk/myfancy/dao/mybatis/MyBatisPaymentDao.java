package com.dongduk.myfancy.dao.mybatis;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.PaymentDao;
import com.dongduk.myfancy.dao.mybatis.mapper.PaymentMapper;

@Repository
public class MyBatisPaymentDao implements PaymentDao {

	@Override
	public int makeSaleByPaymentCode(int paymentCode) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
}
