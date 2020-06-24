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
	ReceiveProductDao receiveproductDao;
	
	public List<Order_product> getOrderList(int store_id) {
		return receiveproductDao.getOrderList(store_id);
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
}