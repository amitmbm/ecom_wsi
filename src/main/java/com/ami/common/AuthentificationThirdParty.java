package com.ami.common;

public class AuthentificationThirdParty {
	
	public static Boolean authentification(String userName , String passwd)
	{
       if(userName.equals("amit") && passwd.equals("khandelwal"))
		return true;     		
       return false;
	}

}
