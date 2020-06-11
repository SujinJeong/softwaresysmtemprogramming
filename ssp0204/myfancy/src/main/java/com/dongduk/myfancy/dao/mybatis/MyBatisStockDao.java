package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.StockDao;
import com.dongduk.myfancy.dao.mybatis.mapper.StockMapper;
import com.dongduk.myfancy.domain.Product;

@Repository
public class MyBatisStockDao implements StockDao {

	@Override
	public List<Product> getProductStock(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
