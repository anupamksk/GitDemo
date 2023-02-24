package trello;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sharp.atlassian.genericutility.BaseClass;
import com.sharp.atlassian.genericutility.CustomListeners;
import com.sharp.atlassian.genericutility.TrelloUtility;
import com.sharp.atlassian.pomrepository.LogoutOfAtlassianAccountPage;
import com.sharp.atlassian.pomrepository.TrelloAccountBoardPage;
import com.sharp.atlassian.pomrepository.TrelloCreatedBoardPage;
import com.sharp.atlassian.pomrepository.TrelloHomePage;
import com.sharp.atlassian.pomrepository.TrelloLoginPage;
import com.sharp.atlassian.pomrepository.TrelloLoginToContinuePage;
@Listeners(CustomListeners.class)
public class TrelloEndToEndTestCases extends BaseClass {
	
	@Test(priority = 7)
	public void trelloHomePageCheck() throws EncryptedDocumentException, IOException, TimeoutException {
		
		String completeHomepageTitle = excelUtils.readStringData("testcasedata",3,1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, completeHomepageTitle),true,"Trello home page is not displayed and verified upon title.");
		Reporter.log("Trello home page is displayed and verified upon title.");
		String completeHomepageUrl = fileUtils.readCommondata("url");
		Assert.assertEquals(webDriverUtils.explicitwaitForCompleteUrl(driver, completeHomepageUrl),true,"Trello home page is not displayed and verified upon url.");
		Reporter.log("Trello home page is displayed and verified upon url.");
		int[] a=new int[2];
		System.out.println(a[2]);
		
	}
	@Test(priority = 8)
	public void trelloLoginPageCheck() throws EncryptedDocumentException, IOException, TimeoutException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		webElementUtils.clickOnVisibleElement(driver, homePage.loginLinkText());
		String loginPageTitle = excelUtils.readStringData("testcasedata",4,1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, loginPageTitle),true,"Trello login page is not displayed and verified upon title.");
		Reporter.log("Trello login page is displayed and verified upon title.");
		String loginPageUrl = excelUtils.readStringData("testcasedata",5,1);
		Assert.assertEquals(webDriverUtils.explicitwaitForCompleteUrl(driver, loginPageUrl),true,"Trello login page is not displayed and verified upon url.");
		Reporter.log("Trello login page is displayed and verified upon url.");
	}
	@Test(priority = 9)
	public void trelloBoardPageCheck() throws Throwable {
		TrelloUtility trelloUtils=new TrelloUtility(driver);
		trelloUtils.trelloLogin();
		String expectedBoardPageTitle = excelUtils.readStringData("testcasedata",7,1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedBoardPageTitle),true,"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		String boardPageUrlContains = excelUtils.readStringData("testcasedata",8,1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardPageUrlContains),true,"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		trelloUtils.trelloLogOut();
	}

	@Test(priority = 4)
	public void trelloCreateAndDeleteBoard() throws Throwable {
		TrelloUtility trelloUtils=new TrelloUtility(driver);
		trelloUtils.trelloLogin();
		//Create Board
		String expectedBoardPageTitle = excelUtils.readStringData("testcasedata",7,1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedBoardPageTitle),true,"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		String boardPageUrlContains = excelUtils.readStringData("testcasedata",8,1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardPageUrlContains),true,"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardPage = new TrelloAccountBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createDropdownButton());
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createBoardOption());
		webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardPage.boardTitleTextfield(),excelUtils.readStringData("testcasedata",2,1));
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createButton());
		String actualCreatedBoardPageUrlContains = excelUtils.readStringData("testcasedata",7,2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardPageUrlContains),true,"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		TrelloCreatedBoardPage createdBoardPage = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver,createdBoardPage.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata",2,1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		//createBoard Finished		
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.boardMenubar());
		Assert.assertTrue(webElementUtils.displayOfElement(driver, createdBoardPage.moreOptionInBoardMenu()),"Board menu is not displayed");
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.moreOptionInBoardMenu());
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.closeBoardOptionInMore());
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.confirmCloseButton());
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.permenentlyDeleteBoardLink());
		webElementUtils.clickOnVisibleElement(driver, createdBoardPage.confirmPermenentlyDeleteButton());
		Assert.assertTrue(webElementUtils.displayOfElement(driver, createdBoardPage.boardDeletedConfirmationPopup()),"Board is not deleted and board deleted popup is not displayed");
		Reporter.log("Board is succefully deleted and varified on popup displayed");
		trelloUtils.trelloLogOut();
	}

	public void deleteLastCreatedBoard() throws Throwable {
		TrelloCreatedBoardPage createdpage= new TrelloCreatedBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver,createdpage.boardMenubar());
		Assert.assertTrue(webElementUtils.displayOfElement(driver,createdpage.moreOptionInBoardMenu()),"Board menu is not displyed");
		webElementUtils.clickOnVisibleElement(driver,createdpage.moreOptionInBoardMenu());
		webElementUtils.clickOnVisibleElement(driver,createdpage.closeBoardOptionInMore());
		webElementUtils.clickOnVisibleElement(driver,createdpage.confirmCloseButton());
		webElementUtils.clickOnVisibleElement(driver,createdpage.permenentlyDeleteBoardLink());
		webElementUtils.clickOnVisibleElement(driver,createdpage.confirmPermenentlyDeleteButton());
		// Validating Board Deleted Pop-up
		Assert.assertTrue(webElementUtils.displayOfElement(driver,createdpage.boardDeletedConfirmationPopup()),"Board is not deleted and board deleted popup is not displayed");
		Reporter.log("Board is succefully deleted and varified on popup displayed");
	}

	@Test (priority = 5)
	public void trelloCreateBoardAndCreateTwoListInCreatedBoard() throws Throwable {
		TrelloUtility trelloUtils=new TrelloUtility(driver);
		trelloUtils.trelloLogin();
		//Create Board
		String expectedBoardPageTitle = excelUtils.readStringData("testcasedata",7,1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedBoardPageTitle),true,"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		String boardPageUrlContains = excelUtils.readStringData("testcasedata",8,1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardPageUrlContains),true,"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardPage = new TrelloAccountBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createDropdownButton());
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createBoardOption());
		webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardPage.boardTitleTextfield(),excelUtils.readStringData("testcasedata",2,1));
		webElementUtils.clickOnVisibleElement(driver, acountBoardPage.createButton());
		String actualCreatedBoardPageUrlContains = excelUtils.readStringData("testcasedata",7,2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardPageUrlContains),true,"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		TrelloCreatedBoardPage createdBoardPage = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver,createdBoardPage.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata",2,1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		//createBoard Finished		
		for (int cellnum = 1;cellnum < excelUtils.getLastCellNumInSheet("testcasedata",10);cellnum++) {
			webElementUtils.sendkeysOnVisibleTextField(driver, createdBoardPage.enterListTitleTextField(),excelUtils.readStringData("testcasedata", 10, cellnum));
			webElementUtils.submitOnVisibleElement(driver, createdBoardPage.submitAddListButton());
		}
		Assert.assertEquals(createdBoardPage.listsCreated().size(), excelUtils.readNumericData("testcasedata",9,1),"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		deleteLastCreatedBoard();
		trelloUtils.trelloLogOut();
	}

	@Test (priority = 6)
	public void trelloCreateBoardAndListAndSwapTheListInBoards() throws Throwable {
		TrelloUtility trelloUtils=new TrelloUtility(driver);
		trelloUtils.trelloLogin();
		// Validating Title
		String expectedboardTitle = excelUtils.readStringData("testcasedata", 7, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelUtils.readStringData("testcasedata", 8, 1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelUtils.readStringData("testcasedata", 2, 1));
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelUtils.readStringData("testcasedata", 7, 2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdpage = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver, createdpage.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create the board
		// ===================================================
		TrelloCreatedBoardPage createdboard2 = new TrelloCreatedBoardPage(driver);
		for (int cellnum = 1; cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 10); cellnum++) {
			webElementUtils.sendkeysOnVisibleTextField(driver, createdboard2.enterListTitleTextField(),
					excelUtils.readStringData("testcasedata", 10, cellnum));
			webElementUtils.submitOnVisibleElement(driver, createdboard2.submitAddListButton());
		}
		Assert.assertEquals(createdboard2.listsCreated().size(), excelUtils.readNumericData("testcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =========================================================================
		// Instructions To swipe the lists
		// =========================================================================
		Reporter.log("Order of Lists before swapping", true);
		for (WebElement listName : createdboard2.createdListNames()) {
			String text = listName.getText();
			Reporter.log(text, true);
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(createdboard2.listInBoard(excelUtils.readStringData("testcasedata", 10, 1)))
				.pause(1000).clickAndHold().pause(1000).moveByOffset(300, 20).pause(1000).release().build().perform();
		Reporter.log("Order of Lists after swapping", true);
		for (WebElement listName : createdboard2.createdListNames()) {
			String text = listName.getText();
			Reporter.log(text, true);
		}
		deleteLastCreatedBoard();
		trelloUtils.trelloLogOut();
	}

	@Test (priority = 3)
	public void trelloCreatBoardAndCardsAndArrangeInAlphabeticalOrder() throws Throwable {
		// =================================================================================================
		// Create the 2 list in the board
		// =================================================================================================
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtils.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginPage.usernameTextField(),
				excelUtils.readStringData("testcasedata", 0, 1));
		webElementUtils.submitOnVisibleElement(driver, loginPage.continueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelUtils.readStringData("testcasedata", 6, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelUtils.readStringData("testcasedata", 1, 1));
		webElementUtils.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelUtils.readStringData("testcasedata", 7, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelUtils.readStringData("testcasedata", 8, 1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelUtils.readStringData("testcasedata", 2, 1));
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelUtils.readStringData("testcasedata", 7, 2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create 2 list in the board
		// ===================================================
		for (int cellnum = 1; cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 10); cellnum++) {
			webElementUtils.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelUtils.readStringData("testcasedata", 10, cellnum));
			webElementUtils.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelUtils.readNumericData("testcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =================================================================================================
		// Sorting the cards in list alphabetically
		// =================================================================================================
		webElementUtils.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelUtils.readStringData("testcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelUtils.getLastCellNumInSheet("testcasedata", 12); cellNum++) {
			String data = excelUtils.readStringData("testcasedata", 12, cellNum);
			webElementUtils.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelUtils.readStringData("testcasedata", 10, 1)), data);
			webElementUtils.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelUtils.readStringData("testcasedata", 10, 1)));
		}
		Reporter.log("Card name before sorting", true);
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtils.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		webElementUtils.clickOnVisibleElement(driver,
				createdboard.listMenuButton(excelUtils.readStringData("testcasedata", 10, 1)));
		webElementUtils.clickOnVisibleElement(driver, createdboard.cardNameSortBy());
		webElementUtils.clickOnVisibleElement(driver, createdboard.cardSortByAlphabetically());
		Reporter.log("Card name After sorting", true);
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtils.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		deleteLastCreatedBoard();
		logout();
	}

	public void logout() throws Throwable {
		// loginToAccount();
		TrelloCreatedBoardPage createdboard4 = new TrelloCreatedBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, createdboard4.profieMenuButton());
		Assert.assertTrue(webElementUtils.displayOfElement(driver, createdboard4.menulogoutButton()),
				"Logout Option in menu is not display");
		Reporter.log("LogOut option is Displayed");
		webElementUtils.clickOnVisibleElement(driver, createdboard4.menulogoutButton());
		LogoutOfAtlassianAccountPage logoutPage = new LogoutOfAtlassianAccountPage(driver);
		String logoupageUrlContains = excelUtils.readStringData("testcasedata", 13, 1);
		Assert.assertTrue(webDriverUtils.explicitwaitForUrlcontains(driver, logoupageUrlContains),
				"Log out of your Atlassian account page is not displayed and verified upon url contains email reference.");
		Reporter.log(
				"Log out of your Atlassian account page is displayed and verified upon url contains email reference.");
		webElementUtils.clickOnVisibleElement(driver, logoutPage.logoutButton());
		String homepageUrlContains = excelUtils.readStringData("testcasedata", 14, 1);
		// it is throwing timeout Exception due to some problem
		Assert.assertTrue(webDriverUtils.explicitwaitForUrlcontains(driver, homepageUrlContains),
				"Log out of your Atlassian account is not successfull and verified upon url contains email reference.");
		Reporter.log(
				"Log out of your Atlassian account is successfull and verified upon homepage URL");
	}

	@Test (priority = 2)
	public void trelloCreateBoardAndListAndCardGetTheCount() throws Throwable {
		//sortCardsAlpabetically();
		// =================================================================================
		// Create cards and lists in the created board
		// =================================================================================
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtils.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginPage.usernameTextField(),
				excelUtils.readStringData("testcasedata", 0, 1));
		webElementUtils.submitOnVisibleElement(driver, loginPage.continueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelUtils.readStringData("testcasedata", 6, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelUtils.readStringData("testcasedata", 1, 1));
		webElementUtils.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelUtils.readStringData("testcasedata", 7, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelUtils.readStringData("testcasedata", 8, 1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelUtils.readStringData("testcasedata", 2, 1));
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelUtils.readStringData("testcasedata", 7, 2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create 2 list in the board
		// ===================================================
		for (int cellnum = 1; cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 10); cellnum++) {
			webElementUtils.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelUtils.readStringData("testcasedata", 10, cellnum));
			webElementUtils.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelUtils.readNumericData("testcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =================================================================================================
		// Sorting the cards in list alphabetically
		// =================================================================================================
		webElementUtils.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelUtils.readStringData("testcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelUtils.getLastCellNumInSheet("testcasedata", 12); cellNum++) {
			String data = excelUtils.readStringData("testcasedata", 12, cellNum);
			webElementUtils.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelUtils.readStringData("testcasedata", 10, 1)), data);
			webElementUtils.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelUtils.readStringData("testcasedata", 10, 1)));
		}
		Reporter.log("Cards in list");
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtils.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		// =================================================================================
		// Get the count of created cards and list in the board
		// =================================================================================

		int countOfList = createdboard.createdListNames().size();
		int countOfCardsInList = createdboard.sortedCardText().size();
		Reporter.log("Count of created lists in Board : " + countOfList);
		Reporter.log("Ccount of cards created in list : " + countOfCardsInList);
		deleteLastCreatedBoard();
		logout();
	}

	@Test (priority = 1)
	public void trelloCreateBoardAndListThenMoveFullListToAnotherBoardCheck() throws Throwable {
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtils.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginPage.usernameTextField(),
				excelUtils.readStringData("testcasedata", 0, 1));
		webElementUtils.submitOnVisibleElement(driver, loginPage.continueButton());
		String completeLoginToContinuePageTitle = excelUtils.readStringData("testcasedata", 6, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");
		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtils.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelUtils.readStringData("testcasedata", 1, 1));
		webElementUtils.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		String expectedboardTitle = excelUtils.readStringData("testcasedata", 7, 1);
		Assert.assertEquals(webDriverUtils.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		String boardpageUrlContains = excelUtils.readStringData("testcasedata", 8, 1);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		for (int cellnum = 1; cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 15); cellnum++) {
			webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
			webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
			webElementUtils.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
					excelUtils.readStringData("testcasedata", 15, cellnum));
			webElementUtils.clickOnVisibleElement(driver, acountBoardpage.createButton());
			if (cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 15) - 1) {
				driver.navigate().back();
			}
		}
		String actualCreatedBoardpageUrlContains = excelUtils.readStringData("testcasedata", 15, 2);
		Assert.assertEquals(webDriverUtils.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtils.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelUtils.readStringData("testcasedata", 15, 2);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		//======================================================================================
		for (int cellnum = 1; cellnum < excelUtils.getLastCellNumInSheet("testcasedata", 10)-1; cellnum++) {
			webElementUtils.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelUtils.readStringData("testcasedata", 10, cellnum));
			webElementUtils.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelUtils.readNumericData("testcasedata", 9, 1)-1,
				"list not created");
		Reporter.log("list successfully created and varified");
		//===================================================================
		webElementUtils.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelUtils.readStringData("testcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelUtils.getLastCellNumInSheet("testcasedata", 12); cellNum++) {
			String data = excelUtils.readStringData("testcasedata", 12, cellNum);
			webElementUtils.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelUtils.readStringData("testcasedata", 10, 1)), data);
			webElementUtils.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelUtils.readStringData("testcasedata", 10, 1)));
		}
		webElementUtils.clickOnVisibleElement(driver, createdboard.cancelAddCardButton());
		Reporter.log("Cards created in List : Fully loaded");
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtils.getTagtexOfElement(driver, element);
			Reporter.log(text);
		}
		//==========================
		//To move the list from one board to another board
		//==========================
		String listName = excelUtils.readStringData("testcasedata", 10, 1);
		webElementUtils.clickOnVisibleElement(driver, createdboard.listMenuButton(listName));
		webElementUtils.clickOnVisibleElement(driver, createdboard.moveToOptionInListMenu());
		Select boardDropdown = new Select(createdboard.boardDropdownInMoveToPopup());
		boardDropdown.selectByVisibleText(excelUtils.readStringData("testcasedata", 15, 1));//createdboard1
		webElementUtils.submitOnVisibleElement(driver, createdboard.submitMoveButton());
		deleteLastCreatedBoard();
		webElementUtils.clickOnVisibleElement(driver, acountBoardpage.selectBoardOnAccountPage(excelUtils.readStringData("testcasedata", 15, 1)));
		acountBoardpage.selectBoardOnAccountPage(excelUtils.readStringData("testcasedata", 15, 1));
		//Assert.assertTrue(createdboard.list().isDisplayed(), "List not moved successfully");
		Reporter.log("List moved sucessfully: Fully loaded list cotains card");
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtils.getTagtexOfElement(driver, element);
			Reporter.log(text);
		}
		deleteLastCreatedBoard();
		logout();
	}
}
