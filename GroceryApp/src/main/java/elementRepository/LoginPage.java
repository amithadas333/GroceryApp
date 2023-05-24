package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signIn;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement element2;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement element3;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInClick;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement findTextAfterLogin;
	
	@FindBy(xpath = "//h5[text()= Alert!']")
	WebElement unSuccessFullLogin;


	
	
	public String signInText() {
		return gu.getElementText(signIn);
	}

	public String getELement2Text() {
		return gu.getElementText(element2);
	}

	public String getELemen3Text() {
		return gu.getElementText(element3);
	}

//	public String getLoginText()
//	{
//		return gu.getLoginDetails(signInClick);
//	}

	public String getBackGroundColorSignIn() {
		return gu.getElementStyleProperty(signIn, "background-color");
	}

	public String getBorderColorSignIn() {
		return gu.getElementStyleProperty(signIn, "border-color");
	}

	public void enterUserName(String userNameEnter) {
		userName.sendKeys(userNameEnter);
	}

	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public String signIn() {
		gu.getElementClick(signInClick);

		return gu.getElementText(findTextAfterLogin);
	}
	
	public void performLogin(String user,String password1) {
		enterUserName(user);
		enterPassword(password1);
		signIn();
//		userName.sendKeys(user);
//		password.sendKeys(password1);
//		signInClick.click();
	}
	
	public String loginInvalid()
	{
		return gu.getElementText(unSuccessFullLogin);
	}

}
