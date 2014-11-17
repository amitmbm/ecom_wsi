package com.ami.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testng.Assert;

/**
 * 
 * @author KH1871 (Test-class to test the REST endpoint of User WS , it performs the CRUD operation on User resource)
 *
 */
public class TestUserRestSvcs {
	
	protected static MockMvc mockMvc;
	
	
    // @Test(enabled=true , description="used to create the user")
	 private void createUser(String fisrtName , String lastName , String email , long phone) {
    	 
    	 String content = "{" + "firstName:'" + fisrtName + "'"
    			 + "lastName:'" + lastName + "'"
    			 + "email:'" + email + "'"
    			 + "phone:'" + phone + "'"
              //   + ", type:'concurrent'"
               //  + ", operations:['app1.op1', 'app2.op2']" 
               //  + ", postprocessor:'com.kony.abc.Test1'" + ", jar:'-1'"
                 + "}";
         String url = "/users";
         ResultActions resultActions = null;

         try {
               // Object mockHttpSession=null;
				resultActions = mockMvc.perform(post(url).session(null)
                             .content(content)
                             .accept(MediaType.APPLICATION_JSON));
                Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the orchestration");
                
         } catch (Exception e) {
               e.printStackTrace();
         }
  }

}
