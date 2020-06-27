package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SaleProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SaleProductMapper;
import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Product;

@Repository
public class MyBatisSaleProductDao implements SaleProductDao {

	@Override
	public void insertSaleProduct(Cart cart) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getSaleProductListBySaleId(int store_id, int sale_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


}
