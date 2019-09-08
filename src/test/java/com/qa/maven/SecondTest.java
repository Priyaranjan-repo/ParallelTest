package com.qa.maven;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SecondTest {

	@Test
	@Parameters({ "username", "password" })
	public void website(String username, String password) {
		try {
			FirstTest.driver.manage().window().maximize();
			FirstTest.driver.get("https://www.website.com/sign-in/");
			FirstTest.driver.findElement(By.id("username")).sendKeys(username);
			FirstTest.driver.findElement(By.id("password")).sendKeys(password);
			System.out.println("Title: " + FirstTest.driver.getTitle());
			Assert.assertTrue(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			FirstTest.driver.quit();
		}
	}

}
