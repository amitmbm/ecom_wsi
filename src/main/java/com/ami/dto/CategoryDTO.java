package com.ami.dto;

import java.util.UUID;

public class CategoryDTO {
	
	UUID catguid;
	String catName;
	String catDesc;
	/**
	 * @return the catguid
	 */
	public UUID getCatguid() {
		catguid= UUID.randomUUID();
		return catguid;
	}
	/**
	 * @param catguid the catguid to set
	 */
	public void setCatguid(UUID catguid) {
		this.catguid = catguid;
	}
	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}
	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	/**
	 * @return the catDesc
	 */
	public String getCatDesc() {
		return catDesc;
	}
	/**
	 * @param catDesc the catDesc to set
	 */
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	

}
