package com.search.testcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCodingChallangeDay2 {
	static WebDriver driver;
	static WebElement searchText;
	static WebElement nextArrowButton;
	static WebElement getItemList;
	
	@Test
	public void SeleniumCoding() throws InterruptedException {
		// TODO Auto-generated method stub
		String[] carouselList = {"Trending deals", "Top picks in mobiles"};
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		boolean flag = true;
		List<String> getDetails = new ArrayList<String>();
		for(String carousel : carouselList) {
				flag = true;
				while(flag) {
					try {
						System.out.println("Scroll down for :"+carousel);
						searchText = driver.findElement(By.xpath("//h3[text()=\""+carousel+"\"]"));				
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchText);
						flag=false;
					} 
					catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)", "");
					}	
				}	
				List<WebElement> list = driver.findElements(By.xpath("//h3[text()=\""+carousel+"\"]/ancestor::div[2]/following-sibling::div/div/div/div/div/a/div/div[2]/div"));
				nextArrowButton = driver.findElement(By.xpath("//h3[text()=\""+carousel+"\"]/ancestor::div[2]/following-sibling::div/div/following-sibling::div[contains(@class,\"swiper-button-next\")]"));
				List temp = getCarouselData(list, nextArrowButton);
				getDetails.addAll(temp);
		  }
		Collections.sort(getDetails);   
		for(String sortedList : getDetails) {
			System.out.println(sortedList);
		}
		driver.quit();
	}
	public static List<String> getCarouselData(List<WebElement> searchText, WebElement nextArrowButton) {
		List data = new ArrayList();
		System.out.println(searchText.size());		
		for(WebElement element2 : searchText) {
			if(element2.isDisplayed()) {
				data.add(element2.getText());
			}
			else if(!element2.isDisplayed() && nextArrowButton.isDisplayed()) {				
					nextArrowButton.click();
			}	
		}
		return data;	
	}
}
