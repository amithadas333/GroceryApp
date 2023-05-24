package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageOfferCode {

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	WebDriver driver;

	public ManageOfferCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-cubes']")
	WebElement clickOnManageOfferCode;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/'][1]")
	WebElement clickOnManageGiftCardsAndVouchers;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement clickOnManageOrders;

	@FindBy(xpath = "//a[@class='btn btn-warning btn-sm'][1]")
	WebElement clickOnAssignDeliveryBoy;

	@FindBy(xpath = "//select[@id='delivery_boy_id'][1]")
	WebElement clickOnDropDown;

	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/assign_deliveryboy'])[1]//button[@class='btn btn-info']")
	WebElement update;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	@FindBy(xpath = "//a[text()='Change Delivery Date'][1]")
	WebElement clickOnChangeDeliveryDate;

	@FindBy(xpath = "//input[@name='del_up_date'][1]")
	WebElement clickOnDeliveryDate;

	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//input[@class='time1 time ui-timepicker-input']")
	WebElement clickTime;

	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//input[@id='basicExample1']")
	WebElement clickTimeBetween;

	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//button[@name='Update_st']")

	WebElement update1;

	public void clickManageOfferCode() {
		gu.getElementPageScroll(driver, 0, 2000);
		gu.getElementClick(clickOnManageOfferCode);
	}

	public void clickManageGiftCardsAndVouchers() {
		gu.getElementClick(clickOnManageGiftCardsAndVouchers);
		gu.getElementPageScroll(driver, 0, 1000);
	}

	public void clickManageOrders() {
		gu.getElementClick(clickOnManageOrders);
	}

	public void clickAssignDeliveryBoy() {
		gu.getElementClick(clickOnAssignDeliveryBoy);
	}

	public void clickDropDown() {
		gu.getDropDown(clickOnDropDown, 3);
	}

	public void clickOnUpdate() throws InterruptedException {

		// wu.waitForElementTOBeClickable(driver, "//button[@type='submit']");
		gu.mediumDelay();
		gu.getElementClick(update);

	}

	public String checkAlertMessage() {
		return gu.getElementText(alertMessage);
	}

//	public void clickChangeDeliveryDate() {
//		gu.getElementClick(clickOnChangeDeliveryDate);
//	}

	public void clickChangeDeliveryDate() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "704");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[6]//a[2]";
		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);
		// gu.getElementClick(clickOnChangeDeliveryDate);

	}

	public void clickDeliveryDate(String date) {

		clickOnDeliveryDate.sendKeys(date);

	}

	public void clickOnTime(String timeStarts) {

		clickTime.clear();

		clickTime.sendKeys(timeStarts);

	}

	public void clickOnTimeBetween(String ends) {

		clickTimeBetween.clear();

		clickTimeBetween.sendKeys(ends);

	}

	public void updateon() {
		gu.getElementClick(update1);
	}

}
