package com.wsi.dto;

import java.util.Date;


/*import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wsi.entity.ProductSubCategoryType;

@XmlRootElement(name = "type")
public class TypeDTO {

	private String typeGuid;
	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String typeName;

	// time-stamp detail
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

	public TypeDTO() {
	}

	public TypeDTO(ProductSubCategoryType productSubCategoryType) {
		setTypeGuid(productSubCategoryType.getTypeGuid());
		setTypeName(productSubCategoryType.getTypeName());
		setCreatedAt(productSubCategoryType.getCreatedAt());
		setCreatedBy(productSubCategoryType.getCreatedBy());
		setUpdatedAt(productSubCategoryType.getUpdatedAt());
		setUpdatedBy(productSubCategoryType.getUpdatedBy());
	}

	@XmlElement(name = "id")
	public String getTypeGuid() {
		return typeGuid;
	}

	public void setTypeGuid(String typeGuid) {
		this.typeGuid = typeGuid;
	}

	@XmlElement(name = "name")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
