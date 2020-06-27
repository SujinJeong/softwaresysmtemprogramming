package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.myfancy.dao.SupplierDao;
import com.dongduk.myfancy.dao.mybatis.mapper.SupplierMapper;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Supplier;

@Repository
public class MyBatisSupplierDao implements SupplierDao{

	@Autowired
	protected SupplierMapper supplierMapper;
	
	@Override
	public Supplier getSupplier(int supplier_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return supplierMapper.getSupplier(supplier_id);
	}

	@Override
	public List<Supplier> getSupplierList() throws DataAccessException {
		// TODO Auto-generated method stub
		return supplierMapper.getSupplierList();
	}

	@Override
	public List<Product> getProductListBySupplier(int supplier_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return supplierMapper.getProductListBySupplier(supplier_id);
	}

	
}
