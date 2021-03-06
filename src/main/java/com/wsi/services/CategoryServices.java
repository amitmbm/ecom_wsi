package com.wsi.services;

import java.util.List;

import com.wsi.dto.CategoryDTO;
import com.wsi.dto.SubCategoryDTO;
import com.wsi.dto.TypeDTO;
import com.wsi.entity.ProductCategory;
import com.wsi.entity.ProductSubCategory;
import com.wsi.entity.ProductSubCategoryType;
import com.wsi.exceptions.CustomException;

public interface CategoryServices {
	
	// category related stubs
	public ProductCategory addCategory(CategoryDTO categoryDTO) throws Exception;
	public ProductCategory updateCategory(CategoryDTO categoryDTO, String catGuid) throws Exception;
	public ProductCategory getCategoryById(String guid) throws Exception;
	public ProductCategory getCategoryByName(String name) throws Exception;
	public List<ProductCategory> getCategoryList() throws Exception;
	public boolean deleteCategory(String guid) throws Exception;
	public boolean validateCategory(CategoryDTO categoryDTO) throws CustomException;
	
	// sub-category related stubs
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategory, String catGuid) throws Exception;
	public ProductSubCategory updateSubCategory(SubCategoryDTO subCategoryDTO,String subCatGuid) throws Exception;
	public ProductSubCategory getSubCategoryById(String subCatGuid) throws Exception;
	public ProductSubCategory getSubCategoryByName(String name) throws Exception;
	public List<ProductSubCategory> getSubCategoryList(String id) throws Exception;
	public boolean deleteSubCategory(String subCatGuid) throws Exception;
	
	// sub-category type related stubs
	ProductSubCategoryType addSubCategoryType(TypeDTO typeDTO, String subCatGuid)throws Exception;
	public ProductSubCategoryType updateSubCategoryType(TypeDTO typeDTO,String typeGuid) throws Exception;
	public ProductSubCategoryType getSubCategoryTypeById(String typeGuid) throws Exception;
	public List<ProductSubCategoryType> getSubCategoryTypeList(String id) throws Exception;
	public boolean deleteSubCategoryType(String typeGuid) throws Exception;
	public ProductSubCategoryType getSubCategoryTypeByIdAndName(String subGuid,String typeName)	throws Exception;

}
