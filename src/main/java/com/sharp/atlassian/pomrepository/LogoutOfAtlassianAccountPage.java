package com.sharp.atlassian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutOfAtlassianAccountPage {

WebDriver driver;
	
	public LogoutOfAtlassianAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id	 = "logout-submit")
	private WebElement logoutButton;
	
	public WebElement logoutButton() {
		return logoutButton;
	}
	
	@FindBy (xpath = "//span[text()='Log in to another account']")
	private WebElement logInToAnotherAccountLinkText;
	
	public WebElement logInToAnotherAccountLinkText() {
		return logInToAnotherAccountLinkText;
	}

	@FindBy (xpath = "//span[text()='Privacy Policy']")
	private WebElement privacyPolicyLinkText;
	
	public WebElement privacyPolicyLinkText() {
		return privacyPolicyLinkText;
	}
	
	@FindBy (xpath = "//span[text()='User Notice']")
	private WebElement userNoticeLinkText;
	
	public WebElement userNoticeLinkText() {
		return userNoticeLinkText;
	}
	
}
