package com.actitime.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import com.actitime.qa.pages.UsersPage;

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
		usersPage.createNewUser();
	}
	
	
	
}
