package com.ami.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ami.dao.GenericDao;
import com.ami.dto.UserProfileDTO;
import com.ami.exceptions.CustomException;
import com.ami.model.UserProfile;

@Component
public class UserProfileServicesImpl implements UserProfileServices {

	@Autowired
	GenericDao genericDao;
	
	@Override
	public UserProfile addUserProfile(UserProfile user) throws Exception {
		return genericDao.addEntity(user);
	}

		
	@Override
	public UserProfile getUserProfileByMailId(String MailId) throws Exception {
		String query = "from UserProfile where email = ?";
		List<Object> list = new ArrayList<>();
		list.add(MailId);
		return genericDao.getEntity(query, list);
	}
	
	@Override
	public UserProfile getUserProfileByFNLN(String firstName , String lastName) throws Exception {
		String query = "from UserProfile where firstName = ? and lastName = ?";
		List<Object> list = new ArrayList<>();
		list.add(firstName);
		list.add(lastName);
		return genericDao.getEntity(query, list);
	}

	@Override
	public List<UserProfile> getUserProfileList() throws Exception {
		String query = "from UserProfile";
		return genericDao.getEntities(query, null);
	}

	@Override
	public boolean deleteUserProfile(String mailId) throws Exception {
		return genericDao.deleteEntity(getUserProfileByMailId(mailId));
	}

	
	@Override
	public int updateUserProfile(String query, List<Object> values) throws Exception {
   	query = "UPDATE UserProfile set firstName = :fn "  + 
                "WHERE email = :email";
   //	values.add(e)
   
   //Query query = session.createQuery(hql);
   //query.setParameter("salary", 1000);
   //query.setParameter("employee_id", 10);
   //int result = query.executeUpdate();
   //System.out.println("Rows affected: " + result);    	
		//return false;
		return genericDao.updateEntity(query, values);
	}

	@Override
	public boolean validateUserProfile(UserProfileDTO userProfileDTO)
			throws Exception {
		//String firstName = userProfileDTO.getFirstName();
		
		if (userProfileDTO.getFirstName().isEmpty() || userProfileDTO.getFirstName()==null ||
				userProfileDTO.getLastName().isEmpty() || userProfileDTO.getLastName()==null) 
		{
			throw new CustomException("first or last name can't be empty" , 001);
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
	
	

}
