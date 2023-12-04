package com.API.tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.API.request.CreateUserPOJO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateRepo {

    @Test
    public void createRepoTest() {
    	
    	CreateUserPOJO userpojo = new CreateUserPOJO();
    	userpojo.setName("Testing");
    	userpojo.setDescription("This is your first repo che kinjnj!");
    	userpojo.setHomepage("https://github.com");
    	//userpojo.setPrivatevalue(false);
    	
    
    	
        String baseUrl = "https://api.github.com/";
        String owner = "RevathiAnbu";
    	String token ="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";

        // Set the base URI for GitHub API
        RestAssured.baseURI = baseUrl;

        // Perform POST request to create a new repository
        String endpoint = "/" + "user" +  "/" + "repos";
        Response response = given()
        		
        	
		        .contentType(ContentType.JSON)
		        .header("Authorization", "Bearer " + token)
		        .body(userpojo)
		        .when()
		        .put(endpoint);
        		
                response.then()
                .assertThat()
                .statusCode(201)
                .body("name", equalTo("Testing"))
                .body("owner.login", equalTo(owner))
                .body("owner.type", equalTo("User"));
              //.extract()
              //.response();
        

        // Print the response body
        //System.out.println("Response body: " + response.asString());
    }
}