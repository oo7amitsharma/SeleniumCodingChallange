package com.search.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCodingChallangeDay1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
		String wroldPopulation="";
		String brithsToday="";
		String deathToday="";
		String populationGrowthToday="";
		int retry=5;
		int j=1;
		long t= System.currentTimeMillis();
		long end = t+15000;
		while(System.currentTimeMillis() < end) {
			System.out.println("**************************************");
			System.out.println("********Pass "+j+"*************");
			System.out.println("**************************************");
			//Below piece of code is to get the Current World Population value

			for(int i=0; i<retry; i++) {
				//Thread.sleep(2000);
				    try {
				    	wroldPopulation="";
				    	List<WebElement> crntWorldPop= driver.findElements(By.xpath("//span[@rel=\"current_population\"]/span"));
				    	for(WebElement wroldPop : crntWorldPop) {
							wroldPopulation+=wroldPop.getText();
				        }
				    	break;
				    } catch (StaleElementReferenceException e) {
				    	
				        }
				    }
			//Below piece of code is to get Births today details
			 for(int i=0; i<retry; i++) {
				//Thread.sleep(2000);
					try {
				    	brithsToday="";
				    	String part1=driver.findElement(By.xpath("//span[@rel=\"births_today\"]/span[2]")).getText();
				    	String part2=driver.findElement(By.xpath("//span[@rel=\"births_today\"]/span[3]")).getText();
				    	String part3=driver.findElement(By.xpath("//span[@rel=\"births_today\"]/span[4]")).getText();
				    	brithsToday=part1+part2+part3;

				    	//driver.findElement(By.xpath("//span[@rel=\"births_today\"]/span[2]")).getText();
//				    	List<WebElement> birthsToday= driver.findElements(By.xpath("//span[@rel=\"births_today\"]/span"));
//				    	for(WebElement births : birthsToday) {	
//				    		
//				    		brithsToday+=births.getText();
//				            }
				    	break;
					    }
				    	catch (StaleElementReferenceException e) {
					    	
				        }
			 }
			 
				//Below piece of code is to get Deaths today details
			 for(int i=0; i<retry; i++) {
				//Thread.sleep(2000);
					try {
				    	deathToday="";
				    	String part1=driver.findElement(By.xpath("//span[@rel=\"dth1s_today\"]/span[2]")).getText();
				    	String part2=driver.findElement(By.xpath("//span[@rel=\"dth1s_today\"]/span[3]")).getText();
				    	String part3=driver.findElement(By.xpath("//span[@rel=\"dth1s_today\"]/span[4]")).getText();
				    	deathToday=part1+part2+part3;

				    	break;
					    }
				    	catch (StaleElementReferenceException e) {
					    	
				        }
			 }
			 
				//Below piece of code is to get Population Growth today details
			 for(int i=0; i<retry; i++) {
				//Thread.sleep(2000);
					try {
						populationGrowthToday="";
				    	String part1=driver.findElement(By.xpath("//span[@rel=\"absolute_growth\"]/span[2]")).getText();
				    	String part2=driver.findElement(By.xpath("//span[@rel=\"absolute_growth\"]/span[3]")).getText();
				    	String part3=driver.findElement(By.xpath("//span[@rel=\"absolute_growth\"]/span[4]")).getText();
				    	populationGrowthToday=part1+part2+part3;

				    	break;
					    }
				    	catch (StaleElementReferenceException e) {
					    	
				        }
			 }
			
			j++;
				    System.out.println("Wrold Population :"+wroldPopulation);
				    System.out.println("Birth Today :"+brithsToday);
				    System.out.println("Deatch Today :"+deathToday);
				    System.out.println("Population Growth Today :"+populationGrowthToday);
				    System.out.println("**************************************");
			}
		driver.close();
		}
		

}
