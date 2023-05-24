package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ExpenseCategoryDynamicTable;
import utilities.ExcelRead;



public class ExpenseCategoryDynamicTableTestCases extends BaseClass {
	LoginPage lp;
	ExpenseCategoryDynamicTable md;

	@Test
	public void verifyThatEditExpenseCategoryTitleAlert() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData(1, 0,"Sheet1"));
		lp.enterPassword(ExcelRead.readStringData(1, 1,"Sheet1"));
		lp.signIn();
		md = new ExpenseCategoryDynamicTable(driver);
		md.clickOnclickManageExpense();
		md.clickOnExpenseCategory();
		md.getFirstFiveTabelDetails();
		md.editExpenseCategoryInformations();
		md.editExpenseCategoryInformation(ExcelRead.readStringData(1, 0,"Sheet2"));
		md.clickOnUpdate();
		String actual = md.getAlertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected output");
	}


	
	@Test
	public void click() throws IOException
	{
		lp = new LoginPage(driver);
		lp.enterUserName(ExcelRead.readStringData(1, 0,"Sheet1"));
		lp.enterPassword(ExcelRead.readStringData(1, 1,"Sheet1"));
		lp.signIn();
		md = new ExpenseCategoryDynamicTable(driver);
		md.clickOnclickManageExpense();
		md.clickOnExpenseCategory();
		md.newDetails();
		String actual = md.getAlertText();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "not expected output");

		
		
	}
}

