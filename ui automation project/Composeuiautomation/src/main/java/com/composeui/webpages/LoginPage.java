package com.composeui.webpages;

import com.composeui.config.config.TestConfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by a627563 on 26-02-2017.
 */
public class LoginPage {
    private WebDriver driver;
    
    //     xpath= //input[@name='username']  
    
 //   @FindBy(xpath = "//*[@id=\"container\"]/div/header/div[1]/div[1]/div/ul/li[9]/a")
 //   WebElement loginButton;

   // @FindBy(xpath="//input[@name='userName']")
    @FindBy(name="userName")
    WebElement txtUserName;

    @FindBy(xpath="//input[@name='password']")    
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginSubmitButton;

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        driver.get(TestConfiguration.getValue("application.url"));

    }

    public void doLogin(String uname, String password)
    {
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  loginButton.click();
    	driver.findElement(By.name("userName")).sendKeys(uname);
      //  txtUserName.sendKeys(uname);
        txtPassword.sendKeys(password);
        loginSubmitButton.click();
    }
}
