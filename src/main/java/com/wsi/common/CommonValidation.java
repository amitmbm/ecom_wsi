/**

Rohit Laddha
 */
package com.wsi.common;

public class CommonValidation {

	/**
	 * validates emailId
	 * 
	 * @param s
	 * @return
	 */
	public Boolean validateEmail(String s) {
		return s.matches("[\\S]+@[0-9a-zA-Z_]+.[0-9a-zA-Z_]+");
	}

	/**
	 * 
	 * @param inputString
	 * @param lowerBound
	 *            :expected lower limit
	 * @param upperBound
	 *            :expected upper limit
	 * @return
	 */
	public Boolean validateLength(String ipStr, int lowerBound, int upperBound) {
		if (ipStr.length() <= upperBound && ipStr.length() >= lowerBound) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * validates name, name must contain non zero english alphabets
	 * 
	 * @param name
	 * @return
	 */
	public Boolean validateName(String name) {
		return name.matches("[a-zA-Z]+");
	}

	/**
	 * validates passwd ( # Start of group (?=.*\d) # must contains one digit
	 * from 0-9 (?=.*[a-z]) # must contains one lowercase characters (?=.*[A-Z])
	 * # must contains one uppercase characters (?=.*[@#$%]) # must contains one
	 * special symbols in the list "@#$%" . # match anything with previous
	 * condition checking {6,20} # length at least 6 characters and maximum of
	 * 20 )
	 *
	 * ref
	 * http://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
	 *
	 * @param passwd
	 * @return
	 */
	public Boolean validatePassword(String passwd) {
		return passwd
				.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
	}
}
