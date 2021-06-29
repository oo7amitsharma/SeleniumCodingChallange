package com.imdb.search.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.search.imdb.base.Base;

public class IMDbHomePage extends Base{
	
	@FindBy(xpath = ".//input[@id='suggestion-search']")
	WebElement inputSearchBox;
	
	@FindBy(xpath=".//button[@id='suggestion-search-button']")
	WebElement searchButton;
	
	@FindBy(xpath=".//a[text()=\"Movie\"]")
	WebElement movieLinkUnderCategorySearch;
	
	@FindBy(xpath=".//tbody/tr/td[@class='result_text']/a")
	List<WebElement> listOfMovieTitle;
	
	
	//Initializing the Page Objects:
	public IMDbHomePage(){
		PageFactory.initElements(driver, this);
	}

	public void serachForMovie(String searchMovie) {
		inputSearchBox.click();
		inputSearchBox.sendKeys(searchMovie);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnMovieLinkUnderCategory() {
		movieLinkUnderCategorySearch.click();
	}
	public List<String> getTitleDetails() {
	List<String> titleList = new ArrayList<String>();
	for(int j=0;j<listOfMovieTitle.size();j++) {
		titleList.add(listOfMovieTitle.get(j).getText()); 
	}
	return titleList;
	}
	
	

}
