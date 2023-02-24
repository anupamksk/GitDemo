package com.sharp.atlassian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	WebDriver driver;

	public TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log in' and not(@tabindex)]")
	private WebElement loginLinkText;

	public WebElement loginLinkText() {
		return loginLinkText;
	}

	@FindBy(xpath = "//div[starts-with(@class,'BigNavstyles')]//a[@data-testid='logo_link']")
	private WebElement trelloLogoLink;

	public WebElement trelloLogoLink() {
		return trelloLogoLink;
	}

	@FindBy(xpath = "//button[text()='Features' and not(@tabindex)]")
	private WebElement featuresButton;

	public WebElement featuresButton() {
		return featuresButton;
	}

	@FindBy(xpath = "//button[text()='Solutions' and not(@tabindex)]")
	private WebElement solutionsButton;

	public WebElement solutionsButton() {
		return solutionsButton;
	}
	
	@FindBy(xpath = "//button[text()='Plans' and not(@tabindex)]")
	private WebElement plansButton;

	public WebElement plansButton() {
		return plansButton;
	}
	
	@FindBy(xpath = "//div[starts-with(@class,'Tabsstyles')]//a[text()='Pricing']")
	private WebElement pricingButton;

	public WebElement pricingButton() {
		return pricingButton;
	}
	
	@FindBy(xpath = "//button[text()='Resources' and not(@tabindex)]")
	private WebElement resourcesButton;

	public WebElement resourcesButton() {
		return resourcesButton;
	}
	
	@FindBy (xpath = "//div[starts-with(@class,'Buttonsstyles')]//a[text()='Get Trello for free']")
	private WebElement getTrelloForFreeLink;

	public WebElement getTrelloForFreeLink() {
		return getTrelloForFreeLink;
	}
	
	@FindBy (xpath = "//div[contains(@class,'grid__StyledColumn-sc-p40pqe-2 TqrJz')]//input[@name='email']")
	private WebElement emailTextField;
	
	public WebElement emailTextField() {
		return emailTextField;
	}
	
	@FindBy(xpath = "//div[contains(@class,'grid__StyledColumn-sc-p40pqe-2 TqrJz')]//button[text()='Sign up - it’s free!']")
	private WebElement signUpItsFreeButton;

	public WebElement signUpItsFreeButton() {
		return signUpItsFreeButton;
	}
	
	@FindBy(xpath = "//span[text()='Watch video']")
	private WebElement watchVideoLinkText;

	public WebElement watchVideoLinkText() {
		return watchVideoLinkText;
	}
	
	@FindBy(linkText = "guide for getting started")
	private WebElement guideForGettingStarted;

	public WebElement guideForGettingStarted() {
		return guideForGettingStarted;
	}
	
	@FindBy(xpath = "//h3[text()='Project management']")
	private WebElement projectManagementPageLink;

	public WebElement projectManagementPageLink() {
		return projectManagementPageLink;
	}
	
	@FindBy(xpath = "//h3[text()='Brainstorming']")
	private WebElement brainstormingPageLink;

	public WebElement brainstormingPageLink() {
		return brainstormingPageLink;
	}
	
	@FindBy(xpath = "//h3[text()='Meetings']")
	private WebElement meetingsPageLink;

	public WebElement meetingsPageLink() {
		return meetingsPageLink;
	}
	
	@FindBy(xpath = "//h3[text()='Task management']")
	private WebElement taskManagementPageLink;

	public WebElement taskManagementPageLink() {
		return taskManagementPageLink;
	}
	
	@FindBy(xpath = "//h3[text()='CRM']")
	private WebElement CRMPageLink;

	public WebElement CRMPageLink() {
		return CRMPageLink;
	}
	
	@FindBy(xpath = "//h3[text()='Editorial calendar']")
	private WebElement editorialCalendarPageLink;

	public WebElement editorialCalendarPageLink() {
		return editorialCalendarPageLink;
	}
	
	@FindBy(xpath = "//span[text()='Explore all Use Cases']")
	private WebElement exploreAllUseCasesPageLink;

	public WebElement exploreAllUseCasesPageLink() {
		return exploreAllUseCasesPageLink;
	}
	
	@FindBy(xpath = "//span[text()='Discover all Trello views']")
	private WebElement discoverAllTrelloViewsPageLink;

	public WebElement discoverAllTrelloViewsPageLink() {
		return discoverAllTrelloViewsPageLink;
	}
	
	@FindBy(linkText = "Learn more about Timeline view")
	private WebElement learnMoreAboutTimelineViewLink;

	public WebElement learnMoreAboutTimelineViewLink() {
		return learnMoreAboutTimelineViewLink;
	}
	
	@FindBy(linkText = "Learn more about Calendar view")
	private WebElement learnMoreAboutCalendarViewLink;

	public WebElement learnMoreAboutCalendarViewLink() {
		return learnMoreAboutCalendarViewLink;
	}
	
	@FindBy(xpath = "//span[text()='Browse Integrations']")
	private WebElement browseIntegrationsPageLink;

	public WebElement browseIntegrationsPageLink() {
		return browseIntegrationsPageLink;
	}
	
	@FindBy(xpath = "//span[text()='Get to know Automation']")
	private WebElement getToKnowAutomationPageLink;

	public WebElement getToKnowAutomationPageLink() {
		return getToKnowAutomationPageLink;
	}
	
	@FindBy(xpath = "//span[text()='Explore Enterprise']")
	private WebElement exploreEnterprisePageLink;

	public WebElement exploreEnterprisePageLink() {
		return exploreEnterprisePageLink;
	}
	
	
	
}
