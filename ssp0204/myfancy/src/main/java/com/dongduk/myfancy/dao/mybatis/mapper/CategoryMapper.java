package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.List;


import com.dongduk.myfancy.domain.Category;

public interface CategoryMapper {

	List<Category> getCategoryList();
	
	Category getCategory(int category_id);   
}
