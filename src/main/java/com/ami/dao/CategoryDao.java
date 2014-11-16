package com.ami.dao;

import java.util.List;

import com.ami.model.Category;

public interface CategoryDao {
	
	public boolean addCategory(Category category) throws Exception;
	public Category getCategoryById(long id) throws Exception;
	public List<Category> getCategoryList() throws Exception;
	public boolean deleteCategory(long id) throws Exception;

}
