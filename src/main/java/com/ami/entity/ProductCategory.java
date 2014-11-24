package com.ami.entity;

// Generated Nov 22, 2014 5:45:05 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * ProductCategory generated by hbm2java
 */

public class ProductCategory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6628241790302096005L;
	private String catGuid;
	private String catName;
	private String catDesc;
	private Set productSubCategories = new HashSet(0);

	public ProductCategory() {
	}

	public ProductCategory(String catGuid, String catName, String catDesc) {
		this.catGuid = catGuid;
		this.catName = catName;
		this.catDesc = catDesc;
	}

	public ProductCategory(String catGuid, String catName, String catDesc,
			Set productSubCategories) {
		this.catGuid = catGuid;
		this.catName = catName;
		this.catDesc = catDesc;
		this.productSubCategories = productSubCategories;
	}

	public String getCatGuid() {
		return this.catGuid;
	}

	public void setCatGuid(String catGuid) {
		this.catGuid = catGuid;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return this.catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public Set getProductSubCategories() {
		return this.productSubCategories;
	}

	public void setProductSubCategories(Set productSubCategories) {
		this.productSubCategories = productSubCategories;
	}

}
