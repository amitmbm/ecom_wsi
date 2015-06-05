package com.wsi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsi.dao.GenericDao;
import com.wsi.entity.Acls;
import com.wsi.exceptions.ResourceNotFoundException;

@Service
public class AclsServicesImpl implements AclsServices {

	@Autowired
	GenericDao genericDao;

	@Override
	@Transactional
	public Acls createAcls(Acls acls) throws Exception {
		try {
			return updateAcls(acls, getAclsByGrpResPerm(acls.getGroups().getName(), acls.getResources()
					.getName(), acls.getPermissions().getName()).getId());
		} catch (ResourceNotFoundException re) {
			acls.setId(UUID.randomUUID().toString());
			return genericDao.addEntity(acls);
		}
	}

	@Override
	@Transactional
	public Acls updateAcls(Acls acls, String id) throws Exception {
		try {
			Acls acls1 = getAclsById(id);
			if (acls.getGroups().getName() != null)
				acls1.getGroups().setName((acls.getGroups().getName()));

			if (acls.getResources().getName() != null)
				acls1.getResources().setName(acls.getResources().getName());

			if(acls.getPermissions().getName() !=null)
				acls1.getPermissions().setName(acls.getPermissions().getName());

			acls1.setUpdatedAt(null);
			return genericDao.updateEntity(acls1);
		} catch (ResourceNotFoundException re) {
			throw re;
		}
	}

	@Override
	@Transactional
	public Acls getAclsById(String id) throws Exception {
		String query = "from Acls where id = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		Acls acls = genericDao.getEntity(query, list);
		if (acls == null)
			throw new ResourceNotFoundException("Acls-id :" + id + " not exist");
		return acls;
	}

	@Override
	@Transactional
	public Acls getAclsByGrpResPerm(String grp, String res, String perm)
			throws Exception {
		String query = "from Acls where groups.name= ? and resources.name =? and permissions.name =?";
		List<Object> list = new ArrayList<Object>();
		list.add(grp);
		list.add(res);
		list.add(perm);
		Acls acls = genericDao.getEntity(query, list);
		if (acls == null)
			throw new ResourceNotFoundException("Given Acls Name not exist");
		return acls;
	}

	@Override
	@Transactional
	public List<Acls> getAclsList() throws Exception {
		String query = "from Acls";
		return genericDao.getEntities(query, null);
	}

	@Override
	@Transactional
	public boolean deleteAcls(String id) throws Exception {
		return genericDao.deleteEntity(getAclsById(id));
	}

}
