package com.ami.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ami.dto.CategoryDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/*
 * Author :-> Amit
 * This is test-class for users (CRUD) operation.
 */
public class TestCategoryWS {
	
	Client client = Client.create();
	String catUrl = TestUtility.manageUrl+"/categories/";
	String id=null;
	
	@Test(enabled=true , description="used to create the CATEGORY")
	public void createCategoryWithValidData()
	{
		WebResource webResource = client.resource(catUrl);
		String payLoad = "{\"name\":\"Home and kitchen\",\"desc\":\"TV etc Add\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		CategoryDTO output = response.getEntity(CategoryDTO.class);
		
	    id = output.getCatguid();
	    System.out.println("created catguid is:: " + id);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the Category");
	}
	
	@Test(enabled=true , description="used to get the CATEGORY" , dependsOnMethods="createCategoryWithValidData")
	public void getCategoryWithValidID()
	{
		WebResource webResource = client.resource(catUrl + id);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		CategoryDTO output = response.getEntity(CategoryDTO.class);
		System.out.println("get the category name as" + output.getCatname());
		Assert.assertEquals(response.getStatus(), 200,"failed to get the Category");
	}
	
	@Test(enabled= true , description="used to update the CATEGORY" , dependsOnMethods="getCategoryWithValidID")
	public void updateCategoryWithValidID()
	{
		WebResource webResource = client.resource(catUrl + id);
		String payLoad = "{\"name\":\"Home and kitchen\",\"desc\":\"TV,fridge,AC etc Add\" }";
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,payLoad);
		CategoryDTO output = response.getEntity(CategoryDTO.class);
		System.out.println("get the updated category name as" + output.getCatname());
		Assert.assertEquals(response.getStatus(), 200,"failed to update the Category");
	}
	
	@Test(enabled= true , description="used to delete the CATEGORY" , dependsOnMethods="updateCategoryWithValidID")
	public void deleteCategoryWithValidID()
	{
		WebResource webResource = client.resource(catUrl + id);
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);
	//	CategoryDTO output = response.getEntity(CategoryDTO.class);
		
		//System.out.println("get the updated category name as" + output.getCatname());
		Assert.assertEquals(response.getStatus(), 200,"failed to delete the Category");
	}
	
/*	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidFirstName()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidLastName()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidMailId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void createUserWithInValidPhoneNo()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //* below is the delete related code
	 
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}

	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithInValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithNotExistValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void deleteUserWithDeletedId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //* Read opartion(add more below acc to delete)
	 
	
	@Test(enabled=true , description="used to create the user")
	public void ReadUserWithValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void ReadUserWithInValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	
	 //*  update 
	 
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithInValidId()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithValidData()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}
	
	@Test(enabled=true , description="used to create the user")
	public void updateUserWithInValidData()
	{
		ResultActions resultActions = CategoryWSUtil.createUser("ABC", "DEF", "abc.xy@gmail.com", "908909099");
		Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the User");
	}*/
}

