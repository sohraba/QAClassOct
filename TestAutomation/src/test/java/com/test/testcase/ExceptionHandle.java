package com.test.testcase;

public class ExceptionHandle {
	public static void main(String args[] ){
		devide(10, 0);
	}
	public static void devide(int a,int b) {
		try {
		int devide=a/b;
		System.out.println(devide);
		}
//		catch(ArithmeticException ex) {
//			System.out.println(ex.getMessage());
//		}
		finally {
			System.out.println("Finally");
		}
		int sub=a-b;
		System.out.println(sub);
	}

}
