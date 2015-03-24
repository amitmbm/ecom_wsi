package com.ami.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.UserProfile;
import com.ami.validator.ValidUserRegisterStatus;

@XmlRootElement(name = "user_profile")
//@ValidUserRegisterStatus
public class UserProfileDTO {

	@NotNull
	@Size(min = 5, max = 128)
	private String emailId;
	/*@NotNull
	@Size(min = 5, max = 128)*/
	private String passwd;
/*	@NotNull
	@Size(min = 5, max = 128)*/
	private String firstName;
/*	@NotNull
	@Size(min = 5, max = 128)*/
	private String lastName;
	
	private Long phoneNum;
	@ValidUserRegisterStatus
	private boolean isRegister;

	// time-stamp detail
	private Date createdAt;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

	public UserProfileDTO() {

	}

	public UserProfileDTO(UserProfile userProfile) {
		setEmailId(userProfile.getUserEmail());
		setFirstName(userProfile.getFirstName());
		setLastName(userProfile.getLastName());
		setIsRegister(userProfile.getUsers().getIsRegisterd());
		setPasswd(userProfile.getUsers().getUserPasswd());
		setPhoneNum(userProfile.getPhoneNum());
		setCreatedAt(userProfile.getCreatedAt());
		setCreatedBy(userProfile.getCreatedBy());
		setUpdatedAt(userProfile.getUpdatedAt());
		setUpdatedBy(userProfile.getUpdatedBy());

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

	@XmlElement(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "phone")
	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
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
