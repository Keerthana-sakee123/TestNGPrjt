package com.sample;

import org.testng.annotations.Test;

public class Sample1 {
	@Test
	private void tc1(){
		System.out.println("TC1----> ThreadId: "+Thread.currentThread().getId());		
	}
	@Test
	private void tc2() {
		System.out.println("TC2---> ThreadId: "+Thread.currentThread().getId());
	}
}
