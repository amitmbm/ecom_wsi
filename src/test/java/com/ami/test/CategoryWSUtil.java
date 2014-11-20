package com.ami.test;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 
 * @author KH1871 (Test-class to test the REST endpoint of User WS , it performs the CRUD operation on User resource)
 *
 */

@WebAppConfiguration
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring-config.xml" })
public class CategoryWSUtil extends AbstractTestNGSpringContextTests{
	
	//@Autowired
	//protected static WebApplicationContext wac; 
	//protected  MockMvc mockMvc;
	
     // ApplicationContext context = new FileSystemXmlApplicationContext
       //     ("file:src/main/webapp/WEB-INF/spring-config.xml");
	
	
	
	//@BeforeClass
/*	static{
		//MockitoAnnotations.initMocks(null);
		//CategoryController instance = new CategoryController();
		//ReflectionTestUtils.setField(instance, "socialContext", this);
		//mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
		//mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		//System.out.println("moclmvc object is" + mockMvc);
		//System.out.println("user oc" + instance);
	}*/
	
    // UserProfileServicesImpl   obj = (UserProfileServicesImpl) context.getBean("userServicesImpl");
     
    // mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
     
	/* public  ResultActions createCategory() {
		 System.out.println("");
		 ResultActions resultActions=null;
		// MockHttpSession mockHttpSessionMy = new MockHttpSession();
    	 
    	 String content = "{" + "firstName:'" + fisrtName + "'"
    			 + "lastName:'" + lastName + "'"
    			 + "email:'" + email + "'"
    			 + "phone:'" + phone + "'"
                 + "}";
   	 System.out.println("content value is" + content);
         String url = "/users";
		 String payLoad = "{\"catName\":\"mobile\",\"catDesc\":\"mobileandtablet\" ,\"catguid\":\"abcd\"}";
		 System.out.println("again");
		 System.out.println("content is" + payLoad);
		 String url = "/categories";
      

         try {
               // Object mockHttpSession=null;
			//	return mockMvc.perform(post(url).content(payLoad)
              //               .contentType(MediaType.APPLICATION_JSON));
             //   Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the orchestration");
                
         } catch (Exception e) {
               e.printStackTrace();
               return resultActions;
         }
  }*/

}
