package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

public class SoftAssrt extends BaseClass {
	//before and after method will run everytime for each @test methods
	@BeforeMethod
	private void beforeMethod() {
		WebDriver driver;
		browserLaunch("Chrome");
	}
	@Test
	private void testCase() {
		
		launchUrl("https://www.facebook.com/");
		String expected="Facebook – log in or sign up";
		String title = urlTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expected, title,"**Method failed**");
		
		
		WebElement email = findingElement("id", "email");
		boolean displayed = email.isDisplayed();
		s.assertTrue(true);
		System.out.println("email");
		
		WebElement pass = findingElement("id", "pass");
		boolean displayed1 = email.isDisplayed();
		s.assertTrue(true);
		System.out.println("password");
		s.assertAll(); //compulsory give it it will give which assert failed in this method
}
	@AfterMethod
	private void afterMethod() {
		closeWindow();
	}
}