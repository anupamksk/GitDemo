package com.sharp.atlassian.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileUtils = new FileUtility();
	public ExcelUtility excelUtils = new ExcelUtility();
	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	public WebElementUtility webElementUtils = new WebElementUtility();
	public JavaUtility javaUtils = new JavaUtility();
	public TakesScreenshotUtility tssUtils=new TakesScreenshotUtility(driver);
	
	@BeforeMethod
	public void configBeforeMethod() throws IOException {
		String browser = fileUtils.readCommondata("browser");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = fileUtils.readCommondata("url");
		driver.get(url);
	}
	
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}

}
