package com.wsi.services;

import java.util.List;

import com.wsi.dto.PostDTO;
import com.wsi.entity.PostAdd;

/*
 *  Posting a Add related Svcs
 */
public interface AddServices {

	public PostAdd postAdd(PostDTO postDTO) throws Exception;
	public PostAdd updateAdd(PostDTO postDTO, String addGuid) throws Exception;
	public PostAdd getAddById(String addGuid) throws Exception;
	public List<PostAdd> getAddList(int low , int high) throws Exception;
	//public List<PostAdd> getAddList() throws Exception;
	public boolean deleteAdd(String addGuid) throws Exception;
	//public boolean validateAdd(PostDTO postDTO) throws CustomException;
	List<PostAdd> getAddList(String order) throws Exception;
	
}
