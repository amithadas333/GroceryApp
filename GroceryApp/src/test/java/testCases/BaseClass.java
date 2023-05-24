package testCases;

import org.testng.annotations.Test;

import utilities.ScreenShotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenShotUtility sc;

	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBasic();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

	}

//	@BeforeMethod(alwaysRun = true)
//	@Parameters("Browser")
//	public void beforeMethod(String browser) throws IOException {
//		if (browser.equals("chrome")) {
//			testBasic();
//			ChromeOptions ops = new ChromeOptions();
//			ops.addArguments("--remote-allow-origins=*");
//			driver = new ChromeDriver(ops);
//		} else if (browser.equals("edge")) {
//			EdgeOptions ops = new EdgeOptions();
//			ops.addArguments("--remote-allow-origins=*");
//			driver = new EdgeDriver(ops);
//
//			// driver = new EdgeDriver();
//		}
//		driver.get(prop.getProperty("BaseURL"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		//driver.close();
	}

//	// @AfterMethod
//	// public void afterMethod(ITestResult itestResult) throws IOException {
//	// if (itestResult.getStatus() == ITestResult.FAILURE) {
//	// sc = new ScreenShotUtility();
//	// sc.captureScreenShotFailure(driver, itestResult.getName());// capture
//	// screenshot
//	// }
//
//	// driver.close();

}
