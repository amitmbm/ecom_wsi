package com.wsi.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.wsi.entity.ProductCategory;


@XmlRootElement(name = "category")
public class CategoryDTO {

	private String catguid;
	@NotEmpty
	@Size(min = 5, max = 128 ,message="{catgory.displayname.size}")
	private String catname;
	@NotNull
	@Size(min = 5, max = 128)
	private String catdesc;

	// time-stamp detail
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

	public CategoryDTO() {
	}

	public CategoryDTO(ProductCategory productCategory) {
		setCatdesc(productCategory.getCatDesc());
		setCatguid(productCategory.getCatGuid());
		setCatname(productCategory.getCatName());
		setCreatedAt(productCategory.getCreatedAt());
		setCreatedBy(productCategory.getCreatedBy());
		setUpdatedAt(productCategory.getUpdatedAt());
		setUpdatedBy(productCategory.getUpdatedBy());

	}

	@XmlElement(name = "id")
	public String getCatguid() {
		return catguid;
	}

	public void setCatguid(String catguid) {
		this.catguid = catguid;
	}

	@XmlElement(name = "name")
	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	@XmlElement(name = "desc")
	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
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
