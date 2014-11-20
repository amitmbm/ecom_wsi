package com.ami.dto;

public class UserDTO {

	String emailId;
	String passwd;
	Byte isRegister;
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the isRegister
	 */
	public Byte getIsRegister() {
		return isRegister;
	}
	/**
	 * @param isRegister the isRegister to set
	 */
	public void setIsRegister(Byte isRegister) {
		this.isRegister = isRegister;
	}
	
}
