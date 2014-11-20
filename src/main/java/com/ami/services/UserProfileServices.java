package com.ami.services;

import java.util.List;

import com.ami.dto.UserProfileDTO;
import com.ami.model.UserProfile;

public interface UserProfileServices {
	public UserProfile addUserProfile(UserProfile user) throws Exception;
	//public UserProfile getUserProfileById(String email) throws Exception;
	public UserProfile getUserProfileByMailId(String mailId) throws Exception;
	public UserProfile getUserProfileByFNLN(String firstName , String lastName) throws Exception;
	public List<UserProfile> getUserProfileList() throws Exception;
	public boolean deleteUserProfile(String mailId) throws Exception;
	public int updateUserProfile(String query,List<Object> values) throws Exception;
	
	
	public boolean validateUserProfile(UserProfileDTO userProfileDTO) throws Exception;
}
