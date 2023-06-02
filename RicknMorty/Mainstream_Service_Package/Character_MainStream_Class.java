package Mainstream_Service_Package;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class Character_MainStream_Class {
	public static int statusCode(String baseURI,String resource)
	{
		RestAssured.baseURI=baseURI;
		
		int statusCode=given().header("Postman-Token","<calculated when request is sent>")
						.get(resource)
						.then().extract().statusCode();
		return statusCode;
	}
	public static String responseBody(String baseURI,String resource)
	{
		RestAssured.baseURI=baseURI;
		
		String responseBody=given().header("Postman-Token","<calculated when request is sent>")
							.get(resource)
							.then().extract().response().asString();
		return responseBody;
	}
}