package com.wsi.services;

import java.util.List;

import com.wsi.entity.Permissions;

public interface PermissionServices {

	public Permissions createPermissions(Permissions permissions) throws Exception;
	public Permissions updatePermissions(Permissions permissions, String id) throws Exception;
	public Permissions getPermissionsById(String id) throws Exception;
	public Permissions getPermissionsByName(String name) throws Exception;
	//public List<Permissions> getPermissionsList(int low , int high) throws Exception;
	public List<Permissions> getPermissionsList() throws Exception;
	public boolean deletePermissions(String id) throws Exception;
	//public boolean validateAdd(PermissionsDTO PermissionsDTO) throws CustomException;
	//List<Permissions> getAddList(String order) throws Exception;
}
