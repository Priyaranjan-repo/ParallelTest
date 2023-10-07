package com.qa.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTest {
	public static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");

	}

	@Test
	@Parameters({ "username", "password" })
	public void facebook(String username, String password) {
		try {
			driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id=\"pass\"]")).clear();
			driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
			Thread.sleep(3000);
			System.out.println("Title: " + driver.getTitle());
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
