package com.sharp.atlassian.genericutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.sharp.atlassian.pomrepository.LogoutOfAtlassianAccountPage;
import com.sharp.atlassian.pomrepository.TrelloCreatedBoardPage;
import com.sharp.atlassian.pomrepository.TrelloHomePage;
import com.sharp.atlassian.pomrepository.TrelloLoginPage;
import com.sharp.atlassian.pomrepository.TrelloLoginToContinuePage;

public class TrelloUtility extends BaseClass{
	WebDriver driver;
	public TrelloUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver trelloLogin() throws EncryptedDocumentException, IOException{
		
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
		return driver;
		
	}
	
	public void deleteCurrentBoard() {
		
		
	}
	
	public WebDriver trelloLogOut() throws EncryptedDocumentException, IOException {
		
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
		return driver;
	}

	}

