package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageContent;
import utilities.ExcelRead;

public class ManageContentTestCases extends BaseClass {
	LoginPage lp;
	ManageContent mc;

	@Test
	public void verifyUpdateAlertMessage() throws InterruptedException, IOException {
		lp = new LoginPage(driver);

		lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));

		mc = new ManageContent(driver);
		mc.clickOnManageContent();
		mc.clickOnManageContacts();
		mc.clickOnAction();
		mc.editDeliveryTime("Mon-Sat: 11am to 6 pm Sunday off");

		mc.update();
		String actual = mc.getAlertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected output");

	}
}
