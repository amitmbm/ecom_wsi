package com.ami.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.CategoryDTO;
import com.ami.exceptions.CustomException;
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
	public Category getCategoryById(String id) throws Exception {
		String query = "from Category where catguid = ?";
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
	public boolean deleteCategory(String id) throws Exception {
		return genericDao.deleteEntity(getCategoryById(id));
	}

	@Override
	public boolean validateCategory(CategoryDTO categoryDTO) throws Exception {
		System.out.println("inside");
		String catName = categoryDTO.getCatName();
		System.out.println("going inside the validate call");
		if (catName.isEmpty() || catName==null) 
		{
			throw new CustomException("category Name cannot be empty" , 001);
		} 

		// Should not be a reserved one
	/*	for(String reservedServiceName : reservedServiceNames) 
		{
			if(newName.equalsIgnoreCase(reservedServiceName)) 
			{
				return newName + " is a reserved name. Please specify a different service name.";
			}
		}*/

		// Should not violate the pattern
		Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{4,125}");
		Matcher m = p.matcher(catName);
		if(!m.matches()) 
		{
			throw new CustomException( "Category name should not contain special characters, must begin with a letter and should be between 4 and 125 characters long." ,002);
		}
		return true;
	}
}

