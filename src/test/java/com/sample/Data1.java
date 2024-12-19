package com.sample;

import org.testng.annotations.Test;

public class Data1 {

	@Test
	private void test1() {
	System.out.println("Test1-->threadId:"+Thread.currentThread().getId());
}
	@Test
	private void test2() {
	System.out.println("Test2-->threadId:"+Thread.currentThread().getId());
}
}
