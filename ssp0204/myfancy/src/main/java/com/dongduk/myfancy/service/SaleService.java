package com.dongduk.myfancy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.myfancy.dao.ProductDao;
import com.dongduk.myfancy.dao.SaleDao;
import com.dongduk.myfancy.domain.Product;

@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;


}
