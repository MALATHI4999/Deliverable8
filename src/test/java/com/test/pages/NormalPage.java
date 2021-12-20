package com.test.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalPage {


    WebDriver driver;

    // I am Using web driver manager instead of chrome driver
    public  LoginPage setupDriver() {
        String browserName = this.getPropertyDetail("browser");
        String url = this.getPropertyDetail("url");

        if (browserName.equalsIgnoreCase("chrome") ){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(url);

        } else {
            System.out.println("Please enter correct browser Name");
        }
        driver.manage().window().maximize();
        return new LoginPage(driver);
    }


    public String getPropertyDetail(String propertyName){
        Properties prop = new Properties();
        String filePath= System.getProperty("user.dir");

        try {
            InputStream input = new FileInputStream(filePath+"/src/test/java/config/config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void teardown() {
        driver.quit();
    }

}