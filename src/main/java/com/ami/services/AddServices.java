package com.ami.services;

import java.util.List;

import com.ami.dto.PostDTO;
import com.ami.entity.PostAdd;

/*
 *  Posting a Add related Svcs
 */
public interface AddServices {

	public PostAdd addAdd(PostDTO postDTO, String subCatGuid, String typeGuid,String mailId) throws Exception;
	public PostAdd updateAdd(PostDTO postDTO, String addGuid) throws Exception;
	public PostAdd getAddById(String addGuid) throws Exception;
	public List<PostAdd> getAddList() throws Exception;
	public boolean deleteAdd(String addGuid) throws Exception;
	//public boolean validateAdd(PostDTO postDTO) throws CustomException;
	
}
