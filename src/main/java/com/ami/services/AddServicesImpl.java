package com.ami.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.PostDTO;
import com.ami.entity.PostAdd;
import com.ami.entity.ProductSubCategory;
import com.ami.entity.ProductSubCategoryType;
import com.ami.entity.Users;
import com.ami.exceptions.ResourceNotFoundException;

@Component
public class AddServicesImpl implements AddServices{
	
	@Autowired
	CategoryServices catServicesImpl;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	GenericDao genericDao;

	// post a Add
	@Override
	public PostAdd addAdd(PostDTO postDTO , String subCatGuid , String typeGuid , String mailId) throws Exception {
		/* get the objects which is required for FK constraints */
		ProductSubCategory productSubCategory = catServicesImpl.getSubCategoryById(subCatGuid);
		ProductSubCategoryType proSubCategoryType = catServicesImpl.getSubCategoryTypeById(typeGuid);
		Users user = userServices.getUserByMailId(mailId);
		
		PostAdd postAdd = new PostAdd();
		// setting the FK 
		postAdd.setProductSubCategory(productSubCategory);
		postAdd.setProductSubCategoryType(proSubCategoryType);
		postAdd.setUsers(user);
		
		// setting other params
		postAdd.setAddDesc(postAdd.getAddDesc());
		
		String addguid= UUID.randomUUID().toString();
		postAdd.setAddGuid(addguid);
		
		postAdd.setPrice(postDTO.getPrice());
		postAdd.setNegotiable(postDTO.getNegotiable());
		return genericDao.addEntity(postAdd);
	}

	// update a Add
	@Override
	public PostAdd updateAdd(PostDTO postDTO, String addGuid) throws Exception {
		try{
			PostAdd postAdd = getAddById(addGuid);
			
			if(postDTO.getAddDesc()!=null)
				postAdd.setAddDesc(postDTO.getAddDesc());
			
			if(postDTO.getNegotiable()!= null)
				postAdd.setNegotiable(postDTO.getNegotiable());
			
			// TODO :-> checking condition for the price
				postAdd.setPrice(postDTO.getPrice());
			
			return genericDao.updateEntity(postAdd);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	// get Add by ID
	@Override
	public PostAdd getAddById(String addGuid) throws Exception {
		String query = "from PostAdd where addGuid = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(addGuid);
		PostAdd postAdd = genericDao.getEntity(query, list);
		if (postAdd == null)
			throw new ResourceNotFoundException("Add-id :"+ addGuid+ " not exist");
		return postAdd;
	}

	// get list of Adds
	@Override
	public List<PostAdd> getAddList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// delete a Add
	@Override
	public boolean deleteAdd(String addGuid) throws Exception {
		return genericDao.deleteEntity(getAddById(addGuid));
	}
	
	

}
