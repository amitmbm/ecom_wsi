package com.wsi.entity;

// Generated Nov 28, 2014 10:29:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * PostAdd generated by hbm2java
 */
public class PostAdd implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 634651044173726711L;
	private String addGuid;
	private ProductSubCategory productSubCategory;
	private Users users;
	private ProductSubCategoryType productSubCategoryType;
	private String addDesc;
	private int price;
	private Boolean negotiable;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String createdBy;
	private String updatedBy;
	private Date createdAt;
	private Date updatedAt;

	public PostAdd() {
	}

	public PostAdd(String addGuid, ProductSubCategory productSubCategory,
			Users users, ProductSubCategoryType productSubCategoryType,
			String addDesc, int price, Date createdAt, Date updatedAt) {
		this.addGuid = addGuid;
		this.productSubCategory = productSubCategory;
		this.users = users;
		this.productSubCategoryType = productSubCategoryType;
		this.addDesc = addDesc;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public PostAdd(String addGuid, ProductSubCategory productSubCategory,
			Users users, ProductSubCategoryType productSubCategoryType,
			String addDesc, int price, Boolean negotiable, String image1,
			String image2, String image3, String image4, String createdBy,
			String updatedBy, Date createdAt, Date updatedAt) {
		this.addGuid = addGuid;
		this.productSubCategory = productSubCategory;
		this.users = users;
		this.productSubCategoryType = productSubCategoryType;
		this.addDesc = addDesc;
		this.price = price;
		this.negotiable = negotiable;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getAddGuid() {
		return this.addGuid;
	}

	public void setAddGuid(String addGuid) {
		this.addGuid = addGuid;
	}

	public ProductSubCategory getProductSubCategory() {
		return this.productSubCategory;
	}

	public void setProductSubCategory(ProductSubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public ProductSubCategoryType getProductSubCategoryType() {
		return this.productSubCategoryType;
	}

	public void setProductSubCategoryType(
			ProductSubCategoryType productSubCategoryType) {
		this.productSubCategoryType = productSubCategoryType;
	}

	public String getAddDesc() {
		return this.addDesc;
	}

	public void setAddDesc(String addDesc) {
		this.addDesc = addDesc;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Boolean getNegotiable() {
		return this.negotiable;
	}

	public void setNegotiable(Boolean negotiable) {
		this.negotiable = negotiable;
	}

	public String getImage1() {
		return this.image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return this.image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return this.image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return this.image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}