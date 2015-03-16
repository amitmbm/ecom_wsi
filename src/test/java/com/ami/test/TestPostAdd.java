package com.ami.test;
/*
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ami.dto.PostDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestPostAdd {

	Client client = Client.create();
	String addid1 = null , addid2 = null;
	PostDTO postDTO1 = null , postDTO2 = null;
	
	@Test(enabled=true , description="use to post the Add on platform")
	public void createPostWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.dataUrl+"postadd");
		
		String payLoad = "{\"desc\":\"selling mobile at a very resonable price\", \"price\":\"8000\" , \"mailid\":\"amitkhandelwal0887@yahoo.com\", \"subcat_id\":\"a41a8735-8ed4-4a2d-a709-e05c404f43b2\" , \"type_id\":\"5222eeee-bdc9-4020-ae97-87936e1464fc\", \"is_negotiable\":\"true\" , \"img1\":\"kjdsadhkadhkasdhka\" }";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		postDTO1 = response.getEntity(PostDTO.class);
		addid1 = postDTO1.getAddGuid();
	    System.out.println("created post with id :: " + addid1);
		Assert.assertEquals(response.getStatus(), 201,"failed to post the Add");
	}
	
	@Test(enabled=true , description="used to create the Second post" )
	public void createSecondPostWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.dataUrl+"postadd");
		
		String payLoad = "{\"desc\":\"selling anoter mobile at a very resonable price\", \"price\":\"8000\" , \"mailid\":\"ami@yahoo.com\", \"subcat_id\":\"a41a8735-8ed4-4a2d-a709-e05c404f43b2\" , \"type_id\":\"5222eeee-bdc9-4020-ae97-87936e1464fc\", \"is_negotiable\":\"false\" , \"img4\":\"kjdsadhkadhkasdhka\"}";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		postDTO1 = response.getEntity(PostDTO.class);
		addid2 = postDTO1.getAddGuid();
	    System.out.println("created second-post with id :: " + addid2);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the user");
	}
 	
	@Test(enabled=true , description="used to get the posted Add" , dependsOnMethods="createPostWithValidData")
	public void getPostWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.dataUrl+"postadd/"+ addid1);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		postDTO1 = response.getEntity(PostDTO.class);
		System.out.println("got the Ad Desc as" + postDTO1.getAddDesc());
		Assert.assertEquals(response.getStatus(), 200,"failed to get the user detail");
	}
	
	@Test(enabled= true , description="used to update the posted add" )
	public void updatePostWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.dataUrl+"postadd/"+ addid1);
		String payLoad = "{\"desc\":\"MOBILE at a very resonable price\", \"price\":\"1800\" , \"mailid\":\"ami@yahoo.com\" }";
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,payLoad);
		postDTO2 = response.getEntity(PostDTO.class);
		System.out.println("get the updated Ad desc as" + postDTO2.getAddDesc());
		Assert.assertEquals(response.getStatus(), 200,"failed to update the user");
	}
	
	@Test(enabled= true , description="used to delete the posted Add" , dependsOnMethods="createSecondPostWithValidData")
	public void deleteUserWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.dataUrl +"postadd/" + addid2);
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);
		Assert.assertEquals(response.getStatus(), 200,"failed to delete the Category");
	}

}

*/