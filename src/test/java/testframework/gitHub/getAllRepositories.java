package testframework.gitHub;


	
	
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import org.testng.annotations.Test;

	import static io.restassured.RestAssured.given;
	import static org.testng.Assert.assertEquals;


	public class getAllRepositories {
		
	

	    private static final String BASE_URL = "https://api.github.com";
	    @Test
	    
		    public void getAllRepositoriesTest() {
		    	
		    String token = "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";
	        // Set base URL
	        RestAssured.baseURI = BASE_URL;

	        // Make the API request
	        Response response = given()
	                .header("Authorization", "Bearer" + token) // Add your access token if needed
	                .get("/user/REvathiAnbu/repos");
	                response.prettyPrint();

	        // Validate status code
	        assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

	        // Validate content type
	       // assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8",
	               // "Content type is not as expected");

	        // Validate response schema (you need to define your schema or use an existing one)
	        // Example: response.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));

	        // Parse the response to a POJO (assuming you have a corresponding class, e.g., Repository)
	       /* Repository[] repositories = response.as(Repository[].class);

	        // Print total number of repositories
	        System.out.println("Total number of repositories: " + repositories.length);

	        // Print public repositories
	        System.out.println("Public repositories:");
	        for (Repository repo : repositories) {
	            if (repo.isPublic()) {
	                System.out.println(repo.getName());
	            }*/
	        
	    
	}

}
