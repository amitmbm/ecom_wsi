package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.UserProfileId;
import com.ami.entity.Users;

@XmlRootElement(name = "user")
public class UserWithProfileDTO {

	private String emailId;
	private String passwd;
	private String firstName;
	private String lastName;
	private Long phoneNum;
	private Byte isRegister;

	public UserWithProfileDTO() {

	}

	public UserWithProfileDTO(UserProfileId userProfileId) {
		setFirstName(userProfileId.getFirstName());
		setLastName(userProfileId.getLastName());
		setPhoneNum(userProfileId.getPhoneNum());
		setEmailId(userProfileId.getUserEmail());
	}
	
	public UserWithProfileDTO(Users users)
	{
		setEmailId(users.getUserEmail());
		setPasswd(users.getUserPasswd());
		setIsRegister(users.getIsRegisterd());	
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
	public Byte getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Byte isRegister) {
		this.isRegister = isRegister;
	}

}
