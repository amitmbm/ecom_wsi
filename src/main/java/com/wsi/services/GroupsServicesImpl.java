package com.wsi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.entity.Groups;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class GroupsServicesImpl implements GroupsServices {

	@Autowired
	GenericDao genericDao;

	@Override
	@Transactional
	public Groups CreateGroup(Groups groups) throws Exception {
		try{
			return updateGroup(groups, getGroupByName(groups.getName()).getId());
		}
		catch (ResourceNotFoundException re) {
			groups.setId(UUID.randomUUID().toString());
			return genericDao.addEntity(groups);
		}
	}

	@Override
	@Transactional
	public Groups updateGroup(Groups groups , String id) throws Exception {
		try{
			Groups groups1 = getGroupById(id);
			if (groups.getName() != null)
				groups1.setName(groups.getName());

			if(groups.getType() != null)
				groups1.setType(groups.getType());

			return genericDao.updateEntity(groups1);
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
