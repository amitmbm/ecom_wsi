package com.wsi.common;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class ServiceContext {

	private String requestId;
	private long inTime;
	private String serviceUrl;

	public ServiceContext(HttpServletRequest request) {
		this.requestId = UUID.randomUUID().toString();
		this.serviceUrl = request.getRequestURI();
		this.inTime = System.currentTimeMillis();
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public long getInTime() {
		return inTime;
	}
	public void setInTime(long inTime) {
		this.inTime = inTime;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
}
