package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageDeliveryBoyExcelRead 
{


	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	WebDriver driver;

	public ManageDeliveryBoyExcelRead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
WebElement clickManageDeliveryBoy;

@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
WebElement clickNew;

@FindBy(xpath = "//input[@id='name']")
WebElement enterName;

@FindBy(xpath = "//input[@id='email']")
WebElement enterEmail;

@FindBy(xpath = "//input[@id='phone']")
WebElement enterPhone;

@FindBy(xpath = "//textarea[@name='address']")
WebElement enterAddress;

@FindBy(xpath = "//input[@id='username']")
WebElement enterUserName;

@FindBy(xpath = "//input[@id='password']")
WebElement enterPassword;

@FindBy(xpath = "//button[@name='create']")
WebElement clickSave;
@FindBy(xpath = "//h5[text()=' Alert!']")
WebElement alertText;



public void clickOnManageDeliveryBoy()
{
	gu.getElementClick(clickManageDeliveryBoy);
}
public void clickOnNew()
{
	gu.getElementClick(clickNew);
}

public void performLogin(String name,String emailId,String addresss,String number,String userId,String password) throws InterruptedException
{
	enterName.sendKeys(name);
	enterEmail.sendKeys(emailId);
	enterAddress.sendKeys(addresss);
	enterPhone.sendKeys(number);

	enterUserName.sendKeys(userId);
	enterPassword.sendKeys(password);
	gu.getElementPageScroll(driver, 0, 4000);

	wu.waitForElementTOBeClickables(driver, "//button[@name='create']");
	gu.mediumDelay();
	gu.getElementClick(clickSave);
	
}
public void save() {
	gu.getElementClick(clickSave);
}

public String alertMessage() {
	return gu.getElementText(alertText);
}

}
