package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.ReceiveProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.ReceiveProductMapper;
import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Receive_product;

@Repository
public class MyBatisReceiveProductDao implements ReceiveProductDao {

	@Autowired
	protected ReceiveProductMapper receiveproductMapper;
	
	@Override
	public void addLossQuantity(List<Receive_product> rProductList) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calLossQuantity(List<Receive_product> rProductList, List<Order_product> oProductList)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertReciveQuantity(int store_id, Receive_product receiveProduct) throws DataAccessException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Order_product> getOrderList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receive_product> getReceiveList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
