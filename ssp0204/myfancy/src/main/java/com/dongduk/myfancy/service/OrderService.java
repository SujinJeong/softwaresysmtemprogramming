package com.dongduk.myfancy.service;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.OrderDao;
import com.dongduk.myfancy.dao.OrderProductDao;

@Service
public class OrderService { //  dao를 호출하여 DB CRUD를 처리 후 Controller로 반환,,여러 DAO를 호출하여 사용자의 요구에 맞게 가공한다.
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderProductDao orderproductDao;
	
	// 지점에서 발주 신청한 목록 리스트
	public List<Order> getOrderListByStore(int store_id) throws DataAccessException{
		return orderDao.getOrderListByStore(store_id);
	}
	
	// 발주 조회 ex. 발주 번호 3 : 펜1 지우개 2
	public Order getOrder(int order_id, int store_id) throws DataAccessException{
		return orderDao.getOrder(order_id, store_id);
	}
	
	// 발주 등록
	public void insertOrder(Order order) throws DataAccessException{
		orderDao.insertOrder(order);
	}
	
	// 발주 상품 리스트
	public List<Order_product> getOrderProductList(int store_id, int order_id) throws DataAccessException{
		return orderproductDao.getOrderProductList(store_id, order_id);
	}
	
	// 발주 상품 저장
	public void insertOrderProduct(Order_product order_product) throws DataAccessException{
		orderproductDao.insertOrderProduct(order_product);
	}
	
	
}
