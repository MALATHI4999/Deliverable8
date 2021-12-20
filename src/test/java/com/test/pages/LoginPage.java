package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(id = "txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.ID, using = "txtPassword")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"btnLogin\"]")
	@CacheLookup
	WebElement login_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"welcome\\\"]")
	@CacheLookup
	WebElement welcome;
	
	@FindBy(how = How.LINK_TEXT, using = "Logout")
	@CacheLookup
	WebElement logout_button;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void LoginOrangeHrm(String uname, String passwd) throws InterruptedException
	{
		username.sendKeys(uname);
		password.sendKeys(passwd);
		Thread.sleep(500);
		login_button.click();
	}
	/*public void Logout() throws InterruptedException
	{
		welcome.click();
		Thread.sleep(500);
		logout_button.click();
	}*/
}
