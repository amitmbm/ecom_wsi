package com.wsi.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wsi.entity.Groups;

@XmlRootElement(name = "groups")
public class GroupsDTO {
	
	private String id;
	private String name;
	private String type;
	
	// time-stamp detail
	private String createdBy;
	private String updatedBy;
	private Date createdAt;
	private Date updatedAt;
	
	
	
	public GroupsDTO() {
		super();
	}
	
	
	public GroupsDTO(Groups groups) {
		
		setId(groups.getId());
		setName(groups.getName());
		setType(groups.getType());
		setCreatedAt(groups.getCreatedAt());
		setUpdatedAt(groups.getUpdatedAt());
		setCreatedBy(groups.getCreatedBy());
		setUpdatedBy(groups.getUpdatedBy());
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
	@XmlElement(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
