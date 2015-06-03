package com.wsi.services;

import java.util.List;

import com.wsi.entity.Acls;

public interface AclsServices {

	public Acls createAcls(Acls acls) throws Exception;
	public Acls updateAcls(Acls acls, String id) throws Exception;
	public Acls getAclsById(String id) throws Exception;
	//public Acls getAclsByName(String name) throws Exception;
	//public List<Acls> getAclsList(int low , int high) throws Exception;
	public List<Acls> getAclsList() throws Exception;
	public boolean deleteAcls(String id) throws Exception;
	//public boolean validateAdd(AclsDTO AclsDTO) throws CustomException;
	//List<Acls> getAddList(String order) throws Exception;
	// getAclsByGrpResPerm(String name) throws Exception;
	public Acls getAclsByGrpResPerm(String grp, String res, String perm)
			throws Exception;
	
}
