package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Linkdien {
	WebDriver driver;

	public Linkdien(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email-or-phone']")
	WebElement enterEmailId;

	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassword;

	@FindBy(xpath = "//button[@class='join-form__show-password-btn']")
	WebElement showPassword;

	@FindBy(xpath = "//button[@class='join-form__show-password-btn']")
	WebElement unHidePassword;

	public String enterEmailIds(String EmailID) {
		enterEmailId.sendKeys(EmailID);
		return EmailID;
	}

	public String enterPassword(String Password) {
		enterPassword.sendKeys(Password);
		return Password;
	}

	public void getPassword() throws InterruptedException {

		showPassword.click();
		Thread.sleep(2000);

	}

	public void getUnHidePassword() {

		unHidePassword.click();

	}

}
