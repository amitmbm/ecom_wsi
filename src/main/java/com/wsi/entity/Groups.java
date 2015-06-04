package com.wsi.entity;

// Generated May 31, 2015 3:40:50 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Groups generated by hbm2java
 */
public class Groups extends MasterDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -911230325237022109L;
	private String id;
	private String name;
	private String type;
	private Set aclses = new HashSet(0);
	private Set userses = new HashSet(0);

	public Groups() {
	}

	public Groups(String id, String name, String type, Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Groups(String id, String name, String type, String createdBy,
			String updatedBy, Date createdAt, Date updatedAt, Set aclses,
			Set userses) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.aclses = aclses;
		this.userses = userses;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@XmlTransient
	public Set getAclses() {
		return this.aclses;
	}

	public void setAclses(Set aclses) {
		this.aclses = aclses;
	}

	@XmlTransient
	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}
}
