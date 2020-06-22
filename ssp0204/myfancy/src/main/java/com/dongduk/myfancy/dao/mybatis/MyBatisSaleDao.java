package com.dongduk.myfancy.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SaleMapper;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;

@Repository
public class MyBatisSaleDao implements SaleDao {
   
   @Autowired
   private SaleMapper saleMapper;
   
   @Override
   public void insertSale(int store_id, List<Sale_product> saleProductList, int amount) throws DataAccessException {
      // TODO Auto-generated method stub
      saleMapper.insertSale(store_id, saleProductList, amount);
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
