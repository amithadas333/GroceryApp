package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.PushNotificationsClass;
import utilities.GeneralUtilities;
import utilities.RandomGenerator;

public class PushNotificationsTestCase extends BaseClass {
	LoginPage lp;
	PushNotificationsClass pn;
	GeneralUtilities gu = new GeneralUtilities();
	RandomGenerator rg = new RandomGenerator();

	@Test
	public void verifyPushNotificationAlertMessage() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		pn = new PushNotificationsClass(driver);
		pn.clickPushNotifications();
		// pn.enterTitleDetails("Grocery"+Math.random()+"");
		pn.enterTitleDetails("sampleDetails" + rg.getRandomstring(3));

		pn.enterDescriptionDetails("this product is not available");
		String actual = pn.clickOnSendButton();
		String expected = "Send";
		Assert.assertEquals(actual, expected, "invalid message");

	}
}
