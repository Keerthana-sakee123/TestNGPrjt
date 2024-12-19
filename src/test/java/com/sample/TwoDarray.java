package com.sample;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class TwoDarray extends BaseClass{
public static void main(String[] args) {
	System.out.println("Two Dimensional Array");
	int a[][]= {{10,11},{12,20},{13,17},{34,56},{21,47}};
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[i].length; j++) {
			System.out.println(a[i][j]);
			
		}
		}
	System.out.println("for each loop");
	for (int[] ar : a) {
		for (int c : ar) {
			System.out.println(c);
		}
		
	}
	System.out.println("Array");
	int b[]= {10,12,13,15,78,52};
	for (int i = 0; i < b.length; i++) {
		System.out.println(b[i]);
	}
	System.out.println("for each");
	for (int i : b) {
		System.out.println(i);
	}
	
	
}
@DataProvider(name="testdata", indices= {0,1})
private String[][] testData() {
		String data[][]= {{"keerthanaangusamy@gmail.com", "keerthi"},
				{"ram@gmail.com","ram"},
				{"raju@gmail.com","raju"}};
		return data;
		}
@Test(dataProvider="testdata")
private void tc1(String email, String password) {
	
	browserLaunch("Chrome");
	maxWindow();
	implicityWait();
	launchUrl("https://www.facebook.com/login/");
	WebElement username = findingElement("id","email" );
	sendText(username, email);
	WebElement pass = findingElement("name","pass");
	sendText(pass, password);
	WebElement login = findingElement("id", "loginbutton");
	btnClick(login);
}
}
