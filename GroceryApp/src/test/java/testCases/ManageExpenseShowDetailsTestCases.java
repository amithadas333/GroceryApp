package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.LoginPage;

import elementRepository.ManageExpenseShowDetails;


public class ManageExpenseShowDetailsTestCases extends BaseClass {
	LoginPage lp;
	
	ManageExpenseShowDetails me;
	@Test
	public void verifyAddExpenseText() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		me = new ManageExpenseShowDetails(driver);
		me.clickManageExpense();
		me.clickOnManageExpenseRadio();
		me.clickOnNew();
		
		String actual = me.getTextForAddExpensePage();
		String expected = "Add Expense";
		Assert.assertEquals(actual, expected, "invalid text");
	}

	@Test
	public void verifyViewMoreTitle() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		me = new ManageExpenseShowDetails(driver);
		me.clickManageExpense();
		me.clickOnManageExpenseRadio();
		String actual = me.show();
		String expected = Constants.ManageExpenseShowDetails;
		Assert.assertEquals(actual, expected, Constants.ManageExpenseShowDetailsOutPut);

	}
	@Test
	public void verifyListExpenseTitle() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		me = new ManageExpenseShowDetails(driver);
		me.clickManageExpense();
		me.clickOnManageExpenseRadio();
		me.getViewMoreelement();
		
		boolean actual=	me.click_Sub_Manageexpense_ViewMore_button();

		
		boolean expected = true;
		Assert.assertEquals(actual, expected, "inavlid");

	}

	
}
