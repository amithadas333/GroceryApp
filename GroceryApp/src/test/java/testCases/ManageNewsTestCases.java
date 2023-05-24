package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageNews;
import utilities.ExcelRead;

public class ManageNewsTestCases extends BaseClass {
	LoginPage lp;
	ManageNews mn;

	@Test
	public void verifyManageNewsAlertMessage() {
		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		mn = new ManageNews(driver);
		mn.clickOnManageContent();
		mn.clickOnManageNews();
		mn.clickOnNew();
		try {
			mn.enterNews(ExcelRead.readStringData(1, 0, "Sheet6"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		mn.clickOnSave();
		String actualResult = mn.checkAlertMessage();
		String expectedResult = Constants.ManageNewsTestCases;
		Assert.assertEquals(actualResult, expectedResult, Constants.ManageNewsTestCasesOutPut);

	}
}
