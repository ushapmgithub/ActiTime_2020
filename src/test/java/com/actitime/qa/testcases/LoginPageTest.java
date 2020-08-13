package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	//Validating the login page title
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login", "actual title is not matching with expected");
	}
	
	//validating the logo and product name
	@Test(priority=2)
	public void actiTimeLogoAndProdNameTest() {
		boolean logoPresent = loginPage.validateActiTimeLogo();
		Assert.assertTrue(logoPresent, "logo is not present");
		boolean prodNamePresent = loginPage.validateProdName();
		Assert.assertTrue(prodNamePresent, "Product is not present");
	}
	
	//validating the forgot password text and checking whether it is a link or not
	@Test(priority=4)
	public void forgotPwdLinkTest() {
		String forgotPwdText = loginPage.validateForgotPwdText();
		Assert.assertEquals(forgotPwdText, "Forgot your password?", "Text don't match");
		String forgotPwdLink = loginPage.validateForgotPwdLink();
		Assert.assertEquals(forgotPwdLink, "a", "It is not a link");
	}
	
	//validating keep me logged in checkbox
	@Test(priority=5)
	public void keepmeLoggedInTest() {
		String keepmeLoggedInText = loginPage.validateKeepmeLoggedInText();
		Assert.assertEquals(keepmeLoggedInText, "Keep me logged in", "text do not match");
		String checkBox = loginPage.validateKeepmeLoggedInCheckBox();
		Assert.assertEquals(checkBox, "checkbox", "It is not a checkbox");
	}
	
	//checking whether checkbox is selected or not
	@Test(priority=6)
	public void checkBoxTest() {
		boolean notSelected = loginPage.validateCheckBoxIsSelected();
		Assert.assertFalse(notSelected, "checkbox is selected");
		loginPage.clickCheckBox();
		boolean selected = loginPage.validateCheckBoxIsSelected();
		Assert.assertTrue(selected, "checkbox is not selected");
	}
	
	//
	@Test(priority=7)
	public void copyRightTest() {
		String copyRightText = loginPage.validateCopyRight();
		Assert.assertEquals(copyRightText, "© actiTIME Inc.", "No copyright");
		String copyRightLink = loginPage.validateCopyRightLink();
		Assert.assertEquals(copyRightLink, "a", "It is not a link");
	}
	
	@Test(priority=8)
	public void versionTest() {
		String actiTimeVersion = loginPage.validateVersion();
		Assert.assertEquals(actiTimeVersion, "actiTIME 2020 Online", "There is no version number");
	}
	
	@Test(priority=3)
	public void loginTest() {
		timeTrackPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String timeTrackPageTitle = timeTrackPage.validateTimeTrackPageTitle();
		Assert.assertEquals(timeTrackPageTitle, "actiTIME - Enter Time-Track", "Title is not matching");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
