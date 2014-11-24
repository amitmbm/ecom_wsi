package com.ami.services;

import java.util.List;

import com.ami.dto.UserDTO;
import com.ami.dto.UserProfileDTO;
import com.ami.entity.UserProfileId;
import com.ami.entity.Users;

public interface UserServices {
	
	public Users addUser(UserDTO userDTO) throws Exception;
	public Users getUserByMailId(String mailId) throws Exception;
	public List<Users> getUserList() throws Exception;
	public boolean deleteUser(String mailId) throws Exception;
	public Users updateUser(UserDTO userDTO , String mailId ) throws Exception;
	//public boolean validateUser(UserDTO userDTO) throws Exception;

	// user-profile related functions
	public UserProfileId addUserProfile(UserProfileDTO userProfileDTO) throws Exception;
	public UserProfileId getUserProfileByMailId(String mailId) throws Exception;
	public List<UserProfileId> getUserProfileList() throws Exception;
	public boolean deleteUserProfile(String mailId) throws Exception;
	public UserProfileId updateUserProfile(UserProfileDTO userProfileDTO , String mailId ) throws Exception;
	//public boolean validateUser(UserProfileDTO userProfileDTO) throws Exception;
}
