package com.ami.services;

import java.util.List;

import com.ami.model.Category;

public interface CategoryServices {
	
	public Category addCategory(Category category) throws Exception;
	public Category getCategoryById(long id) throws Exception;
	public List<Category> getCategoryList() throws Exception;
	public boolean deleteCategory(long id) throws Exception;

}