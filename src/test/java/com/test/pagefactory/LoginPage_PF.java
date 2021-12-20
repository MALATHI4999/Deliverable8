package com.test.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scuba.deliverablehelper.BrowserFactory;
import com.test.page.LoginPage;

public class LoginPage_PF {
	@Test
	public void TestValidLogin() throws InterruptedException
	{
		WebDriver driver = BrowserFactory.StartBrowser("chrome", "https://opensource-demo.orangehrmlive.com");
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.LoginOrangeHrm("Admin","admin123");
		driver.quit();
	}
}