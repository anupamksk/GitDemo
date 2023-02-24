package com.sharp.atlassian.pomrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreatedBoardPage {
	
	WebDriver driver;
	

	public TrelloCreatedBoardPage(WebDriver driver) {
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

	@FindBy(className = "css-vi1z5v")
	// @FindBy(css ="input[placeholder='Search']")
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


	@FindBy(linkText = "Table")
	private WebElement tableLinkInCurrentWorkspace;

	public WebElement tableLinkInCurrentWorkspace() {
		return tableLinkInCurrentWorkspace;
	}

	@FindBy(linkText = "Calendar")
	private WebElement calendarLinkInCurrentWorkspace;

	public WebElement calendarLinkInCurrentWorkspace() {
		return calendarLinkInCurrentWorkspace;
	}
	
	@FindBy(css = "button[aria-label='Your boards menu']")
	private WebElement sortBoardsAlpabeticallyOption;

	public WebElement sortBoardsAlpabeticallyOption() {
		return sortBoardsAlpabeticallyOption;
	}
	
	//===========================================================//
	//elements under sortBoardAlpabeticallyOption
	//===========================================================//
	
	@FindBy(xpath = "//div[contains(@class,'css-2b097c-container')]")
	private WebElement sortAlpabeticallyDropdown;

	public WebElement sortBoardsAlpabeticallyDropdown() {
		return sortAlpabeticallyDropdown;
	}
	
	//===========================================================//
	
	@FindBy(xpath = "//div[(@class='board-header-btn mod-board-name inline-rename-board js-rename-board')]//h1")
	private WebElement boardNameText;

	public WebElement boardNameText() {
		return boardNameText;
	}
	
	@FindBy(xpath = "//div[@class='board-header-btns mod-right']//span[@aria-label=\"OverflowMenuHorizontalIcon\"]")
	private WebElement boardMenubar;

	public WebElement boardMenubar() {
		return boardMenubar;
	}
	
	
	//============================================================//
	//Options under boardMenubar
	//===========================================================//
	
	@FindBy(xpath = "//a[contains(text(),'More')]")
	private WebElement moreOptionInBoardMenu;

	public WebElement moreOptionInBoardMenu() {
		return moreOptionInBoardMenu;
	}
	
	//============================================================//
	//option under more Option in boardMenubar
	//===========================================================//
	
	@FindBy(xpath = "//a[contains(text(),'Close board')]")
	private WebElement closeBoardOptionInMore;

	public WebElement closeBoardOptionInMore() {
		return closeBoardOptionInMore;
	}
	
	@FindBy(xpath = "//input[contains(@class,'js-confirm')]")
	private WebElement confirmCloseButton;

	public WebElement confirmCloseButton() {
		return confirmCloseButton;
	}

	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permenentlyDeleteBoardLink;

	public WebElement permenentlyDeleteBoardLink() {
		return permenentlyDeleteBoardLink;
	}
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement confirmPermenentlyDeleteButton;

	public WebElement confirmPermenentlyDeleteButton() {
		return confirmPermenentlyDeleteButton;
	}
	
	@FindBy(xpath = "//span[text()='Board deleted.']")
	private WebElement boardDeletedConfirmationPopup;

	public WebElement boardDeletedConfirmationPopup() {
		return boardDeletedConfirmationPopup;
	}
	
	//======================================================//
	//List related elements//
	//======================================================//
	
	@FindBy(name = "name")
	private WebElement enterListTitleTextField;
	
	public WebElement enterListTitleTextField() {
		return enterListTitleTextField;
	}

	@FindBy(css = "input[value='Add list']")
	private WebElement submitAddListButton;

	public WebElement submitAddListButton() {
		return submitAddListButton;
	}
	
	@FindBys({@FindBy(xpath = "//div[@id='board']//div[@class='list js-list-content']")})
	private List<WebElement> listsCreated;

	public List<WebElement> listsCreated() {
		return listsCreated;
	}
	
	@FindBys({@FindBy(css = "textarea[class='list-header-name mod-list-name js-list-name-input']")})
	private List<WebElement> createdListNames;

	public List<WebElement> createdListNames() {
		return createdListNames;
	}
	//========================================================//
	//card reference in list//To give the user data to the xpath
	//========================================================//
	private WebElement listInBoard;
	public WebElement listInBoard(String givenListName) {
		listInBoard = driver.findElement(By.xpath("//textarea[contains(@aria-label,'"+givenListName +"')]/../.."));
		return listInBoard;
	}

	//========================================================//
	//Sort cards in list Alphabetically related elements
	//========================================================//
	
	private WebElement toAddACard;
	public WebElement toAddACard(String givenListName) {
		toAddACard = driver.findElement(By.xpath("//h2[text()='"+givenListName+"']/../..//a[@class='open-card-composer js-open-card-composer']"));
		return toAddACard;
	}
	
	@FindBy (xpath = "//div[@class='card-composer']//a[@class='icon-lg icon-close dark-hover js-cancel']")
	private WebElement cancelAddCardButton;
	
	public WebElement cancelAddCardButton() {
		return cancelAddCardButton;
	}
	
	private WebElement enterTextInListCard;
	public WebElement enterTextInListCard(String givenListName) {
		enterTextInListCard = driver.findElement(By.xpath("//h2[text()='"+givenListName+"']/../..//textarea[@placeholder='Enter a title for this card…']"));
		return enterTextInListCard;
	}
	
	private WebElement addCardButtonInList;
	public WebElement addCardButtonInList(String givenListName) {
		addCardButtonInList = driver.findElement(By.xpath("//h2[text()='"+givenListName+"']/../..//input[@value='Add card']"));
		return addCardButtonInList;
	}
	
	//===================================================
	//private the Xpath
	//===================================================
	
	private String addCardButtonListXpath = "//h2[text()='givenListName']/../..//input[@value='Add card']";
	public WebElement addCardButtonList(String givenListName) {
	return driver.findElement(By.xpath(addCardButtonListXpath.replace("givenListName", givenListName)));
	}
	
	
	
	//======================================================================
	
	@FindBy(css = "div[class='list js-list-content']")
	private WebElement list;

	public WebElement list() {
		return list;
	}
	
	

	private WebElement listMenuButton;
	public WebElement listMenuButton(String givenListName) {
		listMenuButton = driver.findElement(By.xpath("//textarea[contains(@aria-label,'"+givenListName+"')]/../..//div[contains(@class,'list-header-extras')]"));
		return listMenuButton;
	}

	@FindBy(className = "js-sort-cards")
	private WebElement cardNameSortBy;

	public WebElement cardNameSortBy() {
		return cardNameSortBy;
	}
	
	@FindBy(xpath = "//div[@class='pop-over is-shown']//a[text()='Move list…']")
	private WebElement moveToOptionInListMenu;

	public WebElement moveToOptionInListMenu() {
		return moveToOptionInListMenu;
	}
	
	@FindBy(className = "js-select-board")
	private WebElement boardDropdownInMoveToPopup;

	public WebElement boardDropdownInMoveToPopup() {
		return boardDropdownInMoveToPopup;
	}
	
	@FindBy(xpath = "//input[@value='Move']")
	private WebElement submitMoveButton;

	public WebElement submitMoveButton() {
		return submitMoveButton;
	}
	
	
	@FindBy(className = "js-sort-by-card-name")
	private WebElement cardSortByAlphabetically;

	public WebElement cardSortByAlphabetically() {
		return cardSortByAlphabetically;
	}
	
	
	
	@FindBy(css= "span[class='list-card-title js-card-name']")
	private List<WebElement> sortedCardText;

	public List<WebElement> sortedCardText() {
		return sortedCardText;
	}
	
	//============================================================================
	//logout related option
	//===========================================================================
	
	@FindBy(css = "button[aria-label='Open member menu']")
	private WebElement profieMenuButton;


	public WebElement profieMenuButton() {
		return profieMenuButton;
	}
	
	@FindBy(xpath = "//button[@data-testid='account-menu-logout']")
	private WebElement menulogoutButton;


	public WebElement menulogoutButton() {
		return menulogoutButton;
	}
//===========================================================================================
//drink
//=================================================================================
	@FindBy(xpath = "//div[@class='list-header-target js-editing-target']")
	private WebElement autoListcreated;


	public WebElement autoListcreated() {
		return autoListcreated;
	}

	
	
}
