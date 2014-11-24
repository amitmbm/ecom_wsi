package com.ami.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.UserDTO;
import com.ami.entity.Users;
import com.ami.exceptions.CustomException;
import com.ami.exceptions.ResourceNotFoundException;

@Component
public class UserServicesImpl implements UserServices {
	
	@Autowired
	GenericDao genericDao;

	@Override
	public Users addUser(UserDTO userDTO) throws Exception {
		Users user = new Users();
		user.setUserEmail(userDTO.getEmailId());

		user.setIsRegisterd(userDTO.getIsRegister());
		
	    user.setUserPasswd(userDTO.getPasswd());
		return genericDao.addEntity(user);
	}

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

	@Override
	public boolean deleteUser(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserByMailId(mailId));
	}

	@Override
	public Users updateUser(UserDTO userDTO , String mailId) throws Exception {
		try{
			Users user = getUserByMailId(mailId);
			if (userDTO.getPasswd()!= null)
				user.setUserEmail(userDTO.getEmailId());
						
			if (userDTO.getIsRegister()!= null)
				user.setIsRegisterd(userDTO.getIsRegister());
			return genericDao.updateEntity(user);
		}catch(ResourceNotFoundException re){
			throw re;
		}	
	}

	@Override
	public boolean validateUser(UserDTO userDTO) throws Exception {
		//String firstName = userProfileDTO.getFirstName();
		
				if (userDTO.getPasswd().isEmpty() || userDTO.getEmailId().isEmpty() ||
						userDTO.getPasswd() == null || userDTO.getEmailId()==null) 
				{
					throw new CustomException("passwd or mailid can't be empty" , 001);
				} 


				/*// Should not violate the pattern
				//Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{4,125}");
				//Matcher m = p.matcher(catName);
				if(!m.matches()) 
				{
					throw new CustomException( "Category name should not contain special characters, must begin with a letter and should be between 4 and 125 characters long." ,002);
				}*/
				return true;
			}

	@Override
	public List<Users> getUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}


