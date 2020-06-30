package com.dongduk.myfancy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.PaymentDao;
import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.dao.SaleProductDao;
import com.dongduk.myfancy.domain.Payment;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleProductDao saleProductDao;
	@Autowired
	private PaymentDao paymentDao;
	
	//DB필드 중 시퀀스, DATE타입 빼고 정의한 메소드
	public void insertSale(int store_id, int subSaleTotal) {
		// TODO Auto-generated method stub
		saleDao.insertSale(store_id, subSaleTotal);
	}
   	// 결제가 이루어진 시간 등 정보 저장
   	public Sale getSale(int sale_id, int store_id) {
   		return saleDao.getSale(sale_id, store_id);
   	}
   	// 판매 정보
   	
   	public List<Sale> getSaleList(int store_id, Date date){
   		return saleDao.getSaleList(store_id, date);
   	}
   	// 판매 리스트
   	
	public void insertSaleProduct(Sale_product sale_Product) {
		saleProductDao.insertSaleProduct(sale_Product);
	}
	// 최종적으로 판매되는 상품 리스트 저장
	
	public List<Product> getSaleProductList(int store_id, int sale_id){
		return saleProductDao.getSaleProductList(store_id, sale_id);
	}
	// Receipt에서 상품명, 가격, 수량 보여주기 위한 method
	
	public void insertSale(Sale sale) {
		// TODO Auto-generated method stub
		saleDao.insertSale(sale);	
	}
   	
	public void insertPayment(Payment payment) {
		paymentDao.insertPayment(payment);
	}
	public Payment getPayment() {
		return paymentDao.getPayment();
	}
}
