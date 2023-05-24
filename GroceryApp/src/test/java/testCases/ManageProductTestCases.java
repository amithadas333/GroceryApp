package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;
import elementRepository.ManageProductExcelRead;
import utilities.ExcelRead;

public class ManageProductTestCases extends BaseClass {
	LoginPage lp;
	ManageProductExcelRead mp;

	@Test
	public void verifyManageProductButtonColor() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		mp = new ManageProductExcelRead(driver);
		mp.manageProduct();
		String expected = mp.resetButtonColor();
		String actual = Constants.ManageProductTest;
		Assert.assertEquals(actual, expected, Constants.ManageProductTestOutPut);

	}

	@Test
	public void verifyManageProductCategoryAlertMessage() throws IOException, AWTException, InterruptedException {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		mp = new ManageProductExcelRead(driver);
		mp.manageProduct();
		mp.clickOnNew();
		mp.productAllInformations(ExcelRead.readStringData(1, 0, "Sheet4"), ExcelRead.readStringData(1, 1, "Sheet4"),
				ExcelRead.readStringData(1, 2, "Sheet4"), ExcelRead.readIntegerData(1, 3, "Sheet4"),
				ExcelRead.readIntegerData(1, 4, "Sheet4"), ExcelRead.readIntegerData(1, 5, "Sheet4"),
				ExcelRead.readStringData(1, 6, "Sheet4"), ExcelRead.readIntegerData(1, 7, "Sheet4"),
				ExcelRead.readStringData(1, 8, "Sheet4"));
		mp.selectveg();
		mp.groups();
		mp.priceType();
		mp.weightUnitEnter();

		mp.chooseFiles();

		// mp.chooseNextImage("\\src\\main\\resources\\FileUpload\\istockphotos.jpg");
		mp.chooseNextImage();
		mp.clickSaveButton();
		String actual = mp.AlertMessage();

		String expected = Constants.ManageProductCategoryAlertMessage;
		Assert.assertEquals(actual, expected, Constants.ManageProductCategoryAlertMessageOutPut);

	}

}
