package com.ami.test;
/*
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.ami.dto.TypeDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestSubCatTypeWS {
	
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/categories/");
	String payLoad = "{\"name\":\"Mobile And Tablet\",\"desc\":\"Mobile And tablet Adds\" }";
	String id=null;
	SubCategoryDTO subCategoryDTO =null ;
	TypeDTO typeDTO = null , typeDTO2 = null , typeDTO3 = null;
	
	@Test(enabled=true , description="used to create the CATEGORY")
	public void createCategoryWithValidData()
	{
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		CategoryDTO output = response.getEntity(CategoryDTO.class);
		id = output.getCatguid();
	    System.out.println("created catguid is:: " + id);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the Category");
	}
	
	@Test(enabled=true , description="used to create the SUB-CATEGORY" , dependsOnMethods="createCategoryWithValidData")
	public void createSubCategoryWithValidData()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/categories/"+id+"/subcategories");
		String payLoad = "{\"name\":\"Mobile\",\"desc\":\"mobile related stuff\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    subCategoryDTO = response.getEntity(SubCategoryDTO.class);
		
	    System.out.println("created first sub-catguid is:: " + subCategoryDTO.getSubCatGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to create the first SUB-CATEGORY-TYPE" , dependsOnMethods="createSubCategoryWithValidData")
	public void createFirstSubCategoryTypeWithValidData()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/subcategories/"+subCategoryDTO.getSubCatGuid()+"/types");
		String payLoad = "{\"name\":\"Apple\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    typeDTO = response.getEntity(TypeDTO.class);
		
	    System.out.println("created first sub-cat-type is:: " + typeDTO.getTypeGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to create the second SUB-CATEGORY-TYPE" , dependsOnMethods="createSubCategoryWithValidData")
	public void createSecondSubCategoryTypeWithValidData()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/subcategories/"+subCategoryDTO.getSubCatGuid()+"/types");
		String payLoad = "{\"name\":\"Samsung\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    typeDTO2 = response.getEntity(TypeDTO.class);
		
	    System.out.println("created second sub-cat-type is:: " + typeDTO2.getTypeGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to create the third SUB-CATEGORY-TYPE" , dependsOnMethods="createSubCategoryWithValidData")
	public void createThirdSubCategoryTypeWithValidData()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/subcategories/"+subCategoryDTO.getSubCatGuid()+"/types");
		String payLoad = "{\"name\":\"HTC\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    typeDTO3 = response.getEntity(TypeDTO.class);
		
	    System.out.println("created third sub-cat-type is:: " + typeDTO3.getTypeGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to get the SUBCATEGORY-TYPE" , dependsOnMethods="createFirstSubCategoryTypeWithValidData")
	public void getSubCategoryTypeWithValidID()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/types/"+ typeDTO.getTypeGuid());
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		Assert.assertEquals(response.getStatus(), 200,"failed to get the Category");
	}
	
	@Test(enabled= true , description="used to update the SUBCATEGORY-TYPE" , dependsOnMethods="getSubCategoryTypeWithValidID")
	public void updateSubCategoryTypeWithValidID()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/types/"+ typeDTO.getTypeGuid());
		String payLoad = "{\"name\":\"Apple(iphone)\" }";
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,payLoad);
		Assert.assertEquals(response.getStatus(), 200,"failed to update the Category");
	}
	
	@Test(enabled= true , description="used to delete the SUBCATEGORY-TYPE" , dependsOnMethods="createThirdSubCategoryTypeWithValidData")
	public void deleteSubCategoryTypeWithValidID()
	{
		WebResource webResource = client.resource("http://localhost:9090/TestWS/api/v1/manage/types/"+ typeDTO3.getTypeGuid());
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);
		Assert.assertEquals(response.getStatus(), 200,"failed to delete the Category");
	}

}
*/