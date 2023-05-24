package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationsClass {

	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public PushNotificationsClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement clickPushNotifications;

	@FindBy(xpath = "//input[@id='title']")
	WebElement enterTitle;

	@FindBy(xpath = "//input[@id='description']")
	WebElement enterDescription;

	@FindBy(xpath = "//button[@name='create']")
	WebElement send;

	public void clickPushNotifications()

	{
		gu.getElementClick(clickPushNotifications);

	}

	public void enterTitleDetails(String title) {
		enterTitle.sendKeys(title);
	}

	public void enterDescriptionDetails(String Description) {
		enterDescription.sendKeys(Description);
	}

	public String clickOnSendButton()

	{
		gu.getElementClick(send);

		return gu.getElementText(send);

	}

}
