package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCases extends BaseClass {

	LoginPage lp;

	@Test
	public void verifyLoginButtonText() {
		lp = new LoginPage(driver);

		String expected = "Sign In";
		String actual = lp.signInText();
		// assertion
		Assert.assertEquals(actual, expected, "not expected output");

	}
	@Test
	public void verifyLoginBackgroundColor() {
		lp = new LoginPage(driver);
		String expectedResult = "rgba(52, 58, 64, 1)";
		String actualResult = lp.getBackGroundColorSignIn();
		Assert.assertEquals(actualResult, expectedResult, "not expected output");
	}

	

	public void verifyLoginBorderColor() {
		lp = new LoginPage(driver);
		String expected1 = Constants.loginButtonBackgroundColor;
		String actual1 = lp.getBorderColorSignIn();
		Assert.assertEquals(actual1, expected1, Constants.error);

	}

	@Test(groups = "Critical")

	public void verifySucessFullLogin() throws IOException {

		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData(1, 0,"Sheet1"));
		lp.enterPassword(ExcelRead.readStringData(1, 1,"Sheet1"));
		String acutal = lp.signIn();
		String expected = "7rmart supermarket";
		Assert.assertEquals(acutal, expected, "not expected output");

	}
}