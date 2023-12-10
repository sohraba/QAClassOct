package com.test.learning;

public class ExcpetionHandling {
	public static void main(String args[]) {
		try {
			func(0);
		} catch (Exception e) {
			System.out.print("In catch Block");
			e.printStackTrace();
		}
		
	}
	static void func(int a) throws Exception {
		   System.out.println(10/a);  
	}
	
	public static void arithmeticOperation(int a,int b) {
		try {
		int devide=a/b;
		System.out.println("Devision"+devide);
		}
		catch(Exception ex) {
			ex.printStackTrace();		
		}
		finally {
			
		}

		int multiplication=a*b;
		int sub=a-b;
		int add=a+b;
		System.out.println("multiplication"+multiplication);	
		System.out.println("sub"+sub);	
		System.out.println("add:: "+add);	
}
	
	public static void devide(int a,int b) {
		try {
		      int divideByZero = 5 / 0;
		      System.out.println("Rest of code in try block");
		}
		    catch (ArithmeticException e) {
		      System.out.println("ArithmeticException => " + e.getMessage());
		    }
		  
	finally {
	      System.out.println("This is the finally block");
	    }
	}
	
	static void canVote(int age){
		if(age<18)
            try{
            	throw new Exception();
            }catch(Exception e){
            	e.printStackTrace();
                System.out.println("you are not an adult!");
            }
		else
		   System.out.println("you can vote!");
	}

}
