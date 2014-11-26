package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.Users;

@XmlRootElement(name = "user")
public class UserDTO {

	private String emailId;
	private String passwd;
	private Byte isRegister;
	
	public UserDTO()
	{
		
	}
	
	public UserDTO(Users users)
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
	
	@XmlElement(name = "is_register")
	public Byte getIsRegister() {
		return isRegister;
	}
	
	public void setIsRegister(Byte isRegister) {
		this.isRegister = isRegister;
	}
	
}
