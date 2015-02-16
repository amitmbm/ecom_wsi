package com.ami.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.ProductSubCategory;

@XmlRootElement(name = "subcategory")
public class SubCategoryDTO {

	private String subCatGuid;
	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String subCatName;
	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String subCatDesc;

	// time-stamp detail
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

	public SubCategoryDTO() {
	}

	public SubCategoryDTO(ProductSubCategory productSubCategory) {
		setSubCatGuid(productSubCategory.getSubCatGuid());
		setSubCatName(productSubCategory.getSubCatName());
		setSubCatDesc(productSubCategory.getSubCatDesc());
		setCreatedAt(productSubCategory.getCreatedAt());
		setCreatedBy(productSubCategory.getCreatedBy());
		setUpdatedAt(productSubCategory.getUpdatedAt());
		setUpdatedBy(productSubCategory.getUpdatedBy());
	}

	@XmlElement(name = "id")
	public String getSubCatGuid() {
		return subCatGuid;
	}

	public void setSubCatGuid(String subCatGuid) {
		this.subCatGuid = subCatGuid;
	}

	@XmlElement(name = "name")
	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	@XmlElement(name = "desc")
	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	@XmlElement(name = "created_at", nillable = true)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@XmlElement(name = "created_by", nillable = true)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@XmlElement(name = "updated_at", nillable = true)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@XmlElement(name = "updated_by", nillable = true)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
