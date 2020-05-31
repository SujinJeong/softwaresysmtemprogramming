package com.dongduk.myfancy.dao.mybatis;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dongduk.myfancy.dao.CategoryDao;
import com.dongduk.myfancy.dao.mybatis.mapper.CategoryMapper;
import com.dongduk.myfancy.domain.Category;

public class MyBatisCategoryDao implements CategoryDao {

	@Override
	public List<Category> getCategoryList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(int category_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
