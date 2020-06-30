package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dongduk.myfancy.dao.ReceiveProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.ReceiveProductMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.StockMapper;
import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Receive_product;

@Repository
public class MyBatisReceiveProductDao implements ReceiveProductDao {

	@Autowired
	protected ReceiveProductMapper receiveproductMapper;
	
	@Autowired
	protected StockMapper stockMapper;

	@Override
	public List<Order_product> getOrderList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return receiveproductMapper.getOrderList(store_id);
	}

	@Override
	public List<Receive_product> getReceiveList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return receiveproductMapper.getReceiveList(store_id);
	}

	@Override
	public Order_product getOrderProduct(int order_id, int product_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return receiveproductMapper.getOrderProduct(order_id, product_id);
	}

	@Override
	public void removeOrderProduct(int order_id, int product_id) throws DataAccessException {
		// TODO Auto-generated method stub
		receiveproductMapper.removeOrderProduct(order_id, product_id);
	}
	
	@Transactional
	public void updateStock(int quantity, int product_id, int store_id, int order_id) throws DataAccessException {
		// TODO Auto-generated method stub
		stockMapper.updateStock(quantity, product_id, store_id);
		receiveproductMapper.removeOrderProduct(order_id, product_id);
	}

	
}
