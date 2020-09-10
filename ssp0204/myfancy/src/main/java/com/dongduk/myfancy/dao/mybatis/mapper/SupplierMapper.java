package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Supplier;

public interface SupplierMapper {

	Supplier getSupplier(int supplier_id);

	List<Supplier> getSupplierList();
	
	List<Product> getProductListBySupplier(int supplier_id);
}
