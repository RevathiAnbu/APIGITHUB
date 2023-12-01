package testframework.gitHub;

import org.testng.annotations.Test;

public class InvalidSingleRepo extends BasePage {
	String token = "github.token";
	String owner = "github.owner";
	String repo = "github.invalidrepo";
	
	
	@Test
	public void basicauth() {
		//userNameElement.sendKeys(data);
		validateSingleRepository(token,owner,repo);
	}
	

}
