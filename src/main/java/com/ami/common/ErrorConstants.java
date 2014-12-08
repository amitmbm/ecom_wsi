package com.ami.common;

public enum ErrorConstants {
	INTERNAL_SYSTEM_ERROR(0, "Unexpected exception occurred"),
	RESOURCE_NOT_EXIST(1, "Resource not exist"),
	BAD_REQUEST(2,"bad request");

	private int code;
	private String message;

	private ErrorConstants(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
