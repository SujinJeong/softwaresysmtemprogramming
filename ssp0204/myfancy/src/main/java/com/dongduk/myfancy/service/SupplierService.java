package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.SupplierDao;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Supplier;

@Service
public class SupplierService {

	@Autowired
	SupplierDao supplierDao;
	
	public Supplier getSupplier(int supplier_id){
		return supplierDao.getSupplier(supplier_id);
	}
	
	public List<Supplier> getSupplierList(){
		return supplierDao.getSupplierList();
	}
	
	public List<Product> getProductListBySupplier(int supplier_id){
		return supplierDao.getProductListBySupplier(supplier_id);
	}
	
}
