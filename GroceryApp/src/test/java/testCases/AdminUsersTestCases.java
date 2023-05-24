package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.AdminUsers;
import elementRepository.LoginPage;

public class AdminUsersTestCases extends BaseClass {
	LoginPage lp;
	AdminUsers au;

	@Test(retryAnalyzer = Retry.class)
	public void verifyAdminUsersAlertMessage() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		au = new AdminUsers(driver);
		au.clickAdminUsers();
		au.clickNew();
		au.enterUserName("admin");
		au.enterPassword("admin");
		au.clickOnDropDown();
		au.clickOnSave();
		String actual = au.getAlertText();
		String expected = Constants.AdminUsersAlertMessage;
		Assert.assertEquals(actual, expected, Constants.errorMessage);

	}
	
	
	}

