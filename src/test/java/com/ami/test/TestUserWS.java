package com.ami.test;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
import com.ami.dto.UserProfileDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestUserWS {
	
	Client client = Client.create();
	String userid=null , userid2 =null;
	UserProfileDTO userDTO1 =null , userDTO2=null;
	
	@Test(enabled=true , description="use to create the user and user-profile")
	public void createUserWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.userUrl);
		
		String payLoad = "{\"first_name\":\"Amit\", \"last_name\":\"khandelwal\" , \"mailid\":\"laccho@gmail.com\", \"passwd\":\"khandelwal\" , \"phone\":\"8886890011\", \"is_register\":\"true\" }";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		userDTO1 = response.getEntity(UserProfileDTO.class);
		userid = userDTO1.getEmailId();
	    System.out.println("created user with mailid :: " + userid);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the user");
	}
	
	@Test(enabled=true , description="used to create the Second user" )
	public void createSecondUserWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.userUrl);
		
		String payLoad = "{\"first_name\":\"gudda\", \"last_name\":\"shahra\" , \"mailid\":\"amitmbm87@gmail.com\", \"passwd\":\"khandelwal\" , \"phone\":8886890011,\"is_register\":false }";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		userDTO1 = response.getEntity(UserProfileDTO.class);
		userid2 = userDTO1.getEmailId();
	    System.out.println("created second-user with mailid :: " + userid2);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the user");
	}
 	
	@Test(enabled=true , description="used to get the user" , dependsOnMethods="createUserWithValidData")
	public void getUserWithValidID()
	{
		System.out.println("url for getting the detail::::" + TestUtility.userUrl+ userid);
		WebResource webResource = client.resource(TestUtility.userUrl+ userid );
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		userDTO2 = response.getEntity(UserProfileDTO.class);
		System.out.println("get the user first name as" + userDTO2.getFirstName());
		Assert.assertEquals(response.getStatus(), 200,"failed to get the user detail");
	}
	
	@Test(enabled= true , description="used to update the user" )
	public void updateUserWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.userUrl+ userid);
		String payLoad = "{\"first_name\":\"gudda\",\"last_name\":\"khandelwal\" }";
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,payLoad);
		userDTO2 = response.getEntity(UserProfileDTO.class);
		System.out.println("get the updated first name as" + userDTO2.getFirstName());
		Assert.assertEquals(response.getStatus(), 200,"failed to update the user");
	}
	
	@Test(enabled= true , description="used to delete the user" , dependsOnMethods="createSecondUserWithValidData")
	public void deleteUserWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.userUrl + userid2);
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);
		Assert.assertEquals(response.getStatus(), 200,"failed to delete the Category");
	}

}
*/