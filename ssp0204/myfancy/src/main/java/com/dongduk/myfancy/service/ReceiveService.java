package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.ReceiveProductDao;
import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Receive_product;

@Service
public class ReceiveService {
	   
	@Autowired
	private ReceiveProductDao receiveproductDao;
	
	public List<Order_product> getOrderList(int store_id) {
		return receiveproductDao.getOrderList(store_id);
	}
	
	public Order_product getOrderProduct(int order_id, int product_id) {
		return receiveproductDao.getOrderProduct(order_id, product_id);
	}
	
	public List<Receive_product> getReceiveList(int store_id) {
		return receiveproductDao.getReceiveList(store_id);
	}
	
	public void insertReceiveQuantity(int store_id, List<Receive_product> rProductList)
	{
		
	}
	
	public void calLossQuantity(List<Receive_product> rProductList, List<Order_product> oProductList)
	{
	
	}
	
	public void addLossQuantity(List<Receive_product> rProductList)
	{
		
	}
	
	public void removeOrderProduct(int order_id, int product_id)
	{
		System.out.println("get in removeOrderProduct");
		receiveproductDao.removeOrderProduct(order_id, product_id);
	}
	
	public void updateStock(int quantity, int product_id, int store_id, int order_id)
	{
		System.out.println("get in updateStock");
		receiveproductDao.updateStock(quantity, product_id, store_id, order_id);
	}
}