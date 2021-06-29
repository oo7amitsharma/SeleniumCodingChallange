package com.search.testcases;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.imdb.search.pages.IMDbHomePage;
import com.search.imdb.base.Base;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SearchMovieFunctionality extends Base {
	
	IMDbHomePage homepage;
	List<Map<String, String>> filterResponse = new ArrayList<Map<String, String>>();
	Map<String, String> map = new HashMap<>();
    String[] str = {configProp.getProperty("title1"), configProp.getProperty("title2"), configProp.getProperty("title3")};
    List<String> getTitlefromWeb = new ArrayList<String>();
    
   
	
	public SearchMovieFunctionality() {
		super();
	}
	
	@BeforeClass
	public void getData() {
	    RestAssured.baseURI = "http://www.omdbapi.com/";
		RestAssured.basePath ="?apikey="+configProp.getProperty("apikey")+"&type="+configProp.getProperty("type")+"&s="+configProp.getProperty("s")+"";
	}
	
	@Test(priority=1)
	public void getFilterAPIResponse() {
		Response response = 
				given()
				.when()
					.get(baseURI+basePath);
		List<Map<String, String>> movieList = response.jsonPath().getList("Search");
		for(String s1 : str) {
		for(int i=0; i<movieList.size();i++) {
			if(movieList.get(i).get("Title").contains(s1)){
				map=movieList.get(i);
				filterResponse.add(map);
			}
		}
		}
	}
	
	
	
	@Test(priority=2)
	public void getAllTitlesfromWeb() {
		
		Base.initialization();
		homepage=new IMDbHomePage();
		homepage.serachForMovie(configProp.getProperty("s"));
		homepage.clickOnSearchButton();
		homepage.clickOnMovieLinkUnderCategory();
		getTitlefromWeb=homepage.getTitleDetails();

	}
	@Test(priority=3)
	public void verifyApiResponseWithWebResult() {
		
		for(int i=0; i<filterResponse.size(); i++) {
			for(int j=0; j<getTitlefromWeb.size();j++) {
				if(filterResponse.get(i).get("Title").equals(getTitlefromWeb.get(j))) {
					System.out.println("***************************");
					System.out.println("         ********          ");
					System.out.println("***************************");
					System.out.println("Api and Web Result Title gets Matched");
					System.out.println("API Result Title:"+filterResponse.get(i).get("Title"));
					System.out.println("Web Result Title:"+getTitlefromWeb.get(j));
				}

			}
		}
	}
	@AfterClass
	public void tearDown() {
		Base.finish();
	}

}
