package com.ami.dao;

import java.util.List;

public interface GenericDao {

	public <T> T  addEntity(T user) throws Exception;
	public <T> T getEntity(String query, List<Object> values) throws Exception;
	public <T> List<T> getEntities(String query, List<Object> values) throws Exception;
	public <T> boolean deleteEntity(T delete) throws Exception;
}
