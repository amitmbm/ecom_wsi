package com.ami.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ami.common.DiagnosisUtil;


@Component
@Path("/api/v1/common/diagnosis")
public class HeathCheckController {

	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public String diagDetails() {
	    JSONObject jsonResponse = new JSONObject();
	    jsonResponse.put("memoryPool", DiagnosisUtil.getMemoryPoolInfo());
	    jsonResponse.put("threadPool", DiagnosisUtil.getThreadPoolInfo());
	    System.out.println("printing the response"+jsonResponse.toString());
	    return jsonResponse.toString();
	  }
}
