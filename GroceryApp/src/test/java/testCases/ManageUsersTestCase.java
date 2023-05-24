package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageUsersClass;

public class ManageUsersTestCase extends BaseClass {
	LoginPage lp;
	ManageUsersClass mu;

	@Test
	public void verifyManageUserAlertMessage() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		mu = new ManageUsersClass(driver);
		mu.manageUserPageClick();
		mu.changeInactiveToActive();
		String actual = mu.alertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "shows invalid message");

	}
}
