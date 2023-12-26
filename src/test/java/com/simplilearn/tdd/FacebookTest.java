package com.simplilearn.tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FacebookTest {
	private WebDriver driver;
	@BeforeEach
	public void setup() throws InterruptedException {
		String driverpath="drivers/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		Thread.sleep(2000);
		
	}
	@AfterEach
	public void cleanup() {
		driver.quit();
	}
	@RepeatedTest(3)
	@Test
	@DisplayName("Test the facebook login")
	public void test1() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("invalid_email@example.com");
        driver.findElement(By.id("pass")).sendKeys("invalid_password");
        driver.findElement(By.name("login")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]"));
        Assertions.assertTrue(errorMessage.isDisplayed());
        Assertions.assertEquals("The email address you entered isn't connected to an account. Find your account and log in.", errorMessage.getText());
	}
    

}
