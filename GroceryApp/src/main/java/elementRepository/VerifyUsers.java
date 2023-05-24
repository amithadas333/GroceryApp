package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class VerifyUsers {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public VerifyUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Verify Users']")
	WebElement clickOnVerifyUsers;

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement clickOnSearch;

	@FindBy(xpath = "//select[@id='st']")
	WebElement selectStatusDropDown;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement clickOnSearchButton;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement getResult;

	public void clickVerifyUsersTab() {
		// clickOnVerifyUsers.click();
		gu.getElementClick(clickOnVerifyUsers);
	}

	public void clickSearchOnButton() {
		gu.getElementClick(clickOnSearch);
	}

	public void clickStatusDropDown()

	{
		gu.getElementClick(selectStatusDropDown);

		Select obj = new Select(selectStatusDropDown);
		obj.selectByIndex(2);// to utilty
	}

	public void clickSearchButton()

	{
		gu.getElementClick(clickOnSearchButton);

	}

	public String afterSearchResult() {

		return gu.getElementText(getResult);
	}

}
