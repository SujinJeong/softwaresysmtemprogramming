package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.ProductMapper;
import com.dongduk.myfancy.domain.Product;

@Repository
public class MyBatisProductDao implements ProductDao {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> getProductListByCategory(int category_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProductListByCategory(category_id);
	}

	@Override
	public Product getProduct(int product_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProduct(product_id);
	}

	@Override
	public List<Product> getProductList(int store_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProductList(store_id);
	}

}
