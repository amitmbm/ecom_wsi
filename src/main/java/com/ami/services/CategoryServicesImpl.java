package com.ami.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.CategoryDao;
import com.ami.model.Category;

@Component
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	CategoryDao categoryDao;
	

	@Override
	public boolean addCategory(Category category) throws Exception {
		return categoryDao.addCategory(category);
	}

	@Override
	public Category getCategoryById(long id) throws Exception {
		return categoryDao.getCategoryById(id);
	}

	@Override
	public List<Category> getCategoryList() throws Exception {
		return categoryDao.getCategoryList();
	}

	@Override
	public boolean deleteCategory(long id) throws Exception {
		return categoryDao.deleteCategory(id);
	}

}
