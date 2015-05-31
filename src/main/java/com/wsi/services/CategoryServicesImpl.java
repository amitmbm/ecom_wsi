package com.wsi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.dto.CategoryDTO;
import com.wsi.dto.SubCategoryDTO;
import com.wsi.dto.TypeDTO;
import com.wsi.entity.ProductCategory;
import com.wsi.entity.ProductSubCategory;
import com.wsi.entity.ProductSubCategoryType;
import com.wsi.exceptions.CustomException;
import com.wsi.exceptions.ResourceNotFoundException;

/*
 * commenting some part of exception catching code ,
 * As using the spring's persistence exception translater
 * and for the DAO class , must be annoted with the @repo annotation
 * and add this postprocessor bean in the application-context.
 */
@Service
public class CategoryServicesImpl implements CategoryServices {

	@Autowired
	GenericDao genericDao;

	// Adding a Category
	@Transactional
	@Override
	public ProductCategory addCategory(CategoryDTO categoryDTO) throws Exception {
		try{
			ProductCategory productCategory = getCategoryByName(categoryDTO.getCatname());
			updateCategory(categoryDTO, productCategory.getCatGuid());
			return productCategory;
		}
		catch (ResourceNotFoundException re) {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setCatDesc(categoryDTO.getCatdesc());

			productCategory.setCatGuid(UUID.randomUUID().toString());
            
			productCategory.setCatName(categoryDTO.getCatname());
			
			Date now = new Date();
			productCategory.setCreatedAt(now);
			productCategory.setUpdatedAt(now);
			return genericDao.addEntity(productCategory);
		}
	}

