package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	private WebDriver driver;
	
	//1. @ByLocators:
	private By RegistrationLink = By.xpath("//a[contains(text(),'Register')]");
	private By FirstName = By.id("first_name");
	private By LastName = By.id("last_name");
	private By emailID = By.id("email");
	private By phoneNo = By.id("phone");
	private By pwd = By.id("password");
	private By confirm_pwd = By.id("password-confirm");
	private By timeZone = By.xpath("//select[@name= 'timezone']");
	private By RegisterBtn = By.xpath("//div/button[@type= 'submit']");
	private By RegSuccess = By.xpath("//button[@id = 'userDropdownButton']");
	
	//2. Constructor of the Login Page class
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3. Page Actions: features(Behavior) of the page in the form of methods
	
	public String RegistrationPageTitle()
	{
		return driver.getTitle();
	}
	
	public void ClickOnRegisterLink()
	{
		driver.findElement(RegistrationLink).click();
	}
	
	public void EnterUserDetails(String FN, String LN, String Eml, String PhNo, String Pwd, String CnfPwd)
	{
		driver.findElement(FirstName).sendKeys(FN);
		driver.findElement(LastName).sendKeys(LN);
		driver.findElement(emailID).sendKeys(Eml);
		driver.findElement(phoneNo).sendKeys(PhNo);
		driver.findElement(pwd).sendKeys(Pwd);
		driver.findElement(confirm_pwd).sendKeys(CnfPwd);
	}
	
	public void SelectTimeZoneFromDropDown()
	{
		WebElement ele = driver.findElement(timeZone);
		Select tz = new Select(ele);
		tz.selectByVisibleText("Kolkata");
	}
	
	public void ClickOnRegisterBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(RegisterBtn).click();
		Thread.sleep(3000);
	}
	
	public String UserRegisteredSuccessfully()
	{
		return driver.findElement(RegSuccess).getText();
		
	}
	
}

