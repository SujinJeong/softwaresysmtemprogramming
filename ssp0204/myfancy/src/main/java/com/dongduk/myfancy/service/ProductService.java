package com.dongduk.myfancy.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.domain.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Product getProduct(int product_id) {
		return productDao.getProduct(product_id);
	}
	
	public List<Product> getProductList(int store_id){
		return productDao.getProductList(store_id);
	}
	
	public List<Product> getProductListByCategory(int category_id) {
		return productDao.getProductListByCategory(category_id);
	}

}
