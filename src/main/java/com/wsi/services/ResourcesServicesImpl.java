package com.wsi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.entity.Resources;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class ResourcesServicesImpl implements ResourcesServices {

	@Autowired
	GenericDao genericDao;

	@Override
	@Transactional
	public Resources CreateResource(Resources resources) throws Exception {
		try{
			getResourceByName(resources.getName());
			return updateResource(resources, resources.getId());
		}
		catch (ResourceNotFoundException re) {
			resources.setName(resources.getName());
			resources.setId(UUID.randomUUID().toString());
			Date now = new Date();
			resources.setCreatedAt(now);
			resources.setUpdatedAt(now);
			return genericDao.addEntity(resources);
		}
	}

	@Override
	@Transactional
	public Resources updateResource(Resources resources, String id)
			throws Exception {
		try{
			Resources resources1 = getResourceById(id);
			if (resources.getName() != null)
				resources1.setName(resources.getName());

			resources1.setUpdatedAt(new Date());
			return genericDao.updateEntity(resources1);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	@Override
	@Transactional
	public Resources getResourceById(String id) throws Exception {
		String query = "from Resources where id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		Resources resources = genericDao.getEntity(query, list);
		if (resources == null)
			throw new ResourceNotFoundException("Resource-id :"+ id+ " not exist");
		return resources;
	}

	@Override
	@Transactional
	public Resources getResourceByName(String name) throws Exception {
		String query = "from Resources where name = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		Resources Resources = genericDao.getEntity(query, list);
		if (Resources == null)
			throw new ResourceNotFoundException("Resource Name :"+ name+ " not exist");
		return Resources;
	}

	@Override
	@Transactional
	public List<Resources> getResourceList() throws Exception {
		String query = "from Resources";
		return genericDao.getEntities(query, null);
	}

	@Override
	@Transactional
	public boolean deleteResource(String id) throws Exception {
		return genericDao.deleteEntity(getResourceById(id));
	}

}
