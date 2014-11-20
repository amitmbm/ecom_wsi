package com.ami.services;

import java.util.List;

import com.ami.dto.CategoryDTO;
import com.ami.model.Category;

public interface CategoryServices {
	
	public Category addCategory(Category category) throws Exception;
	public Category getCategoryById(String guid) throws Exception;
	public List<Category> getCategoryList() throws Exception;
	public boolean deleteCategory(String guid) throws Exception;
	
	public boolean validateCategory(CategoryDTO categoryDTO) throws Exception;

}
