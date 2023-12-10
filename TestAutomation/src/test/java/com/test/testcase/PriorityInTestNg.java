package com.test.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.Test;

public class PriorityInTestNg {
	@Test(timeOut = 500)
	public void b_test() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		System.out.println("b test");
	}
	@Test(enabled=false)
	public void d_test() {
		System.out.println("d test");
	}
	@Test(enabled=false)
	public void e_test() {
		System.out.println("e test");
	}
	
}
