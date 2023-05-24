package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManagePaymentMethods {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManagePaymentMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-credit-card']")
	WebElement clickManagePaymentMethods;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement inActiveStatusMessage;

	public void clickOnManagePaymentMethods() {
		gu.getElementClick(clickManagePaymentMethods);
	}

	public void changeStatus() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Emirates NBD");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[3]//a[1]";

		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);
	}

	public String alertText() {
		return gu.getElementText(inActiveStatusMessage);
	}

}
