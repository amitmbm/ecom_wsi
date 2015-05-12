package com.wsi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.dto.PostDTO;
import com.wsi.entity.PostAdd;
import com.wsi.entity.ProductSubCategory;
import com.wsi.entity.ProductSubCategoryType;
import com.wsi.entity.Users;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class AddServicesImpl implements AddServices{
	
	@Autowired
	@Qualifier("categoryServicesImpl")
	CategoryServices catServicesImpl;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	GenericDao genericDao;

	// post a Add
	@Transactional
	@Override
	public PostAdd postAdd(PostDTO postDTO) throws Exception {
		Date now =new Date() ;
		try {
			PostAdd postAdd = getAddById(postDTO.getAddGuid());
			updateAdd(postDTO, postDTO.getAddGuid());
			return postAdd;
		} catch (ResourceNotFoundException re) {

			/* get the objects which is required for FK constraints */
			ProductSubCategory productSubCategory = catServicesImpl
					.getSubCategoryById(postDTO.getSubCatGuid());
			ProductSubCategoryType proSubCategoryType = catServicesImpl
					.getSubCategoryTypeById(postDTO.getTypeGuid());
			Users user=null;
			try{
				 user = userServices.getUserByMailId(postDTO.getMailId());
			}
			catch(ResourceNotFoundException re1)
			{
				user = new Users();
				user.setUserEmail(postDTO.getMailId());
				user.setUserPasswd("unregister");
				user.setIsRegisterd(false);
				user.setCreatedAt(now);
				user.setUpdatedAt(now);
				genericDao.addEntity(user);
			}

			PostAdd postAdd = new PostAdd();
			// setting the FK
			postAdd.setProductSubCategory(productSubCategory);
			postAdd.setProductSubCategoryType(proSubCategoryType);
			postAdd.setUsers(user);

			// setting other params
			postAdd.setAddDesc(postDTO.getAddDesc());
			postAdd.setAddGuid(UUID.randomUUID().toString());
			postAdd.setPrice(postDTO.getPrice());
			postAdd.setNegotiable(postDTO.getNegotiable());
			postAdd.setImage1(postDTO.getImage1());
			postAdd.setImage2(postDTO.getImage2());
			postAdd.setImage3(postDTO.getImage3());
			postAdd.setImage4(postDTO.getImage4());

			postAdd.setCreatedAt(now);
			postAdd.setUpdatedAt(now);

			return genericDao.addEntity(postAdd);
		}
	}

	// update a Add
	@Transactional
	@Override
	public PostAdd updateAdd(PostDTO postDTO, String addGuid) throws Exception {
		try{
			PostAdd postAdd = getAddById(addGuid);
			
			if(postDTO.getAddDesc()!=null)
				postAdd.setAddDesc(postDTO.getAddDesc());
			
			if(postDTO.getNegotiable()!= null)
				postAdd.setNegotiable(postDTO.getNegotiable());
			
			// TODO :-> checking condition for the price (As for primitive null is not supported coverted int to Integer in DTO)
			if(postDTO.getPrice() != null)
				postAdd.setPrice(postDTO.getPrice());
			
			if(postDTO.getImage1() != null)
			    postAdd.setImage1(postDTO.getImage1());
			
			if(postDTO.getImage2() != null)
			    postAdd.setImage2(postDTO.getImage2());
			
			if(postDTO.getImage3() != null)
			    postAdd.setImage3(postDTO.getImage3());
			
			if(postDTO.getImage4() != null)
			    postAdd.setImage4(postDTO.getImage4());
				
			postAdd.setUpdatedAt(new Date());
			
			return genericDao.updateEntity(postAdd);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	// get Add by ID
	@Transactional
	@Override
	@Cacheable(value="postadd")
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
	@Transactional
	@Override
	public List<PostAdd> getAddList(int low , int high) throws Exception {
		String query = "from PostAdd where price BETWEEN ? AND ?";
		List<Object> list = new ArrayList<Object>();
		list.add(low);
		list.add(high);
		List<PostAdd> postAdd = genericDao.getEntities(query, list);
		return postAdd;	
		}

	// delete a Add
	@Transactional
	@Override
	public boolean deleteAdd(String addGuid) throws Exception {
		return genericDao.deleteEntity(getAddById(addGuid));
	}
	
	// TODO :-> need to add this function in interface as well .
	// get Add List
	@Transactional
	@Override
	public List<PostAdd> getAddList(String order) throws Exception {
		String query=null;
		if(order.equalsIgnoreCase("asc"))
		 query = "from PostAdd order by price ASC";
		else
			query = "from PostAdd order by price DESC";
		return genericDao.getEntities(query, null);
	}
	

}
