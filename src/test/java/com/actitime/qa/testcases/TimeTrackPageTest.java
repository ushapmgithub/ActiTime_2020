package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;

public class TimeTrackPageTest extends TestBase{
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	
	public TimeTrackPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		timeTrackPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void timeTrackPageTitleTest() {
		String timeTrackPageTitle = timeTrackPage.validateTimeTrackPageTitle();
		Assert.assertEquals(timeTrackPageTitle, "actiTIME - Enter Time-Track", "Title is not matching");
	}
	
	@Test
	public void createNewTaskTest() throws InterruptedException {
		timeTrackPage.clickNewTask();
		timeTrackPage.setNewCustomer();
		timeTrackPage.enterCutomerName("palu");
		timeTrackPage.enterProjectName("RedDragon");
		timeTrackPage.enterFirstTaskName("Housekeeping");
		timeTrackPage.selecTypeOfWork();
		timeTrackPage.clickCreateTaskBtn();
	}
	
	@AfterMethod(enabled=false)
	public void tearDown() {
		driver.quit();
	}
}
