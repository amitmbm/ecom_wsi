package com.ami.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.dto.TypeDTO;
import com.ami.entity.ProductCategory;
import com.ami.entity.ProductSubCategory;
import com.ami.entity.ProductSubCategoryType;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;

@Component
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	GenericDao genericDao;
	

	// Adding a Category
	@Override
	public ProductCategory addCategory(CategoryDTO categoryDTO) throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCatDesc(categoryDTO.getCatdesc());
		
		String catguid= UUID.randomUUID().toString();
		productCategory.setCatGuid(catguid);
		
		productCategory.setCatName(categoryDTO.getCatname());
		return genericDao.addEntity(productCategory);
	}

	// updating a Category
	@Override
	public ProductCategory updateCategory(CategoryDTO categoryDTO, String catGuid) throws Exception {
		try{
			ProductCategory productCategory = getCategoryById(catGuid);
			if (categoryDTO.getCatdesc() != null)
				productCategory.setCatDesc(categoryDTO.getCatdesc());
			
			if(categoryDTO.getCatname() != null)
				productCategory.setCatName(categoryDTO.getCatname());
			
			return genericDao.updateEntity(productCategory);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}
	
	// Adding a Sub-Category
	@Override
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategoryDTO, String catGuid) throws Exception {
		ProductCategory productCategory = getCategoryById(catGuid);
		ProductSubCategory productSubCategory = new ProductSubCategory();
		productSubCategory.setProductCategory(productCategory);
		productSubCategory.setSubCatDesc(subCategoryDTO.getSubCatDesc());
		
		String subCatguid= UUID.randomUUID().toString();
		productSubCategory.setSubCatGuid(subCatguid);
		
		productSubCategory.setSubCatName(subCategoryDTO.getSubCatName());
		return genericDao.addEntity(productSubCategory);
	}
	
	// updating a Sub-Category
	@Override
	public ProductSubCategory updateSubCategory(SubCategoryDTO subCategoryDTO, String subCatGuid) throws Exception {
		try{
			ProductSubCategory productSubCategory = getSubCategoryById(subCatGuid);
			if (subCategoryDTO.getSubCatDesc() != null)
				productSubCategory.setSubCatDesc(subCategoryDTO.getSubCatDesc());
			
			if(subCategoryDTO.getSubCatName() != null)
				productSubCategory.setSubCatName(subCategoryDTO.getSubCatName());
			
			return genericDao.updateEntity(productSubCategory);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}
	
	// Get a Category by Id
	@Override
	public ProductCategory getCategoryById(String id) throws Exception {
		String query = "from ProductCategory where catGuid = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		ProductCategory productCategory = genericDao.getEntity(query, list);
		if (productCategory == null)
			throw new ResourceNotFoundException("Cat-id :"+ id+ " not exist");
		return productCategory;
	}
	
	// Get a Sub-Category by Id
	@Override
	public ProductSubCategory getSubCategoryById(String id) throws Exception {
		String query = "from ProductSubCategory where subCatGuid = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		ProductSubCategory productSubCategory = genericDao.getEntity(query,
				list);
		if (productSubCategory == null)
			throw new ResourceNotFoundException("Sub-catguid :" + id
					+ " not exist");
		return productSubCategory;
	}


	// get Category List	
	@Override
	public List<ProductCategory> getCategoryList() throws Exception {
		String query = "from ProductCategory";
		return genericDao.getEntities(query, null);
	}

	// get Sub-Category List	
	@Override
	public List<ProductSubCategory> getSubCategoryList() throws Exception {
		String query = "from ProductSubCategory";
		return genericDao.getEntities(query, null);
	}
	
	// delete Category by Id
	@Override
	public boolean deleteCategory(String id) throws Exception {
		return genericDao.deleteEntity(getCategoryById(id));
	}
	
	// delete SubCategory by Id
		@Override
		public boolean deleteSubCategory(String id) throws Exception {
			return genericDao.deleteEntity(getSubCategoryById(id));
		}

		
		
	@Override
	public boolean validateCategory(CategoryDTO categoryDTO) throws CustomException {
		System.out.println("inside");
		String catName = categoryDTO.getCatname();
		System.out.println("going inside the validate call");
		if (catName.isEmpty() || catName==null) 
		{
			throw new CustomException("category Name cannot be empty" , 001);
		} 

		// Should not be a reserved one
	/*	for(String reservedServiceName : reservedServiceNames) 
		{
			if(newName.equalsIgnoreCase(reservedServiceName)) 
			{
				return newName + " is a reserved name. Please specify a different service name.";
			}
		}*/

		// Should not violate the pattern
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{4,125}");
		Matcher m = p.matcher(catName);
		if(!m.matches()) 
		{
			throw new CustomException( "Category name should not contain special characters, must begin with a letter and should be between 4 and 125 characters long." ,002);
		}
		return true;
	}

	// Get a Sub-Category-type by Id
		@Override
		public ProductSubCategoryType getSubCategoryTypeById(String typeGuid) throws Exception {
			String query = "from ProductSubCategoryType where typeGuid = ?";
			List<Object> list = new ArrayList<Object>();
			list.add(typeGuid);
			ProductSubCategoryType productSubCategoryType = genericDao.getEntity(query,
					list);
			if (productSubCategoryType == null)
				throw new ResourceNotFoundException("type guid :" + typeGuid
						+ " not exist");
			return productSubCategoryType;
		}
		
	// Add a Type in sub-category
	@Override
	public ProductSubCategoryType addSubCategoryType(TypeDTO typeDTO , String subCatGuid) throws Exception {
		ProductSubCategory productSubCategory = getSubCategoryById(subCatGuid);
		ProductSubCategoryType productSubCategoryType = new ProductSubCategoryType();
		productSubCategoryType.setProductSubCategory(productSubCategory);
		productSubCategoryType.setTypeName(typeDTO.getTypeName());
		
		String typeguid= UUID.randomUUID().toString();
		productSubCategoryType.setTypeGuid(typeguid);
		
		return genericDao.addEntity(productSubCategoryType);
	}

	@Override
	public ProductSubCategoryType updateSubCategoryType(TypeDTO typeDTO,
			String typeGuid) throws Exception {
		try{
			ProductSubCategoryType productSubCategoryType = getSubCategoryTypeById(typeGuid);
			if (typeDTO.getTypeName()!= null)
				productSubCategoryType.setTypeName(typeDTO.getTypeName());
						
			return genericDao.updateEntity(productSubCategoryType);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}


	@Override
	public List<ProductSubCategoryType> getSubCategoryTypeList()
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSubCategoryType(String typeGuid) throws Exception {
		return genericDao.deleteEntity(getSubCategoryTypeById(typeGuid));
	}

		
}

