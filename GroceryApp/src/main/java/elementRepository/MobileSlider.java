package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class MobileSlider {

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	WebDriver driver;

	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-minimize']")
	WebElement clickMobileSlider;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNew;

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement clickDropDown;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement clickChooseFile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickOnSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertText;
	
	
	

	public void clickOnMobileSlider() {
		gu.getElementClick(clickMobileSlider);
	}

	public void clickOnNew() {
		gu.getElementClick(clickNew);
	}

	public void selectDropDown() {

		gu.getDropDown(clickDropDown, 3);
	}

	public void clickChooseFile() throws AWTException {
		// gu.getElementClick(clickChooseFile);
		gu.getFileUpload(driver, clickChooseFile,
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\istockphoto.jpg");

	}

	public void clickSubmitButton() {
		wu.waitForElementTOBeClickables(driver, "//button[@type='submit']");
		gu.getElementClick(clickOnSave);

	}

	public String alertText() {
		return gu.getElementText(alertText);
	}

}
