package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-map-marker']")
	WebElement clickOnManageLocation;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement afterDeletealertMessageText;

	public void clickManageLocation() {
		gu.getElementClick(clickOnManageLocation);

	}

	public String clickOnDelete() {

		int rowValue = gu.clickdynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Port Charlynfurt");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[6]//a[2]";
		WebElement printAllRowValues1 = driver.findElement(By.xpath(locator));
		gu.getElementClick(printAllRowValues1);
		gu.acceptAlert(driver);
		return gu.getElementText(afterDeletealertMessageText);

	}

}
