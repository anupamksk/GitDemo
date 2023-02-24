package com.sharp.atlassian.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This Method will supply the explicit wait to the denoted action to complete the task 
 * @author Anupam K.
 *
 */
public class WebElementUtility {
	/**
	 * This method will wait till 5 seconds to load and perform click action
	 * @param driver
	 * @param elementRef
	 * @author Anupam K. 
	 */
	public void clickOnVisibleElement (WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
			elementRef.click();
	}
	/**
	 * This method will wait till 5 seconds to load and perform submit action
	 * @param driver
	 * @param elementRef
	 * @author Anupam K.
	 */
	public void submitOnVisibleElement (WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
		elementRef.submit();
	}
	/**
	 * This method will wait till 5 seconds to load and send the text
	 * @param driver
	 * @param elementRef
	 * @param text
	 * @author Anupam K.
	 */
	public void sendkeysOnVisibleTextField (WebDriver driver, WebElement elementRef, CharSequence text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
		elementRef.clear();
		elementRef.sendKeys(text);
	}
	/**
	 * This method will wait till 5 seconds to load and it will clear the field
	 * @param driver
	 * @param elementRef
	 * @author Anupam K.
	 */
	public void clearTheVisibleTextField (WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
		elementRef.clear();
	}
	/**
	 * 
	 * @param driver
	 * @param elementRef
	 * @return main or subTagContainingText
	 * @author Anupam K.
	 */
	public String getTagtexOfElement (WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
		return elementRef.getText();
	}
	/**
	 * This Method will wait for 5 second and confirms the visibility of the element
	 * @param driver
	 * @param elementRef
	 * @return
	 * @author Anupam K.
	 */
	public boolean displayOfElement(WebDriver driver, WebElement elementRef) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elementRef));
		return elementRef.isDisplayed();
	}
	
}
