package com.dongduk.myfancy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.dao.SaleProductDao;
import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

@Service
public class SaleService {
	
	@Autowired
	SaleDao saleDao;
	@Autowired
	SaleProductDao saleProductDao;

	public void insertSale(int store_id, List<Sale_product>saleProductList, int amount) throws DataAccessException{
		saleDao.insertSale(store_id, saleProductList, amount);
	}
   	// 결제가 이루어진 시간 등 정보 저장
   	public Sale getSale(int sale_id, int store_id) throws DataAccessException{
   		return saleDao.getSale(sale_id, store_id);
   	}
   	// 판매 정보
   	public List<Sale> getSaleList(int store_id, Date date) throws DataAccessException{
   		return saleDao.getSaleList(store_id, date);
   	}
   	
   	public void insertSaleProduct(Cart cart)  throws DataAccessException{
   		saleProductDao.insertSaleProduct(cart);
   	}
	// 최종적으로 판매되는 상품 리스트 저장
	public List<Product> getSaleProductListBySaleId(int store_id, int sale_id) throws DataAccessException{
		return saleProductDao.getSaleProductListBySaleId(store_id, sale_id);
	}
	// Receipt에서 상품명, 가격, 수량 보여주기 위한 method
}
