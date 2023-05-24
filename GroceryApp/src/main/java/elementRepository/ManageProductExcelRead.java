package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProductExcelRead {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	WaitUtility wu = new WaitUtility();

	public ManageProductExcelRead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement clickManageProduct;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickNew;
	@FindBy(xpath = "//input[@id='title']")
	WebElement addTitle;

	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	WebElement selectVegRadio;
	@FindBy(xpath = "//input[@id='tag']")
	WebElement tag;

	@FindBy(xpath = "//select[@id='grp_id']")
	WebElement selectGroup;
	@FindBy(xpath = "//input[@id='purpose']")
	WebElement weight;

	@FindBy(xpath = "//input[@id='m_weight']")
	WebElement weightValue;

	@FindBy(xpath = "//select[@id='w_unit']")
	WebElement weightUnit;

	@FindBy(xpath = "//input[@id='max_weight']")
	WebElement maximumQuantity;

	@FindBy(xpath = "//input[@id='w_price']")
	WebElement price;

	@FindBy(xpath = "//input[@id='w_mrp']")
	WebElement MRP;

	@FindBy(xpath = "//input[@id=\"w_stock\"]")
	WebElement stockAvailability;

	@FindBy(xpath = "//input[@id='w_pp']")
	WebElement purchaseAmount;

	@FindBy(xpath = "//input[@name='unlimitw[]']")
	WebElement clickUnlimitedStock;

	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement addDescription;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseeFile;

	@FindBy(xpath = "//input[@id='main_imgs']")
	WebElement chooseNextFile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSave;

	@FindBy(xpath = "//li[text()='The Category field is required.']")
	WebElement categoryAlertMessage;

	@FindBy(xpath = "//li[text()='The Sub Category field is required.']")
	WebElement subCategoryAlertMessage;
	
@FindBy(xpath = "//h5[text()=' Alert!']")
WebElement alertMessage;

	public void manageProduct() {
		gu.getElementClick(clickManageProduct);

		clickManageProduct.click();
	}

	public String resetButtonColor() {
		return gu.getElementStyleProperty(clickManageProduct, "background-color");
	}

	public void clickOnNew() {
		gu.getElementClick(clickNew);
	}

	public void selectveg() {
		gu.getElementClick(selectVegRadio);
	}

	public void groups() {
		gu.getDropDown(selectGroup, 1);
	}

	public void weightUnitEnter() {
		gu.getDropDown(weightUnit, 2);
	}

	public void priceType() {
		gu.getElementClick(weight);
		gu.getElementPageScroll(driver, 0, 1000);
	}

	public void productAllInformations(String titleName, String enterTagName, String enterWeightValue,
			String enterQuantity, String enterPrice, String enterMRP, String enterStockkg, String pricePurchase,
			String enterDescription) {
		addTitle.sendKeys(titleName);
		tag.sendKeys(enterTagName);
		weightValue.sendKeys(enterWeightValue);

		maximumQuantity.sendKeys(enterQuantity);
		price.sendKeys(enterPrice);
		MRP.sendKeys(enterMRP);
		stockAvailability.sendKeys(enterStockkg);
		purchaseAmount.sendKeys(pricePurchase);
		addDescription.sendKeys(enterDescription);
		gu.getElementPageScroll(driver, 0, 8000);

	}

	public void chooseFiles() throws AWTException, InterruptedException {

		gu.mediumDelay();
		gu.getFileUpload(driver, chooseeFile,
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\photos.jpg");

	}

	//public void chooseNextImage(String path) throws AWTException, InterruptedException {
		
		
		public void chooseNextImage() throws AWTException, InterruptedException {
		gu.mediumDelay();
		//gu.getFileUpload(driver, chooseNextFile,"System.getProperty('user.dir')"+path
				//);
				gu.getFileUpload(driver, chooseNextFile,
						System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\photos.jpg");
	
	}

	public void clickSaveButton() throws InterruptedException {

		gu.getElementPageScroll(driver, 0, 1000);
		gu.mediumDelay();
		gu.getElementClick(clickSave);

	}

//	public String getAlertMessage() {
//		return gu.getElementText(categoryAlertMessage);
//
//	}
//
//	public String getSecondAlertMessage() {
//		return gu.getElementText(subCategoryAlertMessage);
//
//	}
	public String AlertMessage() {
		return gu.getElementText(alertMessage);

	}

}
