package elementRepository;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class HomePageSettings {
	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public HomePageSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement clickOnSettings;

	@FindBy(linkText = "Change Password")
	WebElement changePassword;

	@FindBy(xpath = "//input[@name='old_pwd']")
	WebElement enterOldPassword;

	@FindBy(xpath = "//input[@name='new_pwd']")
	WebElement enterNewPassword;

	@FindBy(xpath = "//input[@name='conf_password']")
	WebElement enterconfirmPassword;

	@FindBy(xpath = "//button[@type='reset']")
	WebElement clickCancelButton;

	@FindBy(xpath = "//h3[text()='Enter Password Informations']")
	WebElement homePageChangePasswordPageText;

	@FindBy(xpath = "//li[text()='Reset Password']")
	WebElement homePageRestPasswordText;

	public void pageScrollDown() {
		gu.getElementPageScroll(driver, 0, 8000);

	}

	public void clickOnSettings() {
		gu.getElementClick(clickOnSettings);
	}

	public void clickOnChangePassword() {
		gu.getElementClick(changePassword);
	}

	public String newPasswordPageText() {
		return gu.getElementText(homePageChangePasswordPageText);
	}

	public String newPasswordRestText() {
		return gu.getElementText(homePageRestPasswordText);
	}

	public void userName(String oldName) {
		enterOldPassword.sendKeys(oldName);
	}

	public void userNewPassword(String newName) {
		enterNewPassword.sendKeys(newName);
	}

	public String confirmPasswordReEnter(String confirmNePassword) {
		enterconfirmPassword.sendKeys(confirmNePassword);
		return gu.getElementText(changePassword);
	}

	public void clickOnCancel() {
		gu.getElementClick(clickCancelButton);
	}

}
