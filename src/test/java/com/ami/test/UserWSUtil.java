package com.ami.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author KH1871 (Test-class to test the REST endpoint of User WS , it performs the CRUD operation on User resource)
 *
 */
public class UserWSUtil {
	
     
	@Autowired
	protected static WebApplicationContext wac;
	
	
	protected static MockMvc mockMvc;
	
     static{
    	 
    	 mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
     }
	
    // @Test(enabled=true , description="used to create the user")
	 public static ResultActions createUser(String fisrtName , String lastName , String email , String phone) {
		 
		 ResultActions resultActions=null;
		// MockHttpSession mockHttpSessionMy = new MockHttpSession();
    	 
    	 String content = "{" + "firstName:'" + fisrtName + "'"
    			 + "lastName:'" + lastName + "'"
    			 + "email:'" + email + "'"
    			 + "phone:'" + phone + "'"
                 + "}";
    	 System.out.println("content value is" + content);
         String url = "/users";
      

         try {
               // Object mockHttpSession=null;
				return mockMvc.perform(post(url).content(content)
                             .accept(MediaType.APPLICATION_JSON));
             //   Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the orchestration");
                
         } catch (Exception e) {
               e.printStackTrace();
               return resultActions;
         }
  }

}
