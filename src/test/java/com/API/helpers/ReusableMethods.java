package com.API.helpers;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReusableMethods {
	
public void getUserRepo(String owner, String repo, String token) {
		
		String endpoint =  "repos" + "/" + owner + "/" + repo;
		//LoginDataPOJO tokenData = new LoginDataPOJO();
		//tokenData.setToken("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");
		//String token = "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";
		Response response = RestAssured
			
				.given()
		        .contentType(ContentType.JSON)
		        .header("Authorization", "Bearer " + token)
		        .when()
		        .get(endpoint);
		        //response.prettyPrint();
		        
		         response.then()
		         .statusCode(200)
		         .contentType(ContentType.JSON);
		         
		         // Validate status code is 200
			     Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
		         
			     // Validate full_name is “owner/repoName”
			     String fullName = response.then().extract().path("full_name");
		         //Assert.assertEquals(fullName, "RevathiAnbu/TekArchSalesforceAutomation", "Full name is incorrect");
			     Assert.assertEquals(fullName, owner + "/" + repo, "Full name is incorrect");
			
		          
			     // Validate the default_branch is as expected
	    	     String expectedDefaultBranch = "master";
			     String defaultBranch = response.then().extract().path("default_branch");
		         Assert.assertEquals(defaultBranch, expectedDefaultBranch, "Default branch is incorrect");
			}
	

}
