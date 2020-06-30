package com.dongduk.myfancy.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.dao.mybatis.mapper.ProductMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.SaleMapper;
import com.dongduk.myfancy.dao.mybatis.mapper.SalesMapper;
import com.dongduk.myfancy.domain.Sale;

@Repository
public class MyBatisSaleDao implements SaleDao {

   @Autowired
   private SaleMapper saleMapper;
   @Autowired
   private SalesMapper salesMapper;
   @Autowired
   private ProductMapper productMapper;
   
   //기존 메소드
//   @Override
//   public void insertSale(int store_id, List<Sale_product> saleProductList, int amount) throws DataAccessException {
//      // TODO Auto-generated method stub
//      saleMapper.insertSale(store_id, saleProductList, amount);
//   }
   //DB 모든 필드 정의한 메소드
//   @Override
//   public void insertSale(int sale_id, int store_id, Date sale_time,int totalamount) throws DataAccessException {
//	   saleMapper.insertSale(sale_id, store_id, sale_time, totalamount);
//   }
   
   //DB에서 시퀀스,date타입 빼고 정의한 것
   @Override
   public void insertSale(int store_id, int subSaleTotal) throws DataAccessException {
	   saleMapper.insertSale(store_id, subSaleTotal);
   }

   @Transactional
   public void insertSale(Sale sale) throws DataAccessException {
	   saleMapper.insertSale(sale);
//	   salesMapper.insertSalesAmount(sale.getStore_id(), sale.getSale_time());
//	   productMapper.
   }
   @Override
   public Sale getSale(int sale_id, int store_id) throws DataAccessException {
      // TODO Auto-generated method stub
      return saleMapper.getSale(sale_id, store_id);
   }

   @Override
   public List<Sale> getSaleList(int store_id, Date date) throws DataAccessException {
      // TODO Auto-generated method stub
      return saleMapper.getSaleList(store_id, date);
   }
}
