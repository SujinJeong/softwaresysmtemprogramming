package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.domain.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public List<Product> getProductListByCategory(int category_id) throws DataAccessException{
		return productDao.getProductListByCategory(category_id);
	}
	// 카테고리에 해당하는 상품 리스트
	public Product getProduct(int product_id) throws DataAccessException{
		return productDao.getProduct(product_id);
	}
	// 상품 정보
	public List<Product> getProductList (int store_id) throws DataAccessException{
		return productDao.getProductList(store_id);
	}
	// 지점 내 모든 상품 리스트 
}
