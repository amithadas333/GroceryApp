package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;

public class ManageLocationTestCases extends BaseClass {
	LoginPage lp;
	ManageLocation ml;

	@Test
	public void verifyManageLocationAlertMessage() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		ml = new ManageLocation(driver);
		ml.clickManageLocation();
		String actual = ml.clickOnDelete();
		String expected = Constants.ManageLocationAlertMessage;
		Assert.assertEquals(actual, expected, Constants.ManageLocationAlertMessageOutPut);

	}
}
