package com.ami.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.dto.UserProfileDTO;
import com.ami.exceptions.CustomException;
import com.ami.model.Status;
import com.ami.model.UserProfile;
import com.ami.services.UserProfileServices;

@Controller
@RequestMapping("/userprofiles")
public class UserProfilesController {

	@Autowired
	UserProfileServices dataServices;

//	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody
	Status addUserProfile(@RequestBody UserProfileDTO userProfile) {
		try {
			UserProfile userProfileDao=null;
			if(dataServices.validateUserProfile(userProfile))
			{
			    userProfileDao = new UserProfile();
			    userProfileDao.setFirstName(userProfile.getFirstName());
			    userProfileDao.setLastName(userProfile.getLastName());
			    userProfileDao.setPhone(userProfile.getPhone());
			    userProfileDao.setEmail(userProfile.getEmail());
		
			}
			dataServices.addUserProfile(userProfileDao);
			return new Status(1, "Category added Successfully !");
		}catch(CustomException e)
		{
			e.printStackTrace();
			return new Status(0, e.toString());
		}
		catch (Exception e) {
			 e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "{mailId}", method = RequestMethod.GET)
	public @ResponseBody
	UserProfile getUserProfile(@PathVariable("mailId") String mailId) {
		UserProfile userProfile = null;
		try {
			userProfile = dataServices.getUserProfileByMailId(mailId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProfile;
	}
	
	@RequestMapping(value = "/name", method = RequestMethod.GET , headers = "Accept=application/json")
	public @ResponseBody
	UserProfile getUserProfile(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		UserProfile userProfile = null;
		try {
			userProfile = dataServices.getUserProfileByFNLN(firstName,lastName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProfile;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<UserProfile> getUserProfiles() {

		List<UserProfile> userProfileList = null;
		try {
			userProfileList = dataServices.getUserProfileList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userProfileList;
	}

	@RequestMapping(value = "{mailId}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteUserProfile(@PathVariable("mailId") String mailId) {

		try {
			dataServices.deleteUserProfile(mailId);
			return new Status(1, "UserProfile deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	/*@RequestMapping(value = "{mailId}", method = RequestMethod.PUT , headers = "Accept=application/json" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	UserProfile updateUserProfile(@PathVariable("mailId") String mailId) {
		UserProfile userProfile = null;
		try {
			userProfile = dataServices.updateUserProfile(mailId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProfile;
	}*/
}
