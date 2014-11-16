package com.ami.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.model.Category;

@Component
public class CategoryDaoImpl implements CategoryDao {


	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addCategory(Category category) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(category);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Category getCategoryById(long id) throws Exception {
		session = sessionFactory.openSession();
		Category category = (Category) session.load(Category.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Category> categoryList = session.createCriteria(Category.class)
				.list();
		tx.commit();
		session.close();
		return categoryList;
	}
	
	@Override
	public boolean deleteCategory(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Category.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
}
