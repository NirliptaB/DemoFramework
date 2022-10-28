package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginbtn;
	
	public void loginApp(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	
}