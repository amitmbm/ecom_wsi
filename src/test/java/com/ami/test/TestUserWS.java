package com.ami.test;

import org.springframework.test.web.servlet.ResultActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserWS {
	
	@Test(enabled=true , description="used to create the user")
	public void createUser()
	{
		ResultActions resultActions = UserWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	

}
