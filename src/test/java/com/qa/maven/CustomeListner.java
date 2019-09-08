package com.qa.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomeListner extends TestListenerAdapter {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Execution Start: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Execution Failed: " + tr.getName());
			File screenShot = ((TakesScreenshot) FirstTest.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("..//MavenParallel/target/" + tr.getName() + "_failed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		try {
			System.out.println("Execution Success: " + tr.getName());
			File screenShot = ((TakesScreenshot) FirstTest.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("..//MavenParallel/target/" + tr.getName() + "_passed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
