package com.wsi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.dto.GroupsDTO;
import com.wsi.entity.Groups;
import com.wsi.entity.Groups;
import com.wsi.entity.ProductCategory;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class GroupsServicesImpl implements GroupsServices {
	
	@Autowired
	GenericDao genericDao;

	@Override
	@Transactional
	public Groups CreateGroup(GroupsDTO groupsDTO) throws Exception {
		try{
			Groups groups = getGroupByName(groupsDTO.getName());
			updateGroup(groupsDTO, groups.getId());
			return groups;
		}
		catch (ResourceNotFoundException re) {
			Groups groups = new Groups();
			groups.setName(groupsDTO.getName());

			groups.setId(UUID.randomUUID().toString());
            
			groups.setType(groupsDTO.getType());
			
			Date now = new Date();
			groups.setCreatedAt(now);
			groups.setUpdatedAt(now);
			return genericDao.addEntity(groups);
		}
	}

	@Override
	@Transactional
	public Groups updateGroup(GroupsDTO groupDTO, String id) throws Exception {
		try{
			Groups groups = getGroupById(id);
			if (groupDTO.getName() != null)
				groups.setName(groupDTO.getName());

			if(groupDTO.getType() != null)
				groups.setType(groupDTO.getType());
            
			groups.setUpdatedAt(new Date());
			return genericDao.updateEntity(groups);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	@Override
	@Transactional
	public Groups getGroupById(String id) throws Exception {
		String query = "from Groups where id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		Groups groups = genericDao.getEntity(query, list);
		if (groups == null)
			throw new ResourceNotFoundException("Group-id :"+ id+ " not exist");
		return groups;
	}

	@Override
	@Transactional
	public List<Groups> getGroupList() throws Exception {
		String query = "from Groups";
		return genericDao.getEntities(query, null);
	}

	@Override
	@Transactional
	public boolean deleteGroup(String id) throws Exception {
		return genericDao.deleteEntity(getGroupById(id));
	}

	@Override
	@Transactional
	public Groups getGroupByName(String name) throws Exception {
		String query = "from Groups where name = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		Groups groups = genericDao.getEntity(query, list);
		if (groups == null)
			throw new ResourceNotFoundException("Group Name :"+ name+ " not exist");
		return groups;
	}

}
