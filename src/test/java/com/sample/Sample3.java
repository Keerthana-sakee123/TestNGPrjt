package com.sample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample3 {
	@Test
	@Parameters({"username","password"})
	private void tc31(String email, String pass){
		System.out.println(email +" and "+ pass);		
	}
	@Test(groups= {"Reg"})
	private void tc32() {
		System.out.println("Test32");
	}
	@Test(groups= {"Reg"})
	private void tc33() {
		System.out.println("Test33");
	}
	@Test(groups= {"Smoke"})
	private void test23() {
		System.out.println("Test23");
	}
	@Test(groups= {"Smoke"})
	private void test22() {
		System.out.println("Test22");
	}
	@Test(groups= {"Sanity"})
	private void test24() {
		System.out.println("Test24");
	}
	@Test(groups= {"Sanity"})
	private void test25() {
		System.out.println("Test25");
	}
	}
