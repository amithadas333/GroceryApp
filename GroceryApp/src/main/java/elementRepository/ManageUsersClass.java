package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUsersClass {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageUsersClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement clickOnManageUsers;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertText;

	public void manageUserPageClick() {
		clickOnManageUsers.click();
	}

	public void changeInactiveToActive() {
		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Bessy Mol");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[6]//a[1]";

		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);
	}

	public String alertText() {
		return gu.getElementText(alertText);
	}

}
