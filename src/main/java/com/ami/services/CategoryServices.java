package com.ami.services;

import java.util.List;

import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.exceptions.CustomException;

public interface CategoryServices {
	
	public ProductCategory addCategory(CategoryDTO categoryDTO) throws Exception;
	public ProductCategory updateCategory(CategoryDTO categoryDTO, String catGuid) throws Exception;
	public ProductCategory getCategoryById(String guid) throws Exception;
	public List<ProductCategory> getCategoryList() throws Exception;
	public boolean deleteCategory(String guid) throws Exception;
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategory, String catGuid) throws Exception;
	public boolean validateCategory(CategoryDTO categoryDTO) throws CustomException;

}
