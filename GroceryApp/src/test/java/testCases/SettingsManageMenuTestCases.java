package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.SettingsManageMenu;
import utilities.ExcelRead;

public class SettingsManageMenuTestCases extends BaseClass {
	LoginPage lp;
	SettingsManageMenu sm;

	@Test
	public void verifyMenuManagementAlertMessage() throws InterruptedException {
		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		sm = new SettingsManageMenu(driver);
		sm.clickSettings();
		sm.clickManageMenu();
		sm.clickNew();
		try {
			sm.menuName(ExcelRead.readStringData(1, 0, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		sm.clickParentMenu();
		try {
			sm.enterUrl(ExcelRead.readStringData(1, 1, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			sm.enterFaIcon(ExcelRead.readStringData(1, 2, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			sm.enterMenuOrder(ExcelRead.readIntegerData(1, 3, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			sm.enterTableName(ExcelRead.readStringData(1, 4, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			sm.enterFileName(ExcelRead.readStringData(1, 5, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			sm.enterColor(ExcelRead.readStringData(1, 6, "Menu Name"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		sm.clickYess();
		sm.clickSave();
		String actualResult = sm.getAlertMessage();
		String expectedResult = Constants.SettingsManageMenu;
		Assert.assertEquals(actualResult, expectedResult, Constants.SettingsManageMenuOutPut);

	}
}
