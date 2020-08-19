package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class UsersPage extends TestBase {
	//declaration
	@FindBy(xpath = "//div[text()='New User']")
	WebElement newUser;
	
	@FindBy(xpath = "//div[text()='Add User']")
	WebElement addUserPage;
	
	@FindBy(id = "createUserPanel_firstNameField")
	WebElement firstName;
	
	@FindBy(id = "createUserPanel_lastNameField")
	WebElement lastName;
	
	@FindBy(id = "createUserPanel_emailField")
	WebElement emailId;
	
	@FindBy(xpath = "//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']")
	WebElement deptDropDown;
	
	@FindBy(xpath = "//div[@class='item']")
	List<WebElement> deptList;
	
	@FindBy(xpath = "(//input[@name='newUserGroupName'])[2]")
	WebElement newDept;
	
	@FindBy(xpath = "//div[@class='components_button submitBtn']")
	WebElement saveAndSendInvitationBtn;
	
	@FindBy(xpath = "(//span[text()='Close'])[1]")
	WebElement closeBtn;
	
	@FindBy(xpath = "(//div[@class='inviteOneMoreButton'])[1]")
	WebElement inviteOneMoreUser;
	
	//initialization
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
		
	//utilization
	public void clickNewUser() {
		newUser.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(addUserPage));
		/*firstName.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 0));
		lastName.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 1));
		email.sendKeys(TestUtil.readDataFromExcel("Sheet1", 1, 2));*/
	}
	
	public String validateUsersTitle() {
		return driver.getTitle();
	}
	
	public void enterFirstName(String first) {
		firstName.sendKeys(first);
	}
	
	public void enterLastName(String last) {
		lastName.sendKeys(last);
	}
	
	public void enteremail(String email) {
		emailId.sendKeys(email);
	}
	
	public void selectDept(String department) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		deptDropDown.click();
		
		for(WebElement dept : deptList) {
			String text = dept.getText();
			if(text.contains(department) || department.isEmpty() || text.contains("department not assigned")) {
				int x = dept.getLocation().getX();
				int y = dept.getLocation().getY();
				je.executeScript("window.scrollTo("+x+","+y+")");
				je.executeScript("arguments[0].click()", dept);
				break;
			}
			else if(department. || department.contains("department not assigned") || text.contains("department not assigned")) {
				int x = dept.getLocation().getX();
				int y = dept.getLocation().getY();
				je.executeScript("window.scrollTo("+x+","+y+")");
				je.executeScript("arguments[0].click()", dept);
				break;
			}
			/*else {
				int x = dept.getLocation().getX();
				int y = dept.getLocation().getY();
				je.executeScript("window.scrollTo("+x+","+y+")");
				je.executeScript("arguments[0].click()", dept);
				newDept.sendKeys(department);;
				break;
			}*/
		}
	}
	
	public void saveAndSendInvitation() {
		saveAndSendInvitationBtn.click();
	}
	
	public void inviteOneMoreUser() {
		inviteOneMoreUser.click();
	}
	
	public void closeAddUser() {
		closeBtn.click();
	}
}