package com.ami.services;

import java.util.List;

import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.dto.TypeDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.entity.ProductSubCategoryType;
import com.ami.exceptions.CustomException;

public interface CategoryServices {
	
	// category related stubs
	public ProductCategory addCategory(CategoryDTO categoryDTO) throws Exception;
	public ProductCategory updateCategory(CategoryDTO categoryDTO, String catGuid) throws Exception;
	public ProductCategory getCategoryById(String guid) throws Exception;
	public List<ProductCategory> getCategoryList() throws Exception;
	public boolean deleteCategory(String guid) throws Exception;
	public boolean validateCategory(CategoryDTO categoryDTO) throws CustomException;
	
	// sub-category related stubs
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategory, String catGuid) throws Exception;
	public ProductSubCategory updateSubCategory(SubCategoryDTO subCategoryDTO,String subCatGuid) throws Exception;
	public ProductSubCategory getSubCategoryById(String subCatGuid) throws Exception;
	public List<ProductSubCategory> getSubCategoryList() throws Exception;
	boolean deleteSubCategory(String subCatGuid) throws Exception;
	
	// sub-category type related stubs
	ProductSubCategoryType addSubCategoryType(TypeDTO typeDTO, String subCatGuid)throws Exception;
	public ProductSubCategoryType updateSubCategoryType(TypeDTO typeDTO,String typeGuid) throws Exception;
	public ProductSubCategoryType getSubCategoryTypeById(String typeGuid) throws Exception;
	public List<ProductSubCategoryType> getSubCategoryTypeList() throws Exception;
	boolean deleteSubCategoryType(String typeGuid) throws Exception;

}
