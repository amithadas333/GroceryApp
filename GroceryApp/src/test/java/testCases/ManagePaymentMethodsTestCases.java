package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManagePaymentMethods;

public class ManagePaymentMethodsTestCases extends BaseClass {
	LoginPage lp;
	ManagePaymentMethods mm;

	@Test
	public void verifyActiveToInActiveAlertStatus() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		mm = new ManagePaymentMethods(driver);
		mm.clickOnManagePaymentMethods();
		mm.changeStatus();
		String actual = mm.alertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected text");

	}
}
