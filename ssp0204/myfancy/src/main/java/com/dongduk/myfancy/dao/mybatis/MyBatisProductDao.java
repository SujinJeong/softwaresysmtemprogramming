package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.ProductMapper;
import com.dongduk.myfancy.domain.Product;

@Repository
public class MyBatisProductDao implements ProductDao {

	@Override
	public List<Product> getProductListByCategory(int category_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int product_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
