package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SettingsManageMenu {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public SettingsManageMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement clickOnSettings;

	@FindBy(xpath = "//p[text()='Manage Menu']")
	WebElement clickOnManageMenu;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clickOnNew;

	@FindBy(xpath = "//input[@id='name']")
	WebElement menuName;

	@FindBy(xpath = "//select[@id='menu_id']")
	WebElement selectParentDropDown;

	@FindBy(xpath = "//input[@id='url']")
	WebElement Url;

	@FindBy(xpath = "//input[@id='icon']")
	WebElement FaIcon;

	@FindBy(xpath = "//input[@id='menu_table']")
	WebElement menuOrder;

	@FindBy(xpath = "//input[@id='menu_order']")
	WebElement tableName;

	@FindBy(xpath = "//input[@id='active_file']")
	WebElement fileName;

	@FindBy(xpath = "//input[@id='menu_color']")
	WebElement color;

	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	WebElement clickYes;

	@FindBy(xpath = "//button[@name='create']")
	WebElement clickSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickSettings() {
		gu.getElementPageScroll(driver, 0, 4000);
		gu.getElementClick(clickOnSettings);
	}

	public void clickManageMenu() {
		gu.getElementClick(clickOnManageMenu);
	}

	public void clickNew() {
		gu.getElementClick(clickOnNew);
	}

	public void menuName(String name) {

		gu.sendValues(name, menuName);
	}

	public void clickParentMenu() {
		gu.getDropDown(selectParentDropDown, 10);
	}

	public void enterUrl(String url) {

		gu.sendValues(url, Url);
	}

	public void enterFaIcon(String iconName) {

		gu.sendValues(iconName, FaIcon);
	}

	public void enterMenuOrder(String menu) {

		gu.sendValues(menu, menuOrder);
	}

	public void enterTableName(String name) {

		gu.sendValues(name, tableName);
	}

	public void enterFileName(String name) {

		gu.sendValues(name, fileName);
	}

	public void enterColor(String enterColor) {

		gu.sendValues(enterColor, color);
		gu.getElementPageScroll(driver, 0, 600);
	}

	public void clickYess() throws InterruptedException {

		gu.mediumDelay();

		gu.getElementClick(clickYes);
	}

	public void clickSave() {
		gu.getElementClick(clickSave);
	}

	public String getAlertMessage() {
		return gu.getElementText(alertMessage);
	}
}
