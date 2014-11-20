package com.ami.test;

/**
 * 
 * @author Amit Khandelwal
 * 
 * 1. This class is used to read the test-data from the from the JSON file ,
 * And using test-data it will create the various integ and orch Svcs.
 * 
 * 2. it will publish all the integ and orch Svcs , so that svcs can be used 
 * to hit run-time anywhere.
 *
 */
public class TestDataCreation  {
	 private static final String filePath = "src//test//resources//TEST_DATA.json";
     private static final String SERVICE_FORM_NAME1 = "IntSvc";
     private static final String SERVICE_FORM_NAME2 = "IntSvc4";
     static{
    	 
     
                // get the payload for creating the orchestration from the JSON-TEST DATA file
          /*  try{
                     FileReader reader = new FileReader(filePath);JSONParser jsonParser = new JSONParser();
                     JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
                     JSONObject Looping = (JSONObject) jsonObject.get("Looping");
                     String Loop = Looping.toString();
                    
            }catch (Exception ex) {
                           ex.printStackTrace();
                     } */
     
     }
     
}

