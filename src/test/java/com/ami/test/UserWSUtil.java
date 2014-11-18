package com.ami.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ami.controller.UserController;

/**
 * 
 * @author KH1871 (Test-class to test the REST endpoint of User WS , it performs the CRUD operation on User resource)
 *
 */

@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring-config.xml" })
public class UserWSUtil {
	
     
	protected static MockMvc mockMvc;
	
	//@BeforeClass
	static{
		//MockitoAnnotations.initMocks(null);
		UserController instance = new UserController();
		//ReflectionTestUtils.setField(instance, "socialContext", this);
		mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
		System.out.println("moclmvc object is" + mockMvc);
		System.out.println("user oc" + instance);
	}
	
    // @Test(enabled=true , description="used to create the user")
	 public static ResultActions createUser(String fisrtName , String lastName , String email , String phone) {
		 
		 ResultActions resultActions=null;
		// MockHttpSession mockHttpSessionMy = new MockHttpSession();
/*    	 
    	 String content = "{" + "firstName:'" + fisrtName + "'"
    			 + "lastName:'" + lastName + "'"
    			 + "email:'" + email + "'"
    			 + "phone:'" + phone + "'"
                 + "}";
    	 System.out.println("content value is" + content);
         String url = "/users";*/
		 String payLoad = "{\"firstName\":\"ladhaladha\",\"lastName\":\"ladha\" ,\"email\":\"rohit.laddha@kony.com\",\"phone\":\"88888\"}";
		 System.out.println("again");
		 System.out.println("content is" + payLoad);
		 String url = "/users";
      

         try {
               // Object mockHttpSession=null;
				return mockMvc.perform(post(url).content(payLoad)
                             .contentType(MediaType.APPLICATION_JSON));
             //   Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the orchestration");
                
         } catch (Exception e) {
               e.printStackTrace();
               return resultActions;
         }
  }

}
