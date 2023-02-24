package com.sharp.atlassian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	
	WebDriver driver;
	
	public TrelloLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user")
	private WebElement usernameTextField;
	
	public WebElement usernameTextField() {
		return usernameTextField;
	}
	
	@FindBy(id = "login")
	private WebElement continueButton;
	
	public WebElement continueButton() {
		return continueButton;
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
	
	@FindBy(linkText = "Terms of Service")
	private WebElement termsOfServiceLinkText;

	public WebElement termsOfServiceLinkText() {
		return termsOfServiceLinkText;
	}
	
	@FindBy(id = "language-picker")
	private WebElement langaugePickerDropDown;
	
	public WebElement langaugePickerDropDown() {
		return langaugePickerDropDown;
	}
	
	@FindBy(linkText = "Templates")
	private WebElement templatesLinkText;

	public WebElement templatesLinkText() {
		return templatesLinkText;
	}
	
	@FindBy(linkText = "Pricing")
	private WebElement pricingLinkText;

	public WebElement pricingLinkText() {
		return pricingLinkText;
	}
	
	@FindBy(linkText = "Apps")
	private WebElement appsLinkText;

	public WebElement appsLinkText() {
		return pricingLinkText;
	}
	
	@FindBy(linkText = "Jobs")
	private WebElement jobsLinkText;

	public WebElement jobsLinkText() {
		return jobsLinkText;
	}
	
	@FindBy(linkText = "Blog")
	private WebElement blogLinkText;

	public WebElement blogLinkText() {
		return blogLinkText;
	}
	
	@FindBy(linkText = "Developers")
	private WebElement developersLinkText;

	public WebElement developersLinkText() {
		return developersLinkText;
	}
	
	@FindBy(linkText = "Help")
	private WebElement helpLinkText;

	public WebElement helpLinkText() {
		return helpLinkText;
	}
	
	@FindBy(linkText = "Cookie Settings")
	private WebElement cookieSettingsLinkText;

	public WebElement cookieSettingsLinkText() {
		return cookieSettingsLinkText;
	}
	
	
	
	
}
