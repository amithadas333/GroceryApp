package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageSlider {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Slider']")
	WebElement clickOnManageSlider;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickOnNew;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement enterLink;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement clickOnSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void selectMobileSlider() {
		clickOnManageSlider.click();
	}

	public void selectNewButton()

	{
		gu.getElementClick(clickOnNew);

	}

	public void clickOnChooseFile() throws AWTException, InterruptedException {

	gu.getFileUpload(driver, chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\FileUpload\\istockphoto.jpg");
	gu.mediumDelay();
	
	}

	public void enterLink(String link) {
		enterLink.sendKeys(link);
	}

	public String clickOnSend() {
		gu.getElementClick(clickOnSave);

		return gu.getElementText(alertMessage);
	}
	
	
	

}
