package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.ProductCategory;

@XmlRootElement(name = "category")
public class CategoryDTO {
	
	private String catguid;
	private String catname;
	private String catdesc;
	
	public CategoryDTO() {
	}
	
	public CategoryDTO(ProductCategory productCategory) {
		setCatdesc(productCategory.getCatDesc());
		setCatguid(productCategory.getCatGuid());
		setCatname(productCategory.getCatName());
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
	
	
	
}
