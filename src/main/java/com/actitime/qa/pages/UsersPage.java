package com.actitime.qa.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;

public class UsersPage extends TestBase {
	//declaration
	//@FindBy(id = "container_users")
	//WebElement usersTab;
	
	@FindBy(xpath = "//div[text()='New User']")
	WebElement newUser;
	
	@FindBy(xpath = "//div[text()='Add User']")
	WebElement addUserPage;
	
	@FindBy(id = "createUserPanel_firstNameField")
	WebElement firstName;
	
	@FindBy(id = "createUserPanel_lastNameField")
	WebElement lastName;
	
	@FindBy(id = "createUserPanel_emailField")
	WebElement email;
	
	//initialization
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
		
	//utilization
	public String validateUsersTitle() {
		return driver.getTitle();
	}
	
	public void createNewUser() throws InvalidFormatException, IOException {
		newUser.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(addUserPage));
		firstName.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 0));
		lastName.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 1));
		email.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 2));
	}
			
}