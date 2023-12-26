package com.simplilearn.tdd;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	@BeforeEach
	public void setup() {
		String driverpath="drivers/windows/geckodriver.exe";
		System.setProperty("webdriver.geckodriver.driver", driverpath);
		driver=new FirefoxDriver();
	}
	@AfterEach
	public void cleanup() {
		driver.quit();
	}
	@RepeatedTest(2)
	@Test
	@DisplayName("Search engine should testing the searching test")
	public void searchTest() throws InterruptedException {
		driver.get("https://www.google.com");
		 String searchTerm = "Selenium WebDriver";
		 
	        driver.findElement(By.name("q")).sendKeys(searchTerm);
	        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        List<WebElement> searchResults = driver.findElements(By.id("rso"));
	        
	        Assertions.assertTrue(searchResults.size() > 0);
	       
	        Assertions.assertTrue(searchResults.get(0).getText().contains(searchTerm));
		
	}
	@Test
	public void searchTest2() throws InterruptedException {
		driver.get("https://www.google.com");
		 String searchTerm = "Junit";
		 
	        driver.findElement(By.name("q")).sendKeys(searchTerm);
	        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        List<WebElement> searchResults = driver.findElements(By.id("rso"));
	       
	        Assertions.assertTrue(searchResults.size() > 0);
	       
		
	}
	@Test
	public void searchTest3() throws InterruptedException {
		driver.get("https://www.google.com");
		 String searchTerm = "Assertion";
		 
	        driver.findElement(By.name("q")).sendKeys(searchTerm);
	        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g"));
	        
	        Assertions.assertTrue(searchResults.size() > 0);
	        Assertions.assertTrue(searchResults.get(0).getText().contains(searchTerm));
		
	}
	@Test
    public void testGoogleImagesSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.linkText("Images")).click();
        
        // Assuming the user performs an image search and validates results
        String searchTerm = "Nature";
        driver.findElement(By.name("q")).sendKeys(searchTerm);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> imageResults = driver.findElements(By.id("islrg"));
        Assertions.assertTrue(imageResults.size()>0);
       
        Assertions.assertTrue(imageResults.get(0).getText().contains(searchTerm));
    }
}
