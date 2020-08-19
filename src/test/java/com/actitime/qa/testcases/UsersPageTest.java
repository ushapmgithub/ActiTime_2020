package com.actitime.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

public class UsersPageTest extends TestBase {
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	UsersPage usersPage;
	
	public UsersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		timeTrackPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		usersPage = timeTrackPage.gotoUsersPage();
	}
	
	@Test
	public void createNewUserTest() throws InvalidFormatException, IOException {
		usersPage.clickNewUser();
		//enter details
		int noOfUsers = TestUtil.noOfValues("Sheet1");
		for(int row=1; row<=noOfUsers; row++) {
			String first = TestUtil.readDataFromExcel("Sheet1", row, 0);
			usersPage.enterFirstName(first);
			String last = TestUtil.readDataFromExcel("Sheet1", row, 1);
			usersPage.enterLastName(last);
			String email = TestUtil.readDataFromExcel("Sheet1", row, 2);
			usersPage.enteremail(email);
			String department = TestUtil.readDataFromExcel("Sheet1", row, 3);
			usersPage.selectDept(department);
			usersPage.saveAndSendInvitation();
			usersPage.inviteOneMoreUser();
		}
		usersPage.closeAddUser();
	}
	
	//@AfterMethod
	
	
	
}
