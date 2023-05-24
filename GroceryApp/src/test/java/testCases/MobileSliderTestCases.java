package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.MobileSlider;
import utilities.ExcelRead;

public class MobileSliderTestCases extends BaseClass {
	LoginPage lp;
	MobileSlider ms;

	@Test
	public void verifyAlertMessageAfterFileUpload() throws IOException, AWTException {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		ms = new MobileSlider(driver);
		ms.clickOnMobileSlider();
		ms.clickOnNew();
		ms.selectDropDown();
		ms.clickChooseFile();
		ms.clickSubmitButton();
		String actual = ms.alertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected output");

	}
}
