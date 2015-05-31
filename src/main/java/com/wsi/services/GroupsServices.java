package com.wsi.services;

import java.util.List;

import com.wsi.dto.GroupsDTO;
import com.wsi.entity.Groups;

public interface GroupsServices {
	
	public Groups CreateGroup(GroupsDTO GroupsDTO) throws Exception;
	public Groups updateGroup(GroupsDTO GroupsDTO, String id) throws Exception;
	public Groups getGroupById(String id) throws Exception;
	public Groups getGroupByName(String name) throws Exception;
	//public List<Groups> getGroupList(int low , int high) throws Exception;
	public List<Groups> getGroupList() throws Exception;
	public boolean deleteGroup(String id) throws Exception;
	//public boolean validateAdd(GroupsDTO GroupsDTO) throws CustomException;
	//List<Groups> getAddList(String order) throws Exception;

}
