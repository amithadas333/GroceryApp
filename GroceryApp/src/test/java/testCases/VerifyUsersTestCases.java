
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.VerifyUsers;

public class VerifyUsersTestCases extends BaseClass {
	LoginPage lp;
	VerifyUsers vu;

	@Test
	public void verifyUsersIsClickable() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassword("admin");
		lp.signIn();
		vu = new VerifyUsers(driver);
		vu.clickVerifyUsersTab();
		vu.clickSearchOnButton();
		vu.clickStatusDropDown();
		vu.clickSearchButton();
		String actual = vu.afterSearchResult();
		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, "not expected output");

	}

}
