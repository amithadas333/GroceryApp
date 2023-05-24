package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import elementRepository.TestingLogin;

public class LoginTestCase extends BaseClass {
	TestingLogin tp;

	@Test(dataProvider = "userLogin", dataProviderClass = DataProviderList.class)
	public void verifySucessFullLogin(String type, String username, String password) throws IOException {

		tp = new TestingLogin(driver);
		tp.enterUserName(username);
		tp.enterPassword(password);

		tp.signIn();
		if (type.equals("valid")) {
			String actual = tp.text();
			String expected = "7rmart supermarket";

			Assert.assertEquals(actual, expected, "not expected output");

		} else if (type.equals("invalid")) {
			String actual = tp.loginInvalid();
			String expected = "Alert!";
			Assert.assertEquals(actual, expected, "not expected output");
		}

	}



}
