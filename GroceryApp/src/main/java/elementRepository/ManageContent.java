package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageContent 
{

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	WebDriver driver;

	public ManageContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
WebElement clickManageContent;

@FindBy(xpath = "//p[text()='Manage Contact']")
WebElement clickManageContact;

@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
WebElement clickAction;

@FindBy(xpath = "//textarea[@id='content'][2]")
WebElement editDeliveryTime;


@FindBy(xpath = "//button[@name='Update']")
WebElement clickUpdate;

@FindBy(xpath = "//h5[text()=' Alert!']")
WebElement alertText;




public void clickOnManageContent()
{
	gu.getElementClick(clickManageContent);
}

public void clickOnManageContacts()
{
	gu.getElementClick(clickManageContact);
}

public void clickOnAction()
{
	gu.getElementClick(clickAction);
}

public void editDeliveryTime(String time)
{
	gu.getClear(editDeliveryTime);
	editDeliveryTime.sendKeys(time);
}



public void update() throws InterruptedException
{
	gu.getElementPageScroll(driver, 0, 4000);
	//Thread.sleep(3000);
	//add explicit wait in utitlty & call the funtion here
	wu.waitForElementTOBeClickables(driver, "//button[@name='Update']");
	gu.mediumDelay();
	gu.getElementClick(clickUpdate);
}
public String getAlertText()
{
	return gu.getElementText(alertText);
}

}
