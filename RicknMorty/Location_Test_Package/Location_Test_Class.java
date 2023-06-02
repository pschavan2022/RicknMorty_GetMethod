package Location_Test_Package;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import Mainstream_Service_Package.Character_MainStream_Class;
import Storehouse_Character_Package.Character_Storehouse_Class;
import Location_Test_Package.Location_Test_Class;

public class Location_Test_Class {
	@Test
	public static void execute() {
		
		String baseURI=Character_Storehouse_Class.baseURI();
		String resource=Character_Storehouse_Class.resource();
		
		int statusCode=Character_MainStream_Class.statusCode(baseURI,resource);
		String responseBody=Character_MainStream_Class.responseBody(baseURI,resource);
		
		JsonPath jsp=new JsonPath(responseBody);
		 int res_id=jsp.getInt("id");
		 String res_name=jsp.getString("name");
		 String res_type=jsp.getString("type");
		 String res_dimension=jsp.getString("dimension"); 
		 String exp_residents=jsp.getString("residents");
		 
		  Assert.assertEquals(statusCode, 200);
	      Assert.assertNotNull(res_name);
	      Assert.assertNotNull(res_id);
	      Assert.assertNotNull(res_type);
	      Assert.assertNotNull(res_dimension);
	      Assert.assertNotNull(exp_residents);
	   
		  System.out.println("rickandmortyapi.com-location "+responseBody);
		 
	}

}