package com.ami.services;

import java.util.List;

import com.ami.dto.UserProfileDTO;
import com.ami.entity.UserProfile;
import com.ami.entity.Users;

public interface UserServices {
	
	public UserProfile addUser(UserProfileDTO userProfileDTO) throws Exception;
	public Users getUserByMailId(String mailId) throws Exception;
	public List<Users> getUserList() throws Exception;
	public boolean deleteUser(String mailId) throws Exception;
	//public Users updateUser(UserDTO userDTO , String mailId ) throws Exception;
	//public boolean validateUser(UserDTO userDTO) throws Exception;

	// user-profile related functions
	public UserProfile addUserProfile(UserProfileDTO userProfileDTO) throws Exception;
	public UserProfile getUserProfileByMailId(String mailId) throws Exception;
	public List<UserProfile> getUserProfileList() throws Exception;
	public boolean deleteUserProfile(String mailId) throws Exception;
	public UserProfile updateUserProfile(UserProfileDTO userProfileDTO , String mailId ) throws Exception;
	//public boolean validateUser(UserProfileDTO userProfileDTO) throws Exception;
	public UserProfile updateUser(UserProfileDTO userProfileDTO, String mailId)
			throws Exception;
}
