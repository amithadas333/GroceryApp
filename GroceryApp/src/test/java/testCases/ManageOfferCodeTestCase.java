package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageOfferCode;
import utilities.ExcelRead;

public class ManageOfferCodeTestCase extends BaseClass {
	LoginPage lp;
	ManageOfferCode mc;

	@Test
	public void verifyManageOrdersAssignDeliveryBoyAlertMessage() throws InterruptedException {
		lp = new LoginPage(driver);

		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		mc = new ManageOfferCode(driver);
		mc.clickManageOfferCode();
		mc.clickManageGiftCardsAndVouchers();
		mc.clickManageOrders();
		mc.clickAssignDeliveryBoy();
		mc.clickDropDown();
		mc.clickOnUpdate();
		String actualResult = mc.checkAlertMessage();
		String expectedResult = Constants.ManageOrdersAssignDeliveryBoyAlertMessage;
		Assert.assertEquals(actualResult, expectedResult, Constants.ManageOrdersAssignDeliveryBoyAlertMessageOutPut);

	}

	@Test
	public void verifyManageOrdersChangeDeliveryDateAlertMessage() throws InterruptedException {
		lp = new LoginPage(driver);
		try {
			lp.performLogin(ExcelRead.readStringData(1, 0, "Sheet1"), ExcelRead.readStringData(1, 1, "Sheet1"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		mc = new ManageOfferCode(driver);
		mc.clickManageOfferCode();
		mc.clickManageGiftCardsAndVouchers();
		mc.clickManageOrders();
		mc.clickChangeDeliveryDate();
		mc.clickDeliveryDate("28-04-2023");
		mc.clickOnTime("12:00am");

		mc.clickOnTimeBetween("12:00am");

		mc.updateon();

	}

}
