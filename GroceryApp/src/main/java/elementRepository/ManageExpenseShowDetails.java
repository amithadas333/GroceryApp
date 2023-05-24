package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpenseShowDetails {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageExpenseShowDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement ManageExpense;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement clickOnManageExpense;

	@FindBy(xpath = "//i[@class='fas fa-edit'][1]")
	WebElement clickOnNew;

	@FindBy(xpath = "//h1[text()='List Expense']")
	WebElement orderDetailsTitle;

	@FindBy(xpath = "//tr[@class='detail-row open']")
	WebElement attributeValue;

	@FindBy(xpath = "//h1[text()='Add Expense']")
	WebElement findTextAddExpensePage;

	@FindBy(xpath = " \"//input[@id='name']\")")
	WebElement add_title;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save_new_title;

	public void clickManageExpense() {
		gu.getElementClick(ManageExpense);
	}

	public void clickOnManageExpenseRadio() {
		gu.getElementClick(clickOnManageExpense);
	}

	public void addNewIteam() {

		add_title.sendKeys("sampledetails");
		gu.getElementClick(save_new_title);

	}

	public String getTextForAddExpensePage() {
		return gu.getElementText(findTextAddExpensePage);
	}

	public String show() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"IceCreams (232-ST)");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[8]//a[1]";
		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);

		String title = printAllRowValues1.getAttribute("title");
		return title;

		// System.out.println("titles is:" +title);

	}

	public WebElement getViewMoreelement() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"NewFruit001 (Admin-AD)");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td//div//a[1]";
		WebElement Findelement = driver.findElement(By.xpath(locator));

		return Findelement;
	}

	public boolean click_Sub_Manageexpense_ViewMore_button() throws InterruptedException {
		// gu.getElementPageScroll(driver, 0, 2000);

		getViewMoreelement().click();

		gu.mediumDelay();

		boolean value = false;
		if (attributeValue.getAttribute("class").contains("detail-row open")) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}

	public String getTitle() {
		return gu.getElementText(orderDetailsTitle);
	}

	public void clickOnNew() {
		gu.getElementClick(clickOnNew);
	}

}
