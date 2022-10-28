package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass
{
	
	@Test
	public void loginApp()
	{
		logger = report.createTest("Login");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Browser is launched");
		login.loginApp(excel.getStringData("LoginPage", 0, 0), excel.getStringData("LoginPage", 0, 1));
		
		try {
	 		Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.pass("Login is successfull");
		
	}

}