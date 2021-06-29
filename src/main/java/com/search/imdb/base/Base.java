package com.search.imdb.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;





public class Base {
	
	public static WebDriver driver;
	public static Properties configProp;
	public static String apikey;
	public static String type;
	public static String searchString;
	public static String title1;
	public static String title2;
	public static String title3;
	public static String browserURL;
	public static String browserName;
	

	
	
	public Base(){
		try {
			configProp = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/file/config/testdata"
					+ "/config.properties");
			configProp.load(ip);
//			apikey=configProp.getProperty("apikey");
//			type=configProp.getProperty("type");
//			searchString=configProp.getProperty("s");
//			title1=configProp.getProperty("title1");
//			title2=configProp.getProperty("title2");
//			title3=configProp.getProperty("title3");
			browserURL=configProp.getProperty("browserURL");
			browserName=configProp.getProperty("browserName");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){

		if(configProp.getProperty("browserName").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if(configProp.getProperty("browserName").equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(configProp.getProperty("browserURL"));
		
	}
	public static void finish() {
		driver.quit();
	}

}
