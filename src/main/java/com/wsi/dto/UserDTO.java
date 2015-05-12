package com.wsi.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wsi.entity.Users;

@XmlRootElement(name = "user")
public class UserDTO {

	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String emailId;
	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String passwd;

	private Boolean isRegister;

	// time-stamp detail
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

	public UserDTO() {

	}

	public UserDTO(Users users) {
		setEmailId(users.getUserEmail());
		setPasswd(users.getUserPasswd());
		setCreatedAt(users.getCreatedAt());
		setCreatedBy(users.getCreatedBy());
		setUpdatedAt(users.getUpdatedAt());
		setUpdatedBy(users.getUpdatedBy());
		// setIsRegister(users.getIsRegisterd());
	}

	@XmlElement(name = "mailid")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@XmlElement(name = "passwd")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@XmlElement(name = "is_register")
	public Boolean getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
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
