package com.wsi.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wsi.entity.Resources;

@XmlRootElement(name = "resources")
public class ResourcesDTO {

	private String id;
	private String name;
	private String createdBy;
	private String updatedBy;
	private Date createdAt;
	private Date updatedAt;
	
	public ResourcesDTO() {
	}
	
	public ResourcesDTO(Resources resources)
	{
		setId(resources.getId());
		setName(resources.getName());
		setCreatedAt(resources.getCreatedAt());
		setUpdatedAt(resources.getUpdatedAt());
		setCreatedBy(resources.getCreatedBy());
		setUpdatedBy(resources.getUpdatedBy());
	}
	
	@XmlElement(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "created_by" , nillable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@XmlElement(name = "updated_by" , nillable=true)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@XmlElement(name = "created_at" , nillable=true)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@XmlElement(name = "updated_at" , nillable=true)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
