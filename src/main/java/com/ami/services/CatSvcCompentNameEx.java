package com.ami.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.dto.TypeDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.entity.ProductSubCategoryType;
import com.ami.exceptions.CustomException;


/*
 *  Added as part of doing the POC of giving a custom name in the @Component Annotation
 */
@Component("catSvc")
public class CatSvcCompentNameEx implements CategoryServices {

	@Override
	public ProductCategory addCategory(CategoryDTO categoryDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory updateCategory(CategoryDTO categoryDTO,
			String catGuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory getCategoryById(String guid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory getCategoryByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> getCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategory(String guid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateCategory(CategoryDTO categoryDTO)
			throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategory,
			String catGuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategory updateSubCategory(SubCategoryDTO subCategoryDTO,
			String subCatGuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategory getSubCategoryById(String subCatGuid)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategory getSubCategoryByName(String name)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSubCategory> getSubCategoryList(String id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSubCategory(String subCatGuid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductSubCategoryType addSubCategoryType(TypeDTO typeDTO,
			String subCatGuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategoryType updateSubCategoryType(TypeDTO typeDTO,
			String typeGuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategoryType getSubCategoryTypeById(String typeGuid)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSubCategoryType> getSubCategoryTypeList(String id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSubCategoryType(String typeGuid) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductSubCategoryType getSubCategoryTypeByIdAndName(String subGuid,
			String typeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
