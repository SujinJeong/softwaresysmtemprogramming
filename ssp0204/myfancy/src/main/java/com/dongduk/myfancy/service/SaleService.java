package com.dongduk.myfancy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;

	void insertSale(int store_id, List<Sale_product>saleProductList, int amount) {
		saleDao.insertSale(store_id, saleProductList, amount);
	}
   	// 결제가 이루어진 시간 등 정보 저장
	
   	Sale getSale(int sale_id, int store_id) {
   		return saleDao.getSale(sale_id, store_id);
   	}
   	// 판매 정보
   	
   	List<Sale> getSaleList(int store_id, Date date){
   		return saleDao.getSaleList(store_id, date);
   	}
   	// 판매 리스트
   	
   	
}
