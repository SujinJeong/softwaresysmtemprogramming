package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Supplier;

public interface SupplierDao {
	
	Supplier getSupplier(int supplier_id) throws DataAccessException;

	List<Supplier> getSupplierList() throws DataAccessException;
	
	List<Product> getProductListBySupplier(int supplier_id) throws DataAccessException;
	
}
