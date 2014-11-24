package com.ami.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.UserDTO;
import com.ami.dto.UserProfileDTO;
import com.ami.entity.UserProfileId;
import com.ami.entity.Users;
import com.ami.exceptions.ResourceNotFoundException;

/*
 * This is a service class for user and user-profile  
 *
 */

@Component
public class UserServicesImpl implements UserServices {
	
	@Autowired
	GenericDao genericDao;

	// Add a user
	@Override
	public Users addUser(UserDTO userDTO) throws Exception {
		Users user = new Users();
		user.setUserEmail(userDTO.getEmailId());

		user.setIsRegisterd(userDTO.getIsRegister());
		
	    user.setUserPasswd(userDTO.getPasswd());
		return genericDao.addEntity(user);
	}

	// get user by mail-id
	@Override
	public Users getUserByMailId(String mailId) throws Exception {
		String query = "from Users where userEmail = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(mailId);
		return genericDao.getEntity(query, list);
	}

	/*@Override
	public List<User> getUserList() throws Exception {
		String query = "from User ";
		return genericDao.getEntity(query, null);
	}*/

	// delete a user
	@Override
	public boolean deleteUser(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserByMailId(mailId));
	}

	// update a user
	@Override
	public Users updateUser(UserDTO userDTO , String mailId) throws Exception {
		try{
			Users user = getUserByMailId(mailId);
			if (userDTO.getPasswd()!= null)
				user.setUserPasswd(userDTO.getPasswd());
						
			if (userDTO.getIsRegister()!= null)
				user.setIsRegisterd(userDTO.getIsRegister());
			return genericDao.updateEntity(user);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	@Override
	public List<Users> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
    /*
     * Below are the function implementation related to User-profile
     */
	
	// add a user-profile
	@Override
	public UserProfileId addUserProfile(UserProfileDTO userProfileDTO) throws Exception {
		UserProfileId userProfile = new UserProfileId();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setPhoneNum(userProfileDTO.getPhoneNum());
		userProfile.setUserEmail(userProfileDTO.getUserEmail());
		
		return genericDao.addEntity(userProfile);
	}

	// get user-profile by mail-id
	@Override
	public UserProfileId getUserProfileByMailId(String mailId) throws Exception {
		String query = "from UserProfileId where userEmail = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(mailId);
		return genericDao.getEntity(query, list);
	}

    
	// get list of user-profile
	@Override
	public List<UserProfileId> getUserProfileList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// delete a user-profile
	@Override
	public boolean deleteUserProfile(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserProfileByMailId(mailId));
	}

	// update a user-profile
	@Override
	public UserProfileId updateUserProfile(UserProfileDTO userProfileDTO, String mailId)
			throws Exception {
		try{
			UserProfileId userProfileId = getUserProfileByMailId(mailId);
			if (userProfileDTO.getFirstName()!= null)
				userProfileId.setFirstName(userProfileDTO.getFirstName());
						
			if (userProfileDTO.getLastName()!=null)
				userProfileId.setLastName(userProfileDTO.getLastName());
			
			if (userProfileDTO.getPhoneNum()!=null)
				userProfileId.setPhoneNum(userProfileDTO.getPhoneNum());
			
			return genericDao.updateEntity(userProfileId);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}
	
	
	
}


