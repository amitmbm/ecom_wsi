package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.UserProfile;

@XmlRootElement(name = "user_profile")
public class UserProfileDTO {

	private String emailId;
	private String passwd;
	private String firstName;
	private String lastName;
	private Long phoneNum;
	private Boolean isRegister;

	public UserProfileDTO() {

	}

	public UserProfileDTO(UserProfile userProfile)
	{
		setEmailId(userProfile.getUserEmail());
		setFirstName(userProfile.getFirstName());
		setLastName(userProfile.getLastName());
		setIsRegister(userProfile.getUsers().getIsRegisterd());
		setPasswd(userProfile.getUsers().getUserPasswd());
		setPhoneNum(userProfile.getPhoneNum());
		
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

	
}
