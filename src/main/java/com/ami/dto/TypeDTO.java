package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.ProductSubCategoryType;

@XmlRootElement(name = "type")
public class TypeDTO {
	
	private String typeGuid;
	private String typeName;
	
		
	public TypeDTO() {
	}

	public TypeDTO(ProductSubCategoryType productSubCategoryType) {
		setTypeGuid(productSubCategoryType.getTypeGuid());
		setTypeName(productSubCategoryType.getTypeName());
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

	
}
