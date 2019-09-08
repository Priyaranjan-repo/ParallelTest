package com.qa.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	public static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");

	}

	@Test
	@Parameters({ "username", "password" })
	public void facebook(String username, String password) {
		try {
			driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
			System.out.println("Title: " + driver.getTitle());
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
