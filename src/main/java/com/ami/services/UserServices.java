package com.ami.services;

import java.util.List;

import com.ami.model.User;

public interface UserServices {
	public User addEntity(User user) throws Exception;
	public User getEntityById(long id) throws Exception;
	public List<User> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
