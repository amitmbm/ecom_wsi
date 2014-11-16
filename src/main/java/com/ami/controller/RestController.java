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

import com.ami.model.Status;
import com.ami.model.User;
import com.ami.services.UserServices;

@Controller
@RequestMapping("/users")
public class RestController {

	@Autowired
	UserServices dataServices;

//	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody User user) {
		try {
			dataServices.addEntity(user);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getEmployee(@PathVariable("id") long id) {
		User user = null;
		try {
			user = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<User> getUser() {

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
	Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody
	User updateEmployee(@PathVariable("id") long id) {
		User user = null;
		try {
			user = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
