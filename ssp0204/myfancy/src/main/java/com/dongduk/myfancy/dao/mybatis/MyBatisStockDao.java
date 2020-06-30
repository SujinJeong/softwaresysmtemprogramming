package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.StockDao;
import com.dongduk.myfancy.dao.mybatis.mapper.StockMapper;
import com.dongduk.myfancy.domain.Product;

@Repository
public class MyBatisStockDao implements StockDao {

	@Autowired
	protected StockMapper stockMapper;
	
	@Override
	public List<Product> getProductStock(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return stockMapper.getProductStock(store_id);
	}
<<<<<<< HEAD
	@Override
	public void updateStock(int quantity, int product_id, int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		stockMapper.updateStock(quantity, product_id, store_id);
	}
	@Override
	public Product getOneProductStock(int store_id, int product_id) {
		// TODO Auto-generated method stub
		return stockMapper.getOneProductStock(store_id, product_id);
	}
=======

	@Override
	public void updateStock(int quantity, int product_id, int store_id) {
		// TODO Auto-generated method stub
		stockMapper.updateStock(quantity, product_id, store_id);
	}

>>>>>>> refs/remotes/origin/develop
}
