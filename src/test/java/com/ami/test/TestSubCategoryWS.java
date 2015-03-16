package com.ami.test;
/*
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ami.dto.CategoryDTO;
import com.ami.dto.SubCategoryDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class TestSubCategoryWS {
	
	Client client = Client.create();
	String id=null;
	SubCategoryDTO subCategoryDTO =null , subCategoryDTO2=null;
	
	@Test(enabled=true , description="used to create the CATEGORY")
	public void createCategoryWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"categories/");
		String payLoad = "{\"name\":\"Home and kitchen\",\"desc\":\"TV etc Add\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
		CategoryDTO output = response.getEntity(CategoryDTO.class);
		id = output.getCatguid();
	    System.out.println("created catguid is:: " + id);
		Assert.assertEquals(response.getStatus(), 201,"failed to create the Category");
	}
	
	@Test(enabled=true , description="used to create the first SUB-CATEGORY" , dependsOnMethods="createCategoryWithValidData")
	public void createFirstSubCategoryWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"categories/"+id+"/subcategories");
		String payLoad = "{\"name\":\"Home\",\"desc\":\"home related stuff\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    subCategoryDTO = response.getEntity(SubCategoryDTO.class);
		
	    System.out.println("created first sub-catguid is:: " + subCategoryDTO.getSubCatGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to create the second SUB-CATEGORY" , dependsOnMethods="createFirstSubCategoryWithValidData")
	public void createSecondSubCategoryWithValidData()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"categories/"+id+"/subcategories");
		String payLoad = "{\"name\":\"kitchen\",\"desc\":\"kitchen related stuff\" }";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,payLoad);
	    subCategoryDTO2 = response.getEntity(SubCategoryDTO.class);
		
	    System.out.println("created second sub-catguid is:: " + subCategoryDTO2.getSubCatGuid());
		Assert.assertEquals(response.getStatus(), 201,"failed to create the sub-Category");
	}
	
	@Test(enabled=true , description="used to get the SUB-CATEGORY" , dependsOnMethods="createFirstSubCategoryWithValidData")
	public void getSubCategoryWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"subcategories/"+subCategoryDTO.getSubCatGuid() );
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		SubCategoryDTO subCategoryDTO = response.getEntity(SubCategoryDTO.class);
		System.out.println("get the category name as" + subCategoryDTO.getSubCatName());
		Assert.assertEquals(response.getStatus(), 200,"failed to get the Category");
	}
	
	@Test(enabled= true , description="used to update the CATEGORY" , dependsOnMethods="getSubCategoryWithValidID")
	public void updateSubCategoryWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"subcategories/"+ subCategoryDTO.getSubCatGuid());
		String payLoad = "{\"name\":\"home\",\"desc\":\"TV,fridge,AC etc Add\" }";
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,payLoad);
		SubCategoryDTO subCategoryDTO = response.getEntity(SubCategoryDTO.class);
		System.out.println("get the updated category name as" + subCategoryDTO.getSubCatDesc());
		Assert.assertEquals(response.getStatus(), 200,"failed to update the Category");
	}
	
	@Test(enabled= true , description="used to delete the Sub-CATEGORY" , dependsOnMethods="createSecondSubCategoryWithValidData")
	public void deleteCategoryWithValidID()
	{
		WebResource webResource = client.resource(TestUtility.manageUrl+"subcategories/"+ subCategoryDTO2.getSubCatGuid());
		ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);
		Assert.assertEquals(response.getStatus(), 200,"failed to delete the Category");
	}
}
*/