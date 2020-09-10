package com.dongduk.myfancy.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.domain.Category;

public interface CategoryDao {

	List<Category> getCategoryList() throws DataAccessException;
	
	Category getCategory(int category_id) throws DataAccessException;   
	
}
