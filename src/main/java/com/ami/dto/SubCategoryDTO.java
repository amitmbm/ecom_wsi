package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.ProductSubCategory;

@XmlRootElement(name = "subcategory")
public class SubCategoryDTO {
	
	private String subCatGuid;
	private String subCatName;
	private String subCatDesc;
	
	public SubCategoryDTO() {
	}
	
	public SubCategoryDTO(ProductSubCategory productSubCategory) {
		setSubCatGuid(productSubCategory.getSubCatGuid());
		setSubCatName(productSubCategory.getSubCatName());
		setSubCatDesc(productSubCategory.getSubCatDesc());
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
	
	
}
