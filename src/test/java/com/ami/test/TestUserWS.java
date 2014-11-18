package com.ami.test;

import org.springframework.test.web.servlet.ResultActions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Author :-> Amit
 * This is test-class for users (CRUD) operation.
 */
public class TestUserWS {
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithValidData()
	{
		ResultActions resultActions = UserWSUtil.createUser("rohitladdhaladdha", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidFirstName()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidLastName()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidMailId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidPhoneNo()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //* below is the delete related code
	 
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}

	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithInValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithNotExistValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithDeletedId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //* Read opartion(add more below acc to delete)
	 
	
	@Test(enabled=true , description="used to create the user")
	public void ReadUserWithValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void ReadUserWithInValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //*  update 
	 
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithInValidId()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithValidData()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithInValidData()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
}