	// updating a Category
	@Transactional
	@Override
	public ProductCategory updateCategory(CategoryDTO categoryDTO, String catGuid) throws Exception {
		try{
			ProductCategory productCategory = getCategoryById(catGuid);
			if (categoryDTO.getCatdesc() != null)
				productCategory.setCatDesc(categoryDTO.getCatdesc());

			if(categoryDTO.getCatname() != null)
				productCategory.setCatName(categoryDTO.getCatname());
            
			productCategory.setUpdatedAt(new Date());
			return genericDao.updateEntity(productCategory);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	// Adding a Sub-Category
	@Transactional
	@Override
	public ProductSubCategory addSubCategory(SubCategoryDTO subCategoryDTO, String catGuid) throws Exception {
	try{
			ProductSubCategory productSubCategory = getSubCategoryByName(subCategoryDTO.getSubCatName());
			updateSubCategory(subCategoryDTO, productSubCategory.getSubCatGuid());
			return productSubCategory;
		}
		catch (ResourceNotFoundException re) {
			ProductSubCategory productSubCategory = new ProductSubCategory();
			productSubCategory.setSubCatDesc(subCategoryDTO.getSubCatDesc());

			productSubCategory.setSubCatGuid(UUID.randomUUID().toString());
			// setting the catid in sub-cat table
            productSubCategory.setProductCategory(getCategoryById(catGuid));
            
			productSubCategory.setSubCatName(subCategoryDTO.getSubCatName());
			Date now = new Date();
			productSubCategory.setCreatedAt(now);
			productSubCategory.setUpdatedAt(now);
			return genericDao.addEntity(productSubCategory);
		}
	}

	// updating a Sub-Category
	@Transactional
	@Override
	public ProductSubCategory updateSubCategory(SubCategoryDTO subCategoryDTO, String subCatGuid) throws Exception {
		try{
			ProductSubCategory productSubCategory = getSubCategoryById(subCatGuid);
			if (subCategoryDTO.getSubCatDesc() != null)
				productSubCategory.setSubCatDesc(subCategoryDTO.getSubCatDesc());

			if(subCategoryDTO.getSubCatName() != null)
				productSubCategory.setSubCatName(subCategoryDTO.getSubCatName());
            
			productSubCategory.setUpdatedAt(new Date());
			return genericDao.updateEntity(productSubCategory);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	// Get a Category by Id
	@Transactional
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
	
	// Get a Category by Name
	@Transactional
	@Override
	public ProductCategory getCategoryByName(String name) throws Exception {
		String query = "from ProductCategory where catName = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		ProductCategory productCategory = genericDao.getEntity(query, list);
		if (productCategory == null)
			throw new ResourceNotFoundException("Cat Name :"+ name+ " not exist");
		return productCategory;
	}
	
	// Get Sub-cat by Name
	@Transactional
	@Override
	public ProductSubCategory getSubCategoryByName(String name) throws Exception {
		String query = "from ProductSubCategory where subCatName = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		ProductSubCategory productSubCategory = genericDao.getEntity(query, list);
		if (productSubCategory == null)
			throw new ResourceNotFoundException("Cat Name :"+ name+ " not exist");
		return productSubCategory;
	}

	// Get a Sub-Category by Id
	@Transactional
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
	@Transactional
	@Override
	public List<ProductCategory> getCategoryList() throws Exception {
		String query = "from ProductCategory";
		return genericDao.getEntities(query, null);
	}

	// get Sub-Category List in a Category
	@Transactional
	@Override
	public List<ProductSubCategory> getSubCategoryList(String catGuid) throws Exception {
		String query = "from ProductSubCategory where productCategory = ?";
		ProductCategory productCategory = getCategoryById(catGuid);
		List<Object> list = new ArrayList<Object>();
		list.add(productCategory);
		return genericDao.getEntities(query, list);
	}

	// delete Category by Id
	@Transactional
	@Override
	public boolean deleteCategory(String id) throws Exception {
		return genericDao.deleteEntity(getCategoryById(id));
	}

	// delete SubCategory by Id
	@Transactional
	@Override
	public boolean deleteSubCategory(String id) throws Exception {
		return genericDao.deleteEntity(getSubCategoryById(id));
	}


	@Transactional
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
	@Transactional
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
	@Transactional
	@Override
	public ProductSubCategoryType addSubCategoryType(TypeDTO typeDTO , String subCatGuid) throws Exception {
		try{
			ProductSubCategoryType productSubCategoryType = getSubCategoryTypeByIdAndName(subCatGuid, typeDTO.getTypeName());
			return productSubCategoryType;
		}
		catch(ResourceNotFoundException re)
		{
			ProductSubCategoryType productSubCategoryType = new ProductSubCategoryType();
			ProductSubCategory productSubCategory = getSubCategoryById(subCatGuid);
			productSubCategoryType.setProductSubCategory(productSubCategory);
			productSubCategoryType.setTypeName(typeDTO.getTypeName());

			productSubCategoryType.setTypeGuid(UUID.randomUUID().toString());
			Date now = new Date();
			productSubCategoryType.setCreatedAt(now);
			productSubCategoryType.setUpdatedAt(now);
			return genericDao.addEntity(productSubCategoryType);
		}
	}

	// update a sub-category Type
	@Transactional
	@Override
	public ProductSubCategoryType updateSubCategoryType(TypeDTO typeDTO,
			String typeGuid) throws Exception {
		try{
			ProductSubCategoryType productSubCategoryType = getSubCategoryTypeById(typeGuid);
			if (typeDTO.getTypeName()!= null)
				productSubCategoryType.setTypeName(typeDTO.getTypeName());
			
			productSubCategoryType.setUpdatedAt(new Date());   
			return genericDao.updateEntity(productSubCategoryType);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	// Get sub-category Type List
	@Transactional
	@Override
	public List<ProductSubCategoryType> getSubCategoryTypeList(String subCatGuid)
			throws Exception {
		String query = "from ProductSubCategoryType where productSubCategory = ?";
		ProductSubCategory productSubCategory = getSubCategoryById(subCatGuid);
		List<Object> list = new ArrayList<Object>();
		list.add(productSubCategory);
		return genericDao.getEntities(query, list);
	}

	
	// delete a sub-category-type
	@Transactional
	@Override
	public boolean deleteSubCategoryType(String typeGuid) throws Exception {
		return genericDao.deleteEntity(getSubCategoryTypeById(typeGuid));
	}

	// get the sub-cat type , using the primary key (subcatid and typename)
	@Transactional
	@Override
	public ProductSubCategoryType getSubCategoryTypeByIdAndName(String subGuid,
			String typeName) throws Exception {
		String query = "from ProductSubCategoryType where ProductSubCategory = ? And typeName =?";
		ProductSubCategory subCategory = getSubCategoryById(subGuid);
		List<Object> list = new ArrayList<Object>();
		list.add(subCategory);
		list.add(typeName);
		ProductSubCategoryType productSubCategoryType = genericDao.getEntity(query,
				list);
		if (productSubCategoryType == null)
			throw new ResourceNotFoundException("type guid :" + typeName
					+ " not exist");
		return productSubCategoryType;
	
	}
}

