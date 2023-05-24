package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageCategory;
import utilities.ExcelRead;

public class ManageCategoryTestCase extends BaseClass {
	LoginPage lp;
	ManageCategory mc;

	@Test
	public void verifyAddCategoryAlertMessage() throws InterruptedException {

		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		mc = new ManageCategory(driver);
		mc.clickOnManageCategory();
		mc.clickOnCategory();
		mc.clickOnNew();
		try {
			mc.enterTheCategory(ExcelRead.readStringData(1, 0, "ManageCategory"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		mc.clickOnGroup();
		mc.chooseFile();
		mc.clickOnNoTopMenu();
		mc.clickOnLeftMenu();
		mc.clikOnSave();
		String actualResult = mc.checkAlertMessage();
		String expectedResult = Constants.ManagePaymentMethods;
		Assert.assertEquals(actualResult, expectedResult, Constants.ManageNewsTestCasesOutPut);

	}
}
