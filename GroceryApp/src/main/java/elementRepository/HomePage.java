package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	
	GeneralUtilities gu=new GeneralUtilities();

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}
	
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement element2;
	
	public String getELementttTextOfXXXButton() {
		return gu.getElementText(element2);
	}

}
