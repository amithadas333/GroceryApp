package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpenseInputAllDetails {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageExpenseInputAllDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement clickManageExpense;

	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement clickSubManageExpense;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickOnNew;

	@FindBy(xpath = "//select[@id='user_id']")
	WebElement selectUserDropDown;

	@FindBy(xpath = "//input[@id='ex_date']")
	WebElement selectDate;

	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement selectCategory;

	@FindBy(xpath = "//select[@id='order_id']")
	WebElement selectOrderId;

	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement selectPurchaseId;

	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement selectExpenseType;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement enterAmount;

	@FindBy(xpath = "//textarea[@id='content']")
	WebElement enterRemark;

	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickManageExpense() {
		gu.getElementClick(clickManageExpense);
	}

	public void clickSubManageExpense() {
		gu.getElementClick(clickSubManageExpense);
	}

	public void clickOnNew() {
		gu.getElementClick(clickOnNew);
	}

	public void clickOnNext() {
		gu.getElementClick(selectDate);
	}

	public void selectDate(String date) throws InterruptedException {
		selectDate.clear();
		
		selectDate.sendKeys(date);
		selectDate.sendKeys(Keys.TAB);

	}

	public void clickOnUserDropDown() {
		gu.getDropDown(selectUserDropDown, 4);
	}

	public void clickOnselectDate(String date) {

		selectDate.sendKeys(date);
		selectDate.sendKeys(Keys.ENTER);
	}

	public void clickOnCategory() {
		gu.getDropDown(selectCategory, 6);
	}

	public void clickOnOrderId() {
		gu.getDropDown(selectOrderId, 2);
	}

	public void clickOnPurchaseId() {
		gu.getDropDown(selectPurchaseId, 2);
	}

	public void clickOnExpenseType() {
		gu.getDropDown(selectExpenseType, 4);
	}

	public void enterAmount(String amount) {
		enterAmount.sendKeys(amount);
	}

	public void enterRemarks(String remark)

	{
		enterRemark.sendKeys(remark);
		gu.getElementPageScroll(driver, 0, 2000);
	}

	public void chooseFiles() {
		try {
			gu.mediumDelay();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			gu.getFileUpload(driver, chooseFile,
					System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\istockphoto.jpg");
			
		} catch (AWTException e) {

			e.printStackTrace();
		}

	}

	public void clickOnSave() {
		gu.getElementClick(clickSave);
	}

	public String checkAlertMessage() {
		return gu.getElementText(alertMessage);
	}
}
