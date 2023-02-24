package com.sharp.atlassian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {
	
	WebDriver driver;
	
	public TrelloLoginToContinuePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "css-18sagaz")
	private WebElement disabledUsernameTextField;
	
	public WebElement disabledUsernameTextField() {
		return disabledUsernameTextField;
	}
	
	@FindBy (id = "password")
	private WebElement passwordTextField;
	
	public WebElement passwordTextField() {
		return passwordTextField;
	}
	
	@FindBy(id = "login-submit")
	private WebElement loginButton;
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	@FindBy(css = "span[role='presentation']")
	private WebElement flutteredButton;
	
	public WebElement flutteredButton() {
		return flutteredButton;
	}
	
	@FindBy(xpath = "//span[text()='Continue with Google']")
	private WebElement continueWithGoogleLink;
	
	public WebElement continueWithGoogleLink() {
		return continueWithGoogleLink;
	}
	
	@FindBy(xpath = "//span[text()='Continue with Microsoft']")
	private WebElement continueWithMicrosoftLink;
	
	public WebElement continueWithMicrosoftLink() {
		return continueWithMicrosoftLink;
	}
	
	@FindBy(xpath = "//span[text()='Continue with Apple']")
	private WebElement continueWithAppleLink;
	
	public WebElement continueWithAppleLink() {
		return continueWithAppleLink;
	}

	@FindBy(xpath = "//span[text()='Continue with Slack']")
	private WebElement continueWithSlackLink;
	
	public WebElement continueWithSlackLink() {
		return continueWithSlackLink;
	}
	
	@FindBy(linkText = "Log in with SSO")
	private WebElement loginWithSSQLink;

	public WebElement loginWithSSQLink() {
		return loginWithSSQLink;
	}
	
	@FindBy(linkText = "Can't log in?")
	private WebElement CantLoginLinkText;

	public WebElement CantLoginLinkText() {
		return CantLoginLinkText;
	}
	
	@FindBy(linkText = "Sign up for an account")
	private WebElement signUpForAnAccountLinkText;

	public WebElement signUpForAnAccountLinkText() {
		return signUpForAnAccountLinkText;
	}
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicyLinkText;

	public WebElement privacyPolicyLinkText() {
		return privacyPolicyLinkText;
	}
	
	@FindBy(xpath = "//span[text()='User Notice']")
	private WebElement userNoticeLinkText;

	public WebElement userNoticeLinkText() {
		return userNoticeLinkText;
	}
	
	
	@FindBy(id = "atlassian-account-link-more-short")
	private WebElement moreLinkText;

	public WebElement moreLinkText() {
		return moreLinkText;
	}
	
	
}
