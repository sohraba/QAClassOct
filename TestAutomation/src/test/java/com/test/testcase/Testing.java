package com.test.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testing {
	public static void main(String args[])
	{
		//reverse();
		List<String> result=fizzBuzz(5);
		for(String s:result) {
			System.out.print(s+"");
		}
	}

	static void reverse(){
        @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
}
	public static List<String> fizzBuzz(int n){
        ArrayList<String> result=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                result.add("FizzBuzz");
            }
            else if(i%3==0){
                result.add("Fizz");
            }
            else if(i%5==0){
                result.add("Buzz");
            }
            else{
                result.add(Integer.toString(i));
            }
        }
        return result;
        
    }
}
