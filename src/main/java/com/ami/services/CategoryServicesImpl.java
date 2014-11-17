package com.ami.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.model.Category;

@Component
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	GenericDao genericDao;
	

	@Override
	public Category addCategory(Category category) throws Exception {
		return genericDao.addEntity(category);
	}

	@Override
	public Category getCategoryById(long id) throws Exception {
		String query = "from Category where catId = ?";
		List<Object> list = new ArrayList<>();
		list.add(id);
		return genericDao.getEntity(query, list);
	}

	@Override
	public List<Category> getCategoryList() throws Exception {
		String query = "from Category";
		return genericDao.getEntities(query, null);
	}

	@Override
	public boolean deleteCategory(long id) throws Exception {
		return genericDao.deleteEntity(getCategoryById(id));
	}

}
