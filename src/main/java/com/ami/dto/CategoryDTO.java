package com.ami.dto;

import java.util.UUID;

public class CategoryDTO {
	
	String catguid;
	String catName;
	String catDesc;
	/**
	 * @return the catguid
	 */
	public String getCatguid() {
		catguid= UUID.randomUUID().toString();
		return catguid;
	}
	/**
	 * @param catguid the catguid to set
	 */
	public void setCatguid(String catguid) {
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
