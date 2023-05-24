package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpenseCategoryDynamicTable {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ExpenseCategoryDynamicTable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement clickManageExpense;

	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement clickExpenseCategory;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement expense_Category_NewButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement add_title;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save_new_title;

	@FindBy(xpath = "//input[@id='name']")
	WebElement changeEditExpenseCategoryInformations;

	@FindBy(xpath = "//button[@name='Update']")
	WebElement clickUpdate;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickOnclickManageExpense() {
		gu.getElementClick(clickManageExpense);
	}

	public void clickOnExpenseCategory() {
		gu.getElementClick(clickExpenseCategory);
	}

	public void getFirstFiveTabelDetails() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"mysample0.7373156785686894");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[2]//a[1]";
		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);

	}

	public void editExpenseCategoryInformations() {
		gu.getClear(changeEditExpenseCategoryInformations);

	}

	public void editExpenseCategoryInformation(String changeTitle) {

		gu.sendValues(changeTitle, changeEditExpenseCategoryInformations);
	}

	public void newDetails() {
		gu.getElementClick(expense_Category_NewButton);
		add_title.sendKeys("mysample" + Math.random() + "");
		gu.getElementClick(save_new_title);

	}

	public void clickOnUpdate() {
		gu.getElementClick(clickUpdate);
	}

	public String getAlertText() {
		return gu.getElementText(alertMessage);
	}

}
