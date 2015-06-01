package com.wsi.services;

import java.util.List;

import com.wsi.entity.Resources;

public interface ResourcesServices {
	
	public Resources CreateResource(Resources resources) throws Exception;
	public Resources updateResource(Resources resources, String id) throws Exception;
	public Resources getResourceById(String id) throws Exception;
	public Resources getResourceByName(String name) throws Exception;
	//public List<Resources> getResourceList(int low , int high) throws Exception;
	public List<Resources> getResourceList() throws Exception;
	public boolean deleteResource(String id) throws Exception;
	//public boolean validateAdd(resourcesDTO resourcesDTO) throws CustomException;
	//List<Resources> getAddList(String order) throws Exception;

}
