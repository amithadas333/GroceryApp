package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	/// general resuable methods

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getElementStyleProperty(WebElement element, String propertyType) {
		String value = element.getCssValue(propertyType);
		return value;
	}

	public void getElementPageScroll(WebDriver driver, int valuehorizonatl, int scrollValueVertical) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + valuehorizonatl + "," + scrollValueVertical + ")", "");
		// js.executeScript("window.scrollBy(0,8000)", "");

	}

	public void getElementClick(WebElement element) {
		element.click();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void getDropDown(WebElement element, int a) {
		Select obj = new Select(element);
		obj.selectByIndex(a);

	}

	public void getClear(WebElement element) {
		element.clear();
	}

	public int clickdynamicTable(WebDriver driver, String columnValue, String compareName) {
		List<WebElement> firstColumnElement = driver.findElements(By.xpath(columnValue));
		int value = 0;
		for (int i = 0; i < firstColumnElement.size(); i++) {
			if (firstColumnElement.get(i).getText().equals(compareName)) {
				value = i + 1;// (tr[i+1])
				break;
			}
		}
		return value;

	}

//	public void getFileUpload(WebDriver driver, WebElement value, String type) throws AWTException {
//		Robot robot = new Robot();
//		Actions action = new Actions(driver);
//		action.moveToElement(value).click().perform();// toutilty
//		StringSelection ss = new StringSelection((type));
//
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		robot.delay(250);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.delay(250);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.delay(250);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//	}

	
	public void getFileUpload(WebDriver driver, WebElement value, String type) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);
		action.moveToElement(value).click().perform();// toutilty
		StringSelection ss = new StringSelection((type));

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions obj = new Actions(driver);
		obj.doubleClick(element).perform();
	}

	public void backOn(WebDriver driver,WebElement element)
	{
		driver.navigate().back();
	}
	
	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public void randomNumber()
	{
		Math.random();
	}
	
	public void mouseHover(WebDriver driver,WebElement click)
	{
		Actions obj=new Actions(driver);
//		obj.contextClick().perform();
//		obj.moveToElement(click).perform();
		//obj.sendKeys(Keys.ARROW_DOWN).perform();
		obj.moveToElement(click).perform();
		
	}
}
