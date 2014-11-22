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
			tx.commit();
			session.close();
			return entity;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}

/*
 * (non-Javadoc)
 * @see com.ami.dao.GenericDao#getEntity(java.lang.String, java.util.List)
 * need to change it to just one value
 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEntity(String query, List<Object> values) throws Exception {
		T entity = null;
		try{
			session = sessionFactory.openSession();
			//tx = session.getTransaction();
			tx = session.beginTransaction();
			Query sqlQuery = session.createQuery(query);

			if (values != null && values.size() > 0){
				for (int i = 0; i < values.size() ; i++){
					sqlQuery.setParameter(i, values.get(i));
				}
			}
			entity = (T)sqlQuery.uniqueResult();
			tx.commit();
			session.close();
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
			session.close();
		}catch(Exception e){
			e.printStackTrace();
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
			session.close();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return false;
	}
	
    @Override
	public <T> int updateEntity(String query, List<Object> values)throws Exception {  
	     int result=0;
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
		    result = sqlQuery.executeUpdate();
			tx.commit();
			session.close();
    	}
    	catch(Exception e){
			e.printStackTrace();
			tx.rollback();	
		}
		return result;
}

	@Override
	public <T> T updateEntity(T entity) throws Exception {

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
			session.close();
			return entity;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
}