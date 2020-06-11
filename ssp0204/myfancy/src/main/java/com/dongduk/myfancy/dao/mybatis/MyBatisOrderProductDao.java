package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.OrderDao;
import com.dongduk.myfancy.dao.mybatis.mapper.OrderMapper;
import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;

public class MyBatisOrderProductDao implements OrderDao {

	@Override
	public List<Order> getOrderListByStore(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int order_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrder(List<Order_product> orderProductList, int store_id, int amount) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


}
