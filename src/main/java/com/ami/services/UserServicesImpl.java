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
	public User getEntityByMailId(String MailId) throws Exception {
		String query = "from User where email = ?";
		List<Object> list = new ArrayList<>();
		list.add(MailId);
		return genericDao.getEntity(query, list);
	}
	
	@Override
	public User getEntityByFNLN(String firstName , String lastName) throws Exception {
		String query = "from User where firstName = ? and lastName = ?";
		List<Object> list = new ArrayList<>();
		list.add(firstName);
		list.add(lastName);
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

	
	@Override
	public int updateEntity(String query, List<Object> values) throws Exception {
   	query = "UPDATE User set firstName = :fn "  + 
                "WHERE id = :id";
   //	values.add(e)
   
   //Query query = session.createQuery(hql);
   //query.setParameter("salary", 1000);
   //query.setParameter("employee_id", 10);
   //int result = query.executeUpdate();
   //System.out.println("Rows affected: " + result);    	
		//return false;
		return genericDao.updateEntity(query, values);
	}
	
	

}
