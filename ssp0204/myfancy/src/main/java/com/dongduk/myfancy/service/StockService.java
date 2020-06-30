package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.StockDao;
import com.dongduk.myfancy.domain.Product;

@Service
public class StockService {
	
	@Autowired
	private StockDao stockdao;
	
	public List<Product> getProductStock(int store_id) {
		return stockdao.getProductStock(store_id);
	}

	public Product getOneProductStock(int store_id, int product_id) {
		return stockdao.getOneProductStock(store_id, product_id);
	}
	public void updateStock(int quantity, int product_id, int store_id) {
		stockdao.updateStock(quantity, product_id, store_id);
	}
	// 지점 내 재고 업데이트
	
}
