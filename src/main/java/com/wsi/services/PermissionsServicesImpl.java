package com.wsi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.entity.Permissions;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class PermissionsServicesImpl implements PermissionServices{

	@Autowired
	GenericDao genericDao;

	@Override
	@Transactional
	public Permissions createPermissions(Permissions permissions)
			throws Exception {
		try{
			return updatePermissions(permissions, getPermissionsByName(permissions.getName()).getId());
		}
		catch (ResourceNotFoundException re) {
			permissions.setId(UUID.randomUUID().toString());
			return genericDao.addEntity(permissions);
		}
	}

	@Override
	@Transactional
	public Permissions updatePermissions(Permissions permissions, String id)
			throws Exception {
		try{
			Permissions permissions1 = getPermissionsById(id);
			if (permissions.getName() != null)
				permissions1.setName(permissions.getName());
			return genericDao.updateEntity(permissions1);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	@Override
	@Transactional
	public Permissions getPermissionsById(String id) throws Exception {
		String query = "from Permissions where id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		Permissions permissions = genericDao.getEntity(query, list);
		if (permissions == null)
			throw new ResourceNotFoundException("Permissions-id :"+ id+ " not exist");
		return permissions;
	}

	@Override
	@Transactional
	public Permissions getPermissionsByName(String name) throws Exception {
		String query = "from Permissionss where name = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		Permissions permissions = genericDao.getEntity(query, list);
		if (permissions == null)
			throw new ResourceNotFoundException("Permissions Name :"+ name+ " not exist");
		return permissions;
	}

	@Override
	@Transactional
	public List<Permissions> getPermissionsList() throws Exception {
		String query = "from Permissions";
		return genericDao.getEntities(query, null);
	}

	@Override
	@Transactional
	public boolean deletePermissions(String id) throws Exception {
		return genericDao.deleteEntity(getPermissionsById(id));
	}

}
