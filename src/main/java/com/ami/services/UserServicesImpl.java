package com.ami.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ami.common.PasswordHash;
import com.ami.dao.GenericDao;
import com.ami.dto.UserProfileDTO;
import com.ami.entity.UserProfile;
import com.ami.entity.Users;
import com.ami.exceptions.ResourceNotFoundException;

/*
 * This is a service class for user and user-profile .
 * (only post and update of user and user-profile is completed)
 *
 */

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	GenericDao genericDao;

	// Add a user and user-profile
	@Transactional
	@Override
	public UserProfile addUser(UserProfileDTO userProfileDTO) throws Exception {
	          Date now = new Date();
		try{
			UserProfile userProfileId = getUserProfileByMailId(userProfileDTO.getEmailId());
			updateUser(userProfileDTO, userProfileId.getUserEmail());
			return userProfileId;
		}
		catch (ResourceNotFoundException re) {
			Users user = new Users();
			user.setUserEmail(userProfileDTO.getEmailId());
			user.setIsRegisterd(userProfileDTO.getIsRegister());
		    user.setUserPasswd(PasswordHash.createHash(userProfileDTO.getPasswd()));
		    //user.setUserKey("hardcoded");
		    user.setCreatedAt(now);
			user.setUpdatedAt(now);
			
			genericDao.addEntity(user);
		    //"Select aes_encrypt(password, md5(guid))", null)
		   // System.out.println(genericDao.getEntityNative("select AES_ENCRYPT('password' , md5('guid'))"));
		    
		    UserProfile userProfile = new UserProfile();
		    userProfile.setFirstName(userProfileDTO.getFirstName());
		    userProfile.setLastName(userProfileDTO.getLastName());
		    userProfile.setPhoneNum(userProfileDTO.getPhoneNum());
		    userProfile.setUserEmail(userProfileDTO.getEmailId());
		    
		    userProfile.setCreatedAt(now);
		    userProfile.setUpdatedAt(now);

		    userProfile.setUsers(user);
		    
			return genericDao.addEntity(userProfile);
		}
	
	}

	// update a user and user-profile
		@Transactional
		@Override
		public UserProfile updateUser(UserProfileDTO userProfileDTO, String mailId) throws Exception {
			try{
				Users user = getUserByMailId(mailId);
				if (userProfileDTO.getPasswd()!= null)
					user.setUserPasswd(userProfileDTO.getPasswd());
							
				if (userProfileDTO.getIsRegister()!= null)
					user.setIsRegisterd(userProfileDTO.getIsRegister());
				
							
				user.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
				genericDao.updateEntity(user);
				
				UserProfile userProfile = getUserProfileByMailId(mailId);
				if (userProfileDTO.getFirstName()!= null)
					userProfile.setFirstName(userProfileDTO.getFirstName());
							
				if (userProfileDTO.getLastName()!=null)
					userProfile.setLastName(userProfileDTO.getLastName());
				
				if (userProfileDTO.getPhoneNum()!=null)
					userProfile.setPhoneNum(userProfileDTO.getPhoneNum());
				
				userProfile.setUpdatedAt(new Date());
				
				userProfile.setUsers(user);
				return genericDao.updateEntity(userProfile);
			}catch(ResourceNotFoundException re){
				throw re;
			}	
		}
		
	// get user by mail-id
	@Transactional
	@Override
	public Users getUserByMailId(String mailId) throws Exception {
		String query = "from Users where userEmail = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(mailId);
		Users user = genericDao.getEntity(query, list);
		if (user == null)
			throw new ResourceNotFoundException("User with MailId :"+ mailId + " not exist");
		return user;
	}
	
	// get user-profile by mail-id
	@Transactional
	@Override
	public UserProfile getUserProfileByMailId(String mailId) throws Exception {
		String query = "from UserProfile where userEmail = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(mailId);
		UserProfile userProfile = genericDao.getEntity(query, list);
		if (userProfile == null)
			throw new ResourceNotFoundException("User-profile with MailId :"+ mailId + " not exist");
		return userProfile;
	}

	// delete a user
	@Transactional
	@Override
	public boolean deleteUser(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserByMailId(mailId));
	}


	// add a user-profile
	@Transactional
	@Override
	public UserProfile addUserProfile(UserProfileDTO userProfileDTO) throws Exception {
		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setPhoneNum(userProfileDTO.getPhoneNum());
		//userProfile.setUserEmail(userProfileDTO.getUserEmail());
		
		return genericDao.addEntity(userProfile);
	}



    
	// get list of user-profile
	@Transactional
	@Override
	public List<UserProfile> getUserProfileList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// delete a user and user-profile(in use)
	@Transactional
	@Override
	public boolean deleteUserProfile(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserByMailId(mailId));
		//return genericDao.deleteEntity(getUserProfileByMailId(mailId));
	}

	// update a user-profile
	@Transactional
	@Override
	public UserProfile updateUserProfile(UserProfileDTO userProfileDTO, String mailId)
			throws Exception {
		try{
			UserProfile userProfileId = getUserProfileByMailId(mailId);
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

	@Override
	public List<Users> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	    // authenticate a user (using the passwd based key dervivation function2 PBKDF2)
	     // TODO :-> remove null pointer exception in case of success 
		@Transactional
		@Override
		public boolean authenticateUser(String mailId , String passwd) throws Exception {
			String query = "from Users where userEmail = ?";
			List<Object> list = new ArrayList<Object>();
			list.add(mailId);
			Users user = genericDao.getEntity(query, list);
			if (user == null)
				throw new ResourceNotFoundException("User with MailId :"+ mailId + " not exist");
 			String passwdDB = user.getUserPasswd();
			if(PasswordHash.validatePassword(passwd,passwdDB)) {
                System.out.println("GOOD PASSWORD ACCEPTED!");
                return true;
            }
			else
			{
				System.out.println("BAD PASSWORD NOT ACCEPTED!");
				return false;
			}
			
			
		}
}


