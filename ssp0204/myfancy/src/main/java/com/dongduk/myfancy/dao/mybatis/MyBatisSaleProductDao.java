package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SaleProductDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SaleProductMapper;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale_product;

@Repository
public class MyBatisSaleProductDao implements SaleProductDao {

	@Autowired
	private SaleProductMapper saleProductMapper;
	
	@Override
	public void insertSaleProduct(Sale_product sale_Product) throws DataAccessException {
		// TODO Auto-generated method stub
		saleProductMapper.insertSaleProduct(sale_Product);
	}

	@Override
	public List<Product> getSaleProductList(int store_id, int sale_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return saleProductMapper.getSaleProductList(store_id, sale_id);
	}


}
