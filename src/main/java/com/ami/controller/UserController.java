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

import com.ami.model.Status;
import com.ami.model.User;
import com.ami.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices dataServices;

//	static final Logger logger = Logger.getLogger(RestController.class);

	/*
	 *  Add user REST API and post body should be in below format
	            {
           			"firstName" : "rohit",
  					"lastName" : "laddha" ,
  					"email" : "rohit.laddha@kony.com",
                    "phone" : "0888888888"
                   }
	 */
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json" )
	public @ResponseBody
	Status addUser(@RequestBody User user) {
		try {
			dataServices.addEntity(user);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET ,  produces="application/json")
	public @ResponseBody
	User getUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * how i can pass firstname and lastname in headers ?
	 */
	
	@RequestMapping(value = "/name", method = RequestMethod.GET ,  produces="application/json")
	public @ResponseBody
	User getUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		User user = null;
		try {
			user = dataServices.getEntityByFNLN(firstName,lastName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(method = RequestMethod.GET ,  produces="application/json")
	public @ResponseBody
	List<User> getUsers() {

		List<User> userList = null;
		try {
			userList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteUser(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT , headers = "Accept=application/json" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	User updateUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
