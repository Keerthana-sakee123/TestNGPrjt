package com.sample;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class Sample2 extends BaseClass {
	WebDriver driver;
	
	@Test
	private void testCase() {
		browserLaunch("Chrome");
		maxWindow();
		launchUrl("https://www.facebook.com/");
		String expected="Facebook – log in or sign up";
		String title = urlTitle();
		System.out.println(title);
		Assert.assertEquals(expected,title );
		closeWindow();		
	}
}
