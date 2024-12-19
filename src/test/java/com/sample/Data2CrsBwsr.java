package com.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class Data2CrsBwsr extends BaseClass{

	WebDriver driver;
	@Test
	@Parameters({"browsername"})
	private void tc1(String browsername) {
		
		browserLaunch(browsername);
		maxWindow();
		implicityWait();
		launchUrl("https://www.facebook.com/login/");
		WebElement username = findingElement("id","email" );
		sendText(username, "keerthanaangusamy@gmail.com");
		WebElement pass = findingElement("name","pass");
		sendText(pass, "hifriend");
		WebElement login = findingElement("id", "loginbutton");
		btnClick(login);
	}
	
}
