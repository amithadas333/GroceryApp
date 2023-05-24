package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePageSettings;
import elementRepository.LoginPage;

public class HomePageSettingsTestCases extends BaseClass {

	LoginPage lp;
	HomePageSettings hs;

	@Test(priority=2)
	public void verifyHomePageChangePasswordPageText() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		hs = new HomePageSettings(driver);
		hs.pageScrollDown();
		hs.clickOnSettings();
		hs.clickOnChangePassword();
		String actual = hs.newPasswordPageText();
		String expected = "Enter Password Informations";

		Assert.assertEquals(actual, expected, "invalid text");
	}

	@Test(priority=1)
	public void verifyNewPasswordDetails() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		hs = new HomePageSettings(driver);
		hs.pageScrollDown();
		hs.clickOnSettings();
		hs.clickOnChangePassword();
		hs.userName("admin");
		hs.userNewPassword("amitha");
		hs.confirmPasswordReEnter("amitha");
		hs.clickOnCancel();
		String actual = hs.newPasswordRestText();
		String expected = "Reset Password";
		Assert.assertEquals(actual, expected, "not expected output");

	}

}
