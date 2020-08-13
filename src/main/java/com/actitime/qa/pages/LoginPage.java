package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class LoginPage extends TestBase {
	//declaration
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "pwd")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login ']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;
	
	@FindBy(xpath = "//div[@class='atProductName']")
	WebElement prodName;
	
	@FindBy(id = "toPasswordRecoveryPageLink")
	WebElement forgotPwd;
	
	@FindBy(id = "keepLoggedInLabel")
	WebElement keepmeLoggedIn;
	
	@FindBy(id = "keepLoggedInCheckBox")
	WebElement selectCheckBox;
	
	@FindBy(xpath = "//nobr[text()='actiTIME 2020 Online']")
	WebElement version;
	
	@FindBy(id = "keepLoggedInCheckBox")
	WebElement checkBox;

	//@FindBy(id="copyRight")
	@FindBy(xpath = "//*[contains(text(),'© ')]") 
	WebElement copyRight;
	
	@FindBy(xpath="//a[@href='http://www.actitime.com']")
	WebElement copyRightLink;
	
	//initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateProdName() {
		return prodName.isDisplayed();
	}
	
	public boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();
	}
	
	public TimeTrackPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("actiTIME - Enter Time-Track"));
		
		return new TimeTrackPage();
	}

	public String validateForgotPwdText() {
		return forgotPwd.getText();
	}
	
	public String validateForgotPwdLink() {
		return forgotPwd.getTagName();
	}
	
	public String validateKeepmeLoggedInText() {
		return keepmeLoggedIn.getText();
	}
	
	public String validateVersion() {
		return version.getText();
	}
	
	public String validateKeepmeLoggedInCheckBox() {
		return checkBox.getAttribute("type");
	}
	
	public boolean validateCheckBoxIsSelected() {
		return selectCheckBox.isSelected();
	}
	
	public void clickCheckBox() {
		selectCheckBox.click();
	}
	
	public String validateCopyRight() {
		return copyRight.getText();
	}
	
	public String validateCopyRightLink() {
		return copyRightLink.getTagName();
	}
}