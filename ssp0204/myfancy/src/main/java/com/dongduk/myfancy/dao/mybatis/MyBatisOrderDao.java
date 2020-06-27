package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.OrderDao;
import com.dongduk.myfancy.dao.mybatis.mapper.OrderMapper;
import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;

@Repository
public class MyBatisOrderDao implements OrderDao {

	@Autowired
	protected OrderMapper orderMapper;
	
	@Override
	public List<Order> getOrderListByStore(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return orderMapper.getOrderListByStore(store_id);
	}

	@Override
	public Order getOrder(int order_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return orderMapper.getOrder(order_id, store_id);
	}

	@Override
	public void insertOrder(List<Order_product> orderProductList, int store_id, int amount) throws DataAccessException {
		// TODO Auto-generated method stub
		orderMapper.insertOrder(orderProductList, store_id, amount);
	}


}
