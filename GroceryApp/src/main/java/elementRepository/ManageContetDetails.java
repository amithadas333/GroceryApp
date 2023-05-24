package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageContetDetails {

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	WebDriver driver;

	public ManageContetDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement clickManageContetDetails;
	@FindBy(xpath = "//p[text()='Manage Pages']")
	WebElement clickManagePages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNew;
	@FindBy(xpath = "//input[@id='title']")
	WebElement enterTitle;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement enterDescription;

	@FindBy(xpath = "//i[@class='note-icon-bold']")
	WebElement selectBold;
	@FindBy(xpath = "//input[@name='page']")
	WebElement enterpage;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickOnManageContetDetails() {
		gu.getElementClick(clickManageContetDetails);
	}

	public void clickOnManagePages() {
		gu.getElementClick(clickManagePages);
	}

	public void clickNew() {
		gu.getElementClick(clickNew);
	}

	public void enterTitle(String title) {
		enterTitle.sendKeys(title);
		
	}

	public void description(String descriptions) {
		enterDescription.sendKeys(descriptions);
		gu.doubleClick(driver, enterDescription);
		gu.getElementClick(selectBold);

	}

	public void page(String pageName) throws AWTException {
		gu.getElementPageScroll(driver, 0, 2000);
		enterpage.sendKeys(pageName);

	}

	public void fileUpload() throws AWTException, InterruptedException {

		gu.getFileUpload(driver, chooseFile,
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\istockphoto.jpg");
		gu.mediumDelay();

		

	}
	
	public void clickSubmitButton() throws InterruptedException {
		wu.waitForElementTOBeClickables(driver, "//button[@type='submit']");
		gu.getElementClick(save);
		//gu.mediumDelay();
		
		
	}

//	public void saveDetails() {
//		gu.getElementClick(save);
//	}

	public String getAlertMessageText() {
		return gu.getElementText(alertMessage);
	}
}
