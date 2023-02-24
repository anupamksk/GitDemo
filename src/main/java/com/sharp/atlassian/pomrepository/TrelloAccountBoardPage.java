package com.sharp.atlassian.pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloAccountBoardPage {
	WebDriver driver;

	public TrelloAccountBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(css = "span[aria-label='ApplicationSwitcherIcon']")
	private WebElement applicationSwitcherIcon;

	public WebElement applicationSwitcherIcon() {
		return applicationSwitcherIcon;
	}

	@FindBy(css = "div[class='m2N684FcksCyfT']")
	private WebElement trelloLogoLink;

	public WebElement trelloLogoLink() {
		return trelloLogoLink;
	}

	@FindBy(xpath = "//span[text()='Workspaces']")
	private WebElement workspaceDropdown;

	public WebElement workspaceDropdown() {
		return workspaceDropdown;
	}

	@FindBy(xpath = "//span[text()='Recent']")
	private WebElement recentDropdown;

	public WebElement recentDropdown() {
		return recentDropdown;
	}

	@FindBy(xpath = "//span[text()='Starred']")
	private WebElement starredDropdown;

	public WebElement starredDropdown() {
		return starredDropdown;
	}

	@FindBy(xpath = "//span[text()='Templates' and (@class='NZKuM9KKC+KRYR')]")
	private WebElement templatesDropdown;

	public WebElement templatesDropdown() {
		return templatesDropdown;
	}

	@FindBy(css = "button[data-testid='header-create-menu-button']")
	private WebElement createDropdownButton;

	public WebElement createDropdownButton() {
		return createDropdownButton;
	}

	@FindBy(className = "css-15jov5j")
	//@FindBy(css ="input[placeholder='Search']")
	private WebElement searchTextField;

	public WebElement searchTextField() {
		return searchTextField;
	}

	@FindBy(css = "button[data-testid='header-notifications-button']")
	private WebElement notificationsMenuButton;

	public WebElement notificationsMenuButton() {
		return notificationsMenuButton;
	}

	@FindBy(css = "button[data-testid='header-info-button']")
	private WebElement infoButton;

	public WebElement infoButton() {
		return infoButton;
	}

	@FindBy(css = "button[data-testid='header-member-menu-button']")
	private WebElement profileMenuButton;

	public WebElement profileMenuButton() {
		return profileMenuButton;
	}

	@FindBy(xpath = "//span[text()='Boards' and (@class='JcbjHVsIKRtsb0')]")
	private WebElement leftNavigationTopBoardLink;

	public WebElement leftNavigationTopBoardLink() {
		return leftNavigationTopBoardLink;
	}

	@FindBy(xpath = "//span[text()='Templates' and (@class='JcbjHVsIKRtsb0')]")
	private WebElement leftNavigationTemplatesLink;

	public WebElement leftNavigationTemplatesLink() {
		return leftNavigationTemplatesLink;
	}

	@FindBy(xpath = "//span[text()='Home']")
	private WebElement leftNavigationHomeLink;

	public WebElement leftNavigationHomeLink() {
		return leftNavigationHomeLink;
	}

	@FindBy(xpath = "//span[contains(@class,'icon-add')]")
	private WebElement iconToAddWorkspace;

	public WebElement iconToAddWorkspace() {
		return iconToAddWorkspace;
	}

	@FindBy(css = "span[data-testid='home-team-tab-name']")
	private WebElement currentWorkspaceDropdown;

	public WebElement currentWorkspaceDropdown() {
		return currentWorkspaceDropdown;
	}

	@FindBy(xpath = "//ul[@class='']//span[text()='Boards']")
	private WebElement boardLinkInCurrentWorkspace;

	public WebElement boardLinkInCurrentWorkspace() {
		return boardLinkInCurrentWorkspace;
	}

	@FindBy(xpath = "//ul[@class='']//span[text()='Highlights']")
	private WebElement highlightsLinkInCurrentWorkspace;

	public WebElement highlightsLinkInCurrentWorkspace() {
		return highlightsLinkInCurrentWorkspace;
	}

	@FindBy(xpath = "//ul[@class='']//span[text()='Views']")
	private WebElement viewsLinkInCurrentWorkspace;

	public WebElement viewsLinkInCurrentWorkspace() {
		return viewsLinkInCurrentWorkspace;
	}

	@FindBy(xpath = "//ul[@class='']//span[text()='Members']")
	private WebElement membersLinkInCurrentWorkspace;

	public WebElement membersLinkInCurrentWorkspace() {
		return membersLinkInCurrentWorkspace;
	}

	@FindBy(xpath = "//ul[@class='']//span[text()='Settings']")
	private WebElement settingsLinkInCurrentWorkspace;

	public WebElement settingsLinkInCurrentWorkspace() {
		return settingsLinkInCurrentWorkspace;
	}

	@FindBy(css = "span[aria-label='CloseIcon']")
	private WebElement mostPopularTempletsCloseButton;

	public WebElement mostPopularTempletsCloseButton() {
		return mostPopularTempletsCloseButton;
	}

	@FindBy(xpath = "div[class='J+c2IiaNOYgZBB css-ufz0vj-control']")
	private WebElement chooseTempletsCatogoryDropdown;

	public WebElement chooseTempletsCatogoryDropdown() {
		return chooseTempletsCatogoryDropdown;
	}

	@FindBy(linkText = "Browse the full template gallery")
	private WebElement browseTheFullTemplateGalleryLinktext;

	public WebElement browseTheFullTemplateGalleryLinktext() {
		return browseTheFullTemplateGalleryLinktext;
	}

	@FindBy(xpath = "//span[text()='Boards' and not (@class)]")
	private WebElement boardLinkInWorkspacePage;

	public WebElement boardLinkInWorkspacePage() {
		return boardLinkInWorkspacePage;
	}

	@FindBy(xpath = "//span[text()='Views' and not (@class)]")
	private WebElement viewsLinkInWorkspacePage;

	public WebElement viewsLinkInWorkspacePage() {
		return viewsLinkInWorkspacePage;
	}

	@FindBy(xpath = "//span[text()='Members' and not (@class)]")
	private WebElement membersLinkInWorkspacePage;

	public WebElement membersLinkInWorkspacePage() {
		return membersLinkInWorkspacePage;
	}

	@FindBy(xpath = "//span[text()='Settings' and not (@class)]")
	private WebElement settingsLinkInWorkspacePage;

	public WebElement settingsLinkInWorkspacePage() {
		return settingsLinkInWorkspacePage;
	}

	@FindBy(css = "button[data-testid='team-boards-header-upgrade-button']")
	private WebElement boardUpgradeButton;

	public WebElement boardUpgradeButton() {
		return boardUpgradeButton;
	}

	@FindBy(css = "div[class='board-tile mod-add']")
	private WebElement reateNewBoardButtonOptionInWorkspace;

	public WebElement reateNewBoardButtonOptionInWorkspace() {
		return reateNewBoardButtonOptionInWorkspace;
	}

	@FindBy(css = "span[aria-label='InformationIcon']")
	private WebElement guestWorkspaceInformationLinkButton;

	public WebElement guestWorkspaceInformationLinkButton() {
		return guestWorkspaceInformationLinkButton;
	}

	@FindBy(xpath = "//button[text()='View all closed boards']")
	private WebElement viewAllClosedBoardsLink;

	public WebElement viewAllClosedBoardsLink() {
		return viewAllClosedBoardsLink;
	}
	// ===================================================================
	// Options Under profileMenuButton
	// ===================================================================

	@FindBy(xpath = "//span[text()='Switch accounts']")
	private WebElement switchAccountsOption;

	public WebElement switchAccountsOption() {
		return switchAccountsOption;
	}

	@FindBy(xpath = "//span[text()='Manage account']")
	private WebElement manageAccountsOption;

	public WebElement manageAccountsOption() {
		return manageAccountsOption;
	}

	@FindBy(xpath = "//span[text()='Profile and visibility']")
	private WebElement profileAnsVisibilityOption;

	public WebElement profileAnsVisibilityOption() {
		return profileAnsVisibilityOption;
	}

	@FindBy(xpath = "//span[text()='Activity']")
	private WebElement activityOption;

	public WebElement activityOption() {
		return activityOption;
	}

	@FindBy(xpath = "//span[text()='Cards']")
	private WebElement cardsOption;

	public WebElement cardsOption() {
		return cardsOption;
	}

	@FindBy(css = "a[data-testid='account-menu-settings']")
	private WebElement accountMebuSettingsOption;

	public WebElement accountMebuSettingsOption() {
		return accountMebuSettingsOption;
	}

	@FindBy(xpath = "//span[text()='Help']")
	private WebElement helpOption;

	public WebElement helpOption() {
		return helpOption;
	}

	@FindBy(xpath = "//span[text()='Shortcuts']")
	private WebElement shortcutsOption;

	public WebElement shortcutsOption() {
		return shortcutsOption;
	}

	@FindBy(css = "button[data-testid='account-menu-logout']")
	private WebElement accountMenuLogoutOption;

	public WebElement accountMenuLogoutOption() {
		return accountMenuLogoutOption;
	}

	// ===================================================
	// Options Under createDropdownButton
	// ===================================================

	@FindBy(css = "button[data-testid='header-create-board-button']")
	private WebElement createBoardOption;

	public WebElement createBoardOption() {
		return createBoardOption;
	}

	@FindBy(css = "button[data-testid='header-create-board-from-template-button']")
	private WebElement startWithATemplateOption;

	public WebElement startWithATemplateOption() {
		return startWithATemplateOption;
	}

	@FindBy(css = "button[data-testid='header-create-team-button']")
	private WebElement createWorkspaceOption;

	public WebElement createWorkspaceOption() {
		return createWorkspaceOption;
	}
	
	//====================================================
	// Elements under createBoardOption
	//====================================================
	
	@FindBy(css = "input[data-testid='create-board-title-input']")
	private WebElement boardTitleTextfield;

	public WebElement boardTitleTextfield() {
		return boardTitleTextfield;
	}
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;

	public WebElement createButton() {
		return createButton;
	}
	
	//========================================================
	// To open the card in Acount page used in moveLoadedListToAnotherBoard()
	//========================================================
	
	private String selectBoardOnAccountPage = "//ul[@class='boards-page-board-section-list']//div[text()='givenListName']";
	public WebElement selectBoardOnAccountPage(String givenListName) {
	return driver.findElement(By.xpath(selectBoardOnAccountPage.replace("givenListName", givenListName)));
	}


}
