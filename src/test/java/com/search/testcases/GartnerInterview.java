package com.search.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GartnerInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<WebElement> list = new ArrayList();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jkuma235\\Desktop\\chromedriver_win\\chromedriver.exe");
		//WebDriverManager manager = new WebDriverManager();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(0, null)
		driver.get("https://www.w3schools.com/html/default.asp");
		
		list = driver.findElements(By.xpath(".//*[@id='leftmenuinnerinner']/h2[1]/following-sibling::a"));
		
		for(int i=0; i<list.size(); i++) {			
			if(i!=0 && i/2==0) {
				continue;
			}
			else {
				System.out.println(list.get(i).getText());
			}
		}
	}

}
