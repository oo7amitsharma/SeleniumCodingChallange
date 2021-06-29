package com.search.testcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

 

public class AmazonShopping {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Learning Selenium\\src\\Webdriver\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://news.google.com");
        String str="a-size-base-plus a-color-base a-text-normal";

        WebDriverManager.chromedriver().setup();
        
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        
        
        driver.findElement(By.xpath("//a[text()='Explore now']")).click();
        
        int i = 0;
        List<WebElement> shopbycategory = driver.findElements(By.xpath("//span[@class=\"a-color-base\"]"));
      //  while(i<shopbycategory.size()) {
        for(WebElement shopping : shopbycategory) {
            System.out.println("SHOP BY CATEGORY");
            System.out.println(shopping.getText()); 
        }
        
        System.out.println("Item price available Under $25");
        driver.findElement(By.xpath("//span[text()='Under $25']")).click(); 
        
        List<WebElement> shopbycategory1 = driver.findElements(By.xpath("//*[@class=\"a-link-normal a-text-normal\" or @data-a-color=\"base\" or @data-a-color=\"secondary\"]/span[1]"));
	         //  for(WebElement shopbycategory11 : shopbycategory1) {    
                while(i<shopbycategory1.size()) {
	            System.out.println(shopbycategory1.get(i).getAttribute("innerHTML"));
			        if(str.equals(shopbycategory1.get(i).getAttribute("class"))) {           
			            System.out.println(shopbycategory1.get(i).getAttribute("class"));
			            shopbycategory1.get(i).click();
			            try {
					
				            if(driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).isEnabled()) {
				                driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
				                driver.navigate().back();
				            }
				            
			            } catch (Exception e) {
							// TODO: handle exception
			            	System.out.println(e);
						}    
			            driver.navigate().back();
			         }
				        shopbycategory1.clear();
				        shopbycategory1 = driver.findElements(By.xpath("//*[@class=\"a-link-normal a-text-normal\" or @data-a-color=\"base\" or @data-a-color=\"secondary\"]/span[1]"));
			     i++;
                }
     }
}