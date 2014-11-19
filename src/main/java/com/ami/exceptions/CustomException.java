package com.ami.exceptions;

/**
 * This class will be used to throw Exception with custom-msg
 * in the Test-Automation related to Integration Svcs.
 * @author KH1871 (Amit Khandelwal)
 *
 */
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errCode;

	public static final int INVALID_NAME_PROVIDED = 001;
	public static final String INVALID_NAME_PROVIDED_ERR_MSG = "invalid name provided";

	public static final int INVALID_HTTP_RESPONSE = 003;
	public static final String INVALID_HTTP_RESPONSE_ERR_MSG = "Invalid HTTP Response";
	
	public static final int INVALID_HTTP_STATE = 004;
	public static final String INVALID_HTTP_STATE_ERR_MSG = "Invalid HTTP State";


	public static final int INVALID_CHARACTER_ENCODING = 005;
	public static final String INVALID_CHARACTER_ENCODING_MSG = "Invalid Character Encoding";
	
	public static final int INVALID_JAXB_CONTEXT = 006;
	public static final String INVALID_JAXB_CONTEXT_ERR_MSG = "Invalid Context";
	
	public static final int INVALID_ZIP_FILE_CREATION = 7;
	public static final String INVALID_ZIP_FILE_CREATION_ERR_MSG = "Invalid ZIP file creation";

	public static final int INVALID_WAR_FILE = 8;
	public static final String INVALID_WAR_FILE_ERR_MSG = "Invalid Application WAR";
	
	public static final int HTTP_PROTOCOL_ERROR = 9;
	public static final String HTTP_PROTOCOL_ERROR_MSG = "HTTP Protocol error";
	
	public static final int IO_ERROR = 10;
	public static final String IO_ERROR_MSG = "IO error";
	
	public static final int ERROR_FETCHING_DATA = 11;
	public static final String ERROR_FETCHING_DATA_MSG = "Invalid response";
	
	public static final int ASSOCIATION_OF_SERVICE_FAILED = 12;
	
	public CustomException() {

	}

	public CustomException(String errorMsg, int errorCode) {
		super(errorMsg);
		this.errCode = errorCode;
	}
	
	public int getErrorCode() {
		return errCode;
	}
}
