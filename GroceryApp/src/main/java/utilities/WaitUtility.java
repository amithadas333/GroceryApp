package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	// add all explicit wait

	public void waitForElementTOBeClickable(WebDriver driver, String element) {

		WebDriverWait waitForNextPage = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitForNextPage.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		//waitForNextPage.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));

	}
	
	public void waitForElementTOBeClickables(WebDriver driver,String type)
	{
		WebDriverWait waitForNextPage = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitForNextPage.until(ExpectedConditions.elementToBeClickable(By.xpath(type)));
		
	}
	
	
	public void waitForElementTOBeClickabless(WebDriver driver,String type)
	{
		WebDriverWait waitForNextPage = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitForNextPage.until(ExpectedConditions.elementToBeSelected(By.xpath(type)));
		
	}
	
	

}
