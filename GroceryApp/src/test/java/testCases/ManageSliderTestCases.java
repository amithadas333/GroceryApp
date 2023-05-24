package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageSlider;

public class ManageSliderTestCases extends BaseClass {
	LoginPage lp;
	ManageSlider ms;

	@Test
	public void verifyManageSliderAlertMessage() throws AWTException, InterruptedException {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		ms = new ManageSlider(driver);
		ms.selectMobileSlider();
		ms.selectNewButton();
		
		ms.clickOnChooseFile();

		ms.enterLink("https");

		String actual = ms.clickOnSend();

		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected text");

	}
}
