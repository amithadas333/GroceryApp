package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyExcelRead;
import utilities.ExcelRead;

public class ManageDeliveryBoyTestCases extends BaseClass {

	LoginPage lp;
	ManageDeliveryBoyExcelRead me;

	@Test
	public void verifyAddDeliveryBoyAlertMessage() throws IOException, InterruptedException {
		lp = new LoginPage(driver);

		lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		me = new ManageDeliveryBoyExcelRead(driver);
		me.clickOnManageDeliveryBoy();
		me.clickOnNew();
		me.performLogin(ExcelRead.readStringData(1, 0, "Sheet2"), ExcelRead.readStringData(1, 1, "Sheet2"),
				ExcelRead.readStringData(1, 2, "Sheet2"), ExcelRead.readIntegerData(1, 3, "Sheet2"),
				ExcelRead.readStringData(1, 4, "Sheet2"), ExcelRead.readStringData(1, 5, "Sheet2"));
		String actual = me.alertMessage();
		String expected = Constants.ManageDeliveryBoy;
		Assert.assertEquals(actual, expected, Constants.ManageDeliveryBoyOutPut);
	}

}
