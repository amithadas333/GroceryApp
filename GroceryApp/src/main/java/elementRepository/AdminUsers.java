package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsers {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement clickOnAdminUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickOnNew;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement clickOnDropDown;

	@FindBy(xpath = "//input[@id='username']")
	WebElement enterUserName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassword;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement clickOnSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertText;

	public void clickAdminUsers() {
		gu.getElementClick(clickOnAdminUsers);
	}

	public void clickNew() {
		gu.getElementClick(clickOnNew);
	}

	public void enterUserName(String userNameEnter) {

		gu.sendValues(userNameEnter, enterUserName);
	}

	public void enterPassword(String userPassword) {

		gu.sendValues(userPassword, enterPassword);
	}

	public void clickOnDropDown() {
		gu.getElementClick(clickOnDropDown);
		gu.getDropDown(clickOnDropDown, 2);
	}

	public void clickOnSave() {
		gu.getElementClick(clickOnSave);

	}

	public String getAlertText() {
		return gu.getElementText(alertText);
	}

	public void pageScroll() {
		gu.getElementPageScroll(driver, 0, 8000);

	}

}
