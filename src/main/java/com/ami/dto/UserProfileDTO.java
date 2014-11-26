package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.UserProfileId;

@XmlRootElement(name = "userprofile")
public class UserProfileDTO {

	private String firstName;
	private String lastName;
	private Long phoneNum;
	private String userEmail;
	
	public UserProfileDTO() {
	}
	
	public UserProfileDTO(UserProfileId userProfileId)
	{
	  setFirstName(userProfileId.getFirstName());
	  setLastName(userProfileId.getLastName());
	  setPhoneNum(userProfileId.getPhoneNum());
	  setUserEmail(userProfileId.getUserEmail());
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

	@XmlElement(name = "mailid")
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
