package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageCategory {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-list-alt']")
	WebElement clickManageCategory;

	@FindBy(xpath = "//p[text()='Category']")
	WebElement clickCategory;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNew;

	@FindBy(xpath = "//input[@id='category']")
	WebElement enterCategory;

	@FindBy(xpath = "//span[text()='discount'][1]")
	WebElement selectGroup;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//label[@class='radio-inline'][2]")
	WebElement clickNoTopMenu;

	@FindBy(xpath = "//div[@class='col-md-4'][2]//label[@class='radio-inline'][2]")
	WebElement clickOnLeftMenu;

	@FindBy(xpath = "//button[@name='create']")
	WebElement clickSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickOnManageCategory() {
		gu.getElementClick(clickManageCategory);
	}

	public void clickOnCategory() {
		gu.getElementClick(clickCategory);
	}

	public void clickOnNew() {
		gu.getElementClick(clickNew);
	}

	public void enterTheCategory(String Category) {

		gu.sendValues(Category, enterCategory);
	}

	public void clickOnGroup() throws InterruptedException {
		gu.mediumDelay();
		gu.getElementClick(selectGroup);
		gu.getElementPageScroll(driver, 0, 2000);
		// gu.doubleClick(driver, selectGroup);
	}

	public void chooseFile() {

		try {
			gu.mediumDelay();
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		try {
			gu.getFileUpload(driver, chooseFile,
					System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\photos.jpg");
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void clickOnNoTopMenu() {
		gu.getElementClick(clickNoTopMenu);
	}

	public void clickOnLeftMenu() {
		gu.getElementClick(clickOnLeftMenu);
	}

	public void clikOnSave() {
		gu.getElementClick(clickSave);
	}

	public String checkAlertMessage() {
		return gu.getElementText(alertMessage);
	}
}
