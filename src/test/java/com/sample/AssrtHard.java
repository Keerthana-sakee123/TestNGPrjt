package com.sample;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class AssrtHard extends BaseClass{
	@Test
	private void testCase() {
		WebDriver driver;
		browserLaunch("Chrome");
		launchUrl("https://www.facebook.com/");
		String expected="Facebook – log in or sign up";
		String title = urlTitle();
		//Assert.assertNotEquals(expected, title);
		//Assert.assertEquals(expected, title);
		
		//When test case is failed it will print the "" statement
		//Assert.assertEquals(expected, title, "Failed test case");
		
		//Assert.assertTrue(true);//pass
		//Assert.assertTrue(false);//fail
		
		//Assert.assertTrue(1==1);//pass
		
		//Assert.assertFalse(false); //passed
		Assert.assertFalse(true);//fail
		System.out.println(title);
		
	}
				
}
