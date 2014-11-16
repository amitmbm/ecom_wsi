package com.ami.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.model.User;

@Component
public class UserServicesImpl implements UserServices {

	@Autowired
	GenericDao genericDao;
	
	@Override
	public User addEntity(User user) throws Exception {
		return genericDao.addEntity(user);
	}

	@Override
	public User getEntityById(long id) throws Exception {
		String query = "from User where id = ?";
		List<Object> list = new ArrayList<>();
		list.add(id);
		return genericDao.getEntity(query, list);
	}

	@Override
	public List<User> getEntityList() throws Exception {
		String query = "from User";
		return genericDao.getEntities(query, null);
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return genericDao.deleteEntity(getEntityById(id));
	}

}
