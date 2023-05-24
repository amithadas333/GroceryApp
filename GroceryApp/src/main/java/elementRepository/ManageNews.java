package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNews {

	GeneralUtilities gu = new GeneralUtilities();

	WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement clickManageContent;

	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement clickManageNews;

	@FindBy(xpath = "//i[@class='fas fa-edit'][1]")
	WebElement clickNew;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickSave;

	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alertMessage;

	public void clickOnManageContent() {
		gu.getElementClick(clickManageContent);
	}

	public void clickOnManageNews() {
		gu.getElementClick(clickManageNews);
	}

	public void clickOnNew() {
		gu.getElementClick(clickNew);
	}

	public void enterNews(String news)

	{
		enterNews.sendKeys(news);
	}

	public void clickOnSave() {
		gu.getElementClick(clickSave);
	}

	public String checkAlertMessage() {
		return gu.getElementText(alertMessage);
	}

}
