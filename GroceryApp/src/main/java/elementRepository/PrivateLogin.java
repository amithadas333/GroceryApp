package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class PrivateLogin 
{

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	private WebDriver driver;//

	public PrivateLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInClick;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	private WebElement findTextAfterLogin;

	public void setUserName(String userNameEnter) {
		userName.sendKeys(userNameEnter);
	}

	public void setPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void signIn() {
		gu.getElementClick(signInClick);

	}

	public String text() {
		return gu.getElementText(findTextAfterLogin);
	}

}
