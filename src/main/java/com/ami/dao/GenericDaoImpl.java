package com.ami.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericDaoImpl implements GenericDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;


	@Override
	public <T> T addEntity(T entity) throws Exception {
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(entity);
			session.close();
			tx.commit();
			return entity;
		}catch(Exception e){
			tx.rollback();
		}
		finally{

		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEntity(String query, List<Object> values) throws Exception {
		T entity = null;
		try{
			session = sessionFactory.openSession();
			tx = session.getTransaction();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);

			if (values != null && values.size() > 0){
				for (int i = 0; i < values.size() ; i++){
					sqlQuery.setParameter(i, values.get(i));
				}
			}
			entity = (T)sqlQuery.uniqueResult();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();	
		}
		return entity;
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getEntities(String query, List<Object> values)
			throws Exception {
		List<T> entities = null;
		try{
			session = sessionFactory.openSession();
			tx = session.getTransaction();
			session.beginTransaction();
			Query sqlQuery = session.createQuery(query);

			if (values != null && values.size() > 0){
				for (int i = 0; i < values.size() ; i++){
					sqlQuery.setParameter(i, values.get(i));
				}
			}
			entities = sqlQuery.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();	
		}
		return entities;
	}

	@Override
	public <T> boolean deleteEntity(T delete) throws Exception {
		try{
			session = sessionFactory.openSession();
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(delete);
			tx.commit();
			return true;
		}
		catch(Exception e){
			tx.rollback();
		}
		return false;
	};
}
