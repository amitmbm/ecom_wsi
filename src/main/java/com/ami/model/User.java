package com.ami.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name = "user_email")
	private String email;

	@Column(name = "user_passwd")
	private String passwd;
    
	@Column(name = "is_registerd")
	private byte isRegister;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	public byte getIsRegister() {
		return isRegister;
	}

	/**
	 * @param isRegister the isRegister to set
	 */
	public void setIsRegister(byte isRegister) {
		this.isRegister = isRegister;
	}
	
    
}
