package com.ami.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
 
public class ResponseCorsFilter implements ContainerResponseFilter {
 
    @Override
    public ContainerResponse filter(ContainerRequest req, ContainerResponse contResp) {
 
    	// code which i copied from net(simpleAPI)
      /*  ResponseBuilder resp = Response.fromResponse(contResp.getResponse());
        resp.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS , PUT , DELETE");
 
        String reqHead = req.getHeaderValue("Access-Control-Request-Headers");
 
        if(null != reqHead && !reqHead.equals("")){
            resp.header("Access-Control-Allow-Headers", reqHead);
            resp.header("x-powered-by", "my olx system");
        }
 
        contResp.setResponse(resp.build());
            return contResp;*/
    	if(contResp.getHttpHeaders().get("Access-Control-Allow-Origin")==null)
    		contResp.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
    		
    		contResp.getHttpHeaders().add("Access-Control-Allow-Headers", 
    			"origin," +
    			"content-type," +
    			"accept," +
    			"authorization,"+
    			"if-modified-since," +
    			"pragma," +
    			"cache-control");
    		contResp.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
    		contResp.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    		contResp.getHttpHeaders().add("Access-Control-Max-Age", "1209600");
    		return contResp;
    }
 
}