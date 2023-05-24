package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageContetDetails;
import utilities.ExcelRead;

public class ManageContetDetailsTestCases extends BaseClass {
	LoginPage lp;
	ManageContetDetails mc;

	@Test
	public void verifyManageContetDetailsAlertMessage() throws IOException, AWTException, InterruptedException {
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData(1, 0, "Sheet1"));
		lp.enterPassword(ExcelRead.readStringData(1, 1, "Sheet1"));
		lp.signIn();
		mc = new ManageContetDetails(driver);
		mc.clickOnManageContetDetails();
		mc.clickOnManagePages();
		mc.clickNew();
		mc.enterTitle(ExcelRead.readStringData(1, 2, "Sheet1"));
		mc.description(ExcelRead.readStringData(1, 3, "Sheet1"));
		mc.page(ExcelRead.readStringData(1, 4, "Sheet1"));

		mc.fileUpload();
		mc.clickSubmitButton();

		String actual = mc.getAlertMessageText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected output");

	}
}
