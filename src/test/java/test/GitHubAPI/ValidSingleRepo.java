package test.GitHubAPI;



import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class ValidSingleRepo{

	    @Test
	    public void validateSingleRepository() {
	        // Read GitHub token, owner, and repo from config.properties
	        String token = getConfigProperty("github.token");
	        String owner = getConfigProperty("github.owner");
	        String repo = getConfigProperty("github.repo");
	        
	        System.out.println(token + owner + repo);

	        // Get the details of a single repository
	        Response response = GitHubAPIClient.getSingleRepository(owner, repo, token);

	        // Validate status code is 200
	        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

	        // Validate full_name is “owner/repoName”
	        String fullName = response.then().extract().path("full_name");
	        Assert.assertEquals(fullName, owner + "/" + repo, "Full name is incorrect");

	        // Validate the default_branch is as expected
	        String expectedDefaultBranch = getConfigProperty("github.expectedDefaultBranch");
	        String defaultBranch = response.then().extract().path("default_branch");
	        Assert.assertEquals(defaultBranch, expectedDefaultBranch, "Default branch is incorrect");
	    }

	    private String getConfigProperty(String propertyName) {
	    	String value="";
	    	try (InputStream input = new FileInputStream("src/test/resources/DataFile/configpropertyfile.properties")) {

	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);
	            
	          value = prop.getProperty(propertyName);

	            
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    	  return value;

	      

	    }
	}
	
	