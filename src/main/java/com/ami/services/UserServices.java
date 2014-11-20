package com.ami.services;

import java.util.List;

import com.ami.dto.UserDTO;
import com.ami.model.User;

public interface UserServices {
	
	public User addUser(User user) throws Exception;
	//public User getUserById(String email) throws Exception;
	public User getUserByMailId(String mailId) throws Exception;
	public List<User> getUserList() throws Exception;
	public boolean deleteUser(String mailId) throws Exception;
	public int updateUser(String query,List<Object> values) throws Exception;
	
	
	public boolean validateUser(UserDTO userProfileDTO) throws Exception;

}
