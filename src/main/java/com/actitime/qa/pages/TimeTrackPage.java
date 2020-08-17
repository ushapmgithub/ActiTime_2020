package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.qa.base.TestBase;

public class TimeTrackPage extends TestBase {
	//declaration
	@FindBy(xpath = "//div[@id='addTaskButtonId']")
	WebElement newTask;
	
	@FindBy(xpath = "//tr[@class='selectCustomerRow']//div[@class='comboboxButton']")
	WebElement customerDropDown;
	
	@FindBy(xpath = "//div[text()='- New Customer -']")
	WebElement selectCustomer;
	
	@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
	WebElement customerName;
	
	@FindBy(xpath = "//input[@placeholder='Enter Project Name']")
	WebElement projectName;
	
	@FindBy(xpath = "(//input[@placeholder='Enter task name'])[1]")
	WebElement firstTaskName;
	
	@FindBy(xpath = "(//button[text()='set deadline'])[1]")
	WebElement setDeadline;
	
	@FindBy(xpath = "(//div[@class='typeOfWorkButton editable'])[1]")
	WebElement typeOfWork;
	
	@FindBy(xpath = "(//div[text()='management'])[1]")
	WebElement selectTypeOfWork;
	
	@FindBy(xpath = "//div[text()='Create Tasks']")
	WebElement createTaskBtn;
	
	@FindBy(id = "container_users")
	WebElement usersTab;
	
	//initialization
	public TimeTrackPage() {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String validateTimeTrackPageTitle() {
		return driver.getTitle();
	}
	
	public void clickNewTask() {
		newTask.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(customerDropDown));
	}
	
	public void setNewCustomer() throws InterruptedException {
		customerDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='                Create New Tasks            ']"))));
		/*List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'itemRow ')]"));
		for(WebElement ele : elements) {
			Thread.sleep(1000);
			System.out.println(ele.getText());
			if(ele.getText().contains("New Customer")) {
				ele.click();
				break;
			}
		}*/
		
		// Create instance of Javascript executor
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//div[text()='- New Customer -']"));
		// now execute query which actually will scroll until that element is not appeared on page.
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		je.executeScript("window.scrollTo("+x+","+y+")");
		je.executeScript("arguments[0].click()", element);
		
		// Create instance of Javascript executor
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		//WebElement element = driver.findElement(By.xpath("//div[text()='- New Customer -']"));
		// now execute query which actually will scroll until that element is not appeared on page.
		//je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	
	public void enterCutomerName(String cn) {
		customerName.sendKeys(cn);
	}
	
	public void enterProjectName(String pn) {
		projectName.sendKeys(pn);
	}
	
	public void enterFirstTaskName(String tn) {
		firstTaskName.sendKeys(tn);
	}
	
	public void selecTypeOfWork() {
		typeOfWork.click();
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(selectTypeOfWork));
		List<WebElement> telement = driver.findElements(By.xpath("//div[@class='typeOfWorkRow']"));
		for(WebElement ele : telement) {
			String text = ele.getText();
			if(text.contains("management")) {
				ele.click();
				break;
			}
		}
			
		//selectTypeOfWork.click();
	}
	
	public void clickCreateTaskBtn() {
		createTaskBtn.click();
	}
	
	public UsersPage gotoUsersPage() {
		usersTab.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("actiTIME - User List"));
		return new UsersPage();
	}
}
