package testframework.gitHub;

import org.testng.annotations.Test;

public class ValidateSingleRepo extends BasePage {


		// TODO Auto-generated method stub
		
		String token = "github.token";
		String owner = "github.owner";
		String repo = "github.repo";
		
		
		@Test
		public void basicauth() {
			//userNameElement.sendKeys(data);
			validateSingleRepository(token,owner,repo);
		}
		

	}


