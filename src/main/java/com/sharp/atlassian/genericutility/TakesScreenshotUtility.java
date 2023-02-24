package com.sharp.atlassian.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenshotUtility {
   public WebDriver driver;
	public TakesScreenshotUtility(WebDriver driver) {
    this.driver=driver;
}
	public WebDriver failed(String methodName, WebDriver driver) throws Throwable {
		TakesScreenshot tss= (TakesScreenshot) driver;
		File srcFile=tss.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./errorshots/methodName"+LocalDateTime.now().toString().replace(":", "-")+".png");
		FileUtils.copyFile(srcFile, destFile);
		return driver;
		
	}
	
	

}
