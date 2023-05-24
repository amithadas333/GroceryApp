package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class TestingLogin {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public TestingLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInClick;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement findTextAfterLogin;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement unSuccessFullLogin;

	public void enterUserName(String userNameEnter) {
		userName.sendKeys(userNameEnter);
	}

	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void signIn() {
		gu.getElementClick(signInClick);

	}
	

	public String text() {
		return gu.getElementText(findTextAfterLogin);
	}

	public String loginInvalid() {
		return gu.getElementText(unSuccessFullLogin);
	}
}
