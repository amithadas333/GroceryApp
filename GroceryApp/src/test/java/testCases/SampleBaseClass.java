package testCases;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SampleBaseClass 
{
	
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() 
  {
  
 
  WebDriver driver = new ChromeDriver();
  this.driver = driver;
  
  driver.get("https://www.linkedin.com/feed/");
  driver.manage().window().maximize();
  
  
  }

  @AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
