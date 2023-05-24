package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageExpenseInputAllDetails;
import utilities.ExcelRead;

public class ManageExpenseInputAllDetailsTestCases extends BaseClass {
	LoginPage lp;
	ManageExpenseInputAllDetails mi;

	@Test
	public void verifyAddExpenseAlertMessage() throws InterruptedException {
		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), (ExcelRead.readStringData(1, 1, "Sheet1")));
		} catch (IOException e) {

			e.printStackTrace();
		}

		mi = new ManageExpenseInputAllDetails(driver);
		mi.clickManageExpense();
		mi.clickSubManageExpense();
		mi.clickOnNew();
		mi.clickOnUserDropDown();
		mi.clickOnNext();

		mi.selectDate("25-05-2023");

		mi.clickOnCategory();
		mi.clickOnOrderId();
		mi.clickOnPurchaseId();
		mi.clickOnExpenseType();
		try {
			mi.enterAmount(ExcelRead.readIntegerData(1, 0, "Sheet5"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			mi.enterRemarks(ExcelRead.readStringData(1, 1, "Sheet5"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		mi.chooseFiles();
		mi.clickOnSave();
		String actualResult = mi.checkAlertMessage();
		String expectedResult = Constants.ManageExpenseInputAllDetails;
		Assert.assertEquals(actualResult, expectedResult, Constants.ManageExpenseInputAllDetailsOutPut);

	}

}
