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
	
	public List<Product> getProductStock(int store_id)
	{
		return stockdao.getProductStock(store_id);
	}

}
