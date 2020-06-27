package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.OrderProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.OrderProductMapper;
import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order_product;


@Repository
public class MyBatisOrderProductDao implements OrderProductDao {

	@Autowired
	protected OrderProductMapper orderproductMapper;
	
	@Override
	public List<Order_product> getOrderProductList(int store_id, int order_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return orderproductMapper.getOrderProductList(store_id, order_id);
	}

	@Override
	public void insertOrderProduct(Cart cart) throws DataAccessException {
		// TODO Auto-generated method stub
		orderproductMapper.insertOrderProduct(cart);
	}


}
