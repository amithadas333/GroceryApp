package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.PrivateLogin;

public class LoginPrivateTestCases extends BaseClass {

	PrivateLogin mu;

	@Test
	public void getLoginDetails() {

		mu = new PrivateLogin(driver);
		mu.setUserName("admin");
		mu.setPassword("admin");
		mu.signIn();
		String actual = mu.text();
		String expected = Constants.LoginPrivateTest;

		Assert.assertEquals(actual, expected, Constants.LoginPrivateTestOutPut);

	}
}
