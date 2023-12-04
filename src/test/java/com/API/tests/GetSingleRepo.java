package com.API.tests;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.API.request.CreateUserPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.module.jsv.JsonSchemaValidator;

public class GetSingleRepo {
	
    @Test
    
	public void setUp() {
	     RestAssured.baseURI = "https://api.github.com/";
	     
	    String owner = "RevathiAnbu";
	 	String repo = "TekArchSalesforceAutomation";
		String invalidrepo = "Automation";
	 	String token ="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";
	    getUserRepo(owner, repo,token);
	    getUserRepo(owner, invalidrepo,token);
	 	getAllUserRepo(owner,token);
	}
    
 	
	//@Test
	public void getUserRepo(String owner, String repo, String token) {
		
		String endpoint =  "repos" + "/" + owner + "/" + repo;

		Response response = RestAssured
			
				.given()
		        .contentType(ContentType.JSON)
		        .header("Authorization", "Bearer " + token)
		        .when()
		        .get(endpoint);
		        response.prettyPrint();
		        
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
	
	@Test
	
	public void getAllUserRepo(String owner, String token) {
		
		String endpoint =  "users" + "/" + owner + "/" + "repos";
		//LoginDataPOJO tokenData = new LoginDataPOJO();
		//tokenData.setToken("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");
		//String token = "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";
		Response response = RestAssured
			
				.given()
		        .contentType(ContentType.JSON)
		        .header("Authorization", "Bearer " + token)
		        .when()
		        .get(endpoint);
		       
				//Number of Repositories
		         JsonPath jsonPath = response.jsonPath();
		         int numberOfRepositories = jsonPath.getInt("size()");
			     System.out.println("Number of Repositories: "+ numberOfRepositories);
			     
			     // Get the array of repositories
			        List<Map<String, Object>> repositories = jsonPath.getList("");
			        
			    

			        // Print the names of public repositories
			        System.out.println("Public Repositories:");
			        for (Map<String, Object> repository : repositories) {
			            boolean isPublic = (boolean) repository.get("private");
			            
			            if (isPublic) {
			                continue; //Skip private repositories
			            }
                        
			            String repoName = (String) repository.get("name");
			            System.out.println(repoName);
			            
			        }   
			        
		         
		         response.then()
		         .statusCode(200)
		         .contentType(ContentType.JSON)
		         .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")); 
		         response.then().log().all();
		      
		         
		         
			}
		
		        
}
