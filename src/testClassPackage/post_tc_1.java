package testClassPackage;
import java.io.IOException;

import org.testng.Assert;
import commonFunctionsPackage.API_Common_Function;
import commonFunctionsPackage.Utility_Common_Functions;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository;

public class post_tc_1 {
	
	public static void execute() throws IOException {
		
		for(int i=0 ; i<5 ; i++) 
		{
			int statusCode1 = API_Common_Function.response_statusCode(post_req_repository.base_URI(),
					post_req_repository.post_req_tc1(),post_req_repository.post_resource());
			
			if(statusCode1 == 200) 
			{	
				String responseBody1 = API_Common_Function.response_Body(post_req_repository.base_URI(),
					post_req_repository.post_req_tc1(), post_req_repository.post_resource());
				post_tc_1.validator(responseBody1, statusCode1);
				Utility_Common_Functions.evidenceFileCreator("post_tc_1", post_req_repository.post_req_tc1(), responseBody1);
				
				break;
				
			}
			else 
			{
				System.out.println("Correct StatusCode is not found, hence retrying the API ");
			}
			
		}	
	}	
			
		
	public static void validator(String responseBody1, int statusCode1)  {
		
        // Parse the response body
        JsonPath jsp = new JsonPath(responseBody1);
        String res_name = jsp.getString("name");
        String res_job = jsp.getString("job");
        String res_id = jsp.getString("id");
        String res_createdAt = jsp.getString("createdAt");

        // Validate the response body parameters
        Assert.assertEquals(statusCode1, 201);
        Assert.assertEquals(res_name, "morpheus");
        Assert.assertEquals(res_job, "leader");

        // Validate "id" and "createdAt" using Assert
        Assert.assertNotNull(res_id);
        Assert.assertNotNull(res_createdAt);

        // Validate "createdAt" using slice method for date
        String expectedDate = new java.util.Date().toInstant().toString().substring(0, 10);
        String actualDate = res_createdAt.substring(0, 10);
        Assert.assertEquals(actualDate, expectedDate);
        

    	System.out.println("Status code is: "+ statusCode1 + " Created");
    	// System.out.println(requestBody1);
    	System.out.println(responseBody1);
    	
		    	
		
	}

}