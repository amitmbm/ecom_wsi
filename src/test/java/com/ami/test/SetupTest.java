package com.ami.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ami.controller.CategoryController;
import com.ami.services.CategoryServicesImpl;


@WebAppConfiguration
@ContextConfiguration({
		"file:Src/main/resources/ApplicationContext.xml"
 })
public class SetupTest extends AbstractTestNGSpringContextTests{

	@Mock
    private CategoryServicesImpl categoryServicesImpl;
  
    @InjectMocks
    private CategoryController categoryController;
    
    @Mock
    View mockView;
 
    private MockMvc mockMvc;
 
    @BeforeClass
    public void setup() {
        MockitoAnnotations.initMocks(this);
 
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).setSingleView(mockView).build();
        
        System.out.println("mockmvc" + mockMvc);
 
      //  when(validator.supports(any(Class.class))).thenReturn(true);
    }
    
    @Test
    public void test()
    {
    	String url="http://localhost:9090/TestWS/api/v1/manage/categories/";
    	String payLoad = "{\"name\":\"mobile\",\"desc\":\"mobileandtablet\" }";
    	try {
			mockMvc.perform(post(url).content(payLoad).contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // Assert.assertEquals(resultActions.andReturn().getResponse().getStatus(), 200,"failed to create the orchestration");
    }
 
  
}
