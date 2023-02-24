package com.sharp.atlassian.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * WebDriverUtility can be used get the WebDriver related waits and control transfers
 * @author Anupam K.
 *
 */
public class WebDriverUtility {
	/**
	 * This method will give the sync time to the @FindBy and @FindBys 
	 * @param driver
	 */
	public Boolean explicitWaitForTitles(WebDriver driver, String completeTitle ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Boolean ref = wait.until(ExpectedConditions.titleIs(completeTitle));
		return ref;
	}
	/**
	 * This method will give the sync time to load the complete Url
	 * @param driver
	 * @param completeUrl
	 * @author Anupam K.
	 * @return Boolean 
	 */
	public Boolean explicitwaitForCompleteUrl(WebDriver driver, String completeUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.urlToBe(completeUrl));
	}
	/**
	 * This method will give the sync time to load the Url 
	 * @param driver
	 * @param urlContains
	 * @return Boolean
	 */
	public Boolean explicitwaitForUrlcontains(WebDriver driver, String urlContains) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.urlContains(urlContains));
	}
	public void explicitwaitForElement(WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
	}
	/**
	 * This Method will supply the explicit wait to the denoted action to complete the task
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	/**
	 * This method will change the driver control from the current frame to the another frame by frame index number 
	 * @param driver
	 * @param index
	 */
	public void frameAsIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will change the driver control from the current frame to the another frame by name or id attribute value
	 * @param driver
	 * @param nameOrId
	 */
	public void frameAsIdorName(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will change the driver control from the current frame to the another frame by frame element reference
	 * @param driver
	 * @param eleRef
	 */
	public void frameAsWebElement(WebDriver driver,WebElement eleRef) {
		driver.switchTo().frame(eleRef);
	}

}
