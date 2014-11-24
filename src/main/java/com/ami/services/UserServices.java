package com.ami.services;

import java.util.List;

import com.ami.dto.UserDTO;
import com.ami.entity.Users;

public interface UserServices {
	
	public Users addUser(UserDTO userDTO) throws Exception;
	//public Users getUsersById(String email) throws Exception;
	public Users getUserByMailId(String mailId) throws Exception;
	public List<Users> getUserList() throws Exception;
	public boolean deleteUser(String mailId) throws Exception;
	public Users updateUser(UserDTO userDTO , String mailId ) throws Exception;
	public boolean validateUser(UserDTO userDTO) throws Exception;

}
