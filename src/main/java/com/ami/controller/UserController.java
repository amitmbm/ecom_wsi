package com.ami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.dto.UserDTO;
import com.ami.exceptions.CustomException;
import com.ami.model.Status;
import com.ami.model.User;
import com.ami.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices dataServices;

//	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody
	Status addUser(@RequestBody UserDTO user) {
		try {
			User userDao=null;
			if(dataServices.validateUser(user))
			{
			    userDao = new User();
			    userDao.setEmail(user.getEmailId());
			    userDao.setIsRegister((byte) 0);
			    userDao.setPasswd(user.getPasswd());
		
			}
			dataServices.addUser(userDao);
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
	User getUser(@PathVariable("mailId") String mailId) {
		User user = null;
		try {
			user = dataServices.getUserByMailId(mailId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<User> getUsers() {

		List<User> userList = null;
		try {
			userList = dataServices.getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@RequestMapping(value = "{mailId}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteUser(@PathVariable("mailId") String mailId) {

		try {
			dataServices.deleteUser(mailId);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
