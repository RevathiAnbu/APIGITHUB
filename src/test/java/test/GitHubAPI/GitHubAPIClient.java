package test.GitHubAPI;


	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	public class GitHubAPIClient {

	    private static final String BASE_URL = "https://api.github.com";

	    public static Response getSingleRepository(String owner, String repo, String token) {
	        String endpoint = "/repos/" + owner + "/" + repo;
	    	//String endpoint = "/" + owner + "/" + repo;
	        System.out.println(endpoint);
	        System.out.println(owner + repo + token);
	        return RestAssured.given()
	                .baseUri(BASE_URL)
	                .header("Authorization", "Bearer " + token)
	                .get(endpoint);
	    }
	}



