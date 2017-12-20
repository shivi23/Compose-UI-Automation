package com.composeui.config.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ResourceBundle;

/**
 * Created by a627563 on 26-02-2017.
 */
public class TestConfiguration
{
	/*Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
	obj.load(objfile);
	String mobileTesting = obj.getProperty("MobileTesting");*/
	
	
	private static ResourceBundle properties = ResourceBundle.getBundle("config");

	public static String getValue(String key) 
	{
		return properties.getString(key);
	}

	public static WebDriver getDriver()
	{
		WebDriver driver;
		if (getValue("test.browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", getValue("test.chromedriver"));
			driver = new ChromeDriver();
		} 
		else if (getValue("test.browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else if (getValue("test.browser").equalsIgnoreCase("ie")) 
		{
			driver = new InternetExplorerDriver();
		} 
		else 
		{
			driver = new FirefoxDriver();
		}
		return driver;
	}
}