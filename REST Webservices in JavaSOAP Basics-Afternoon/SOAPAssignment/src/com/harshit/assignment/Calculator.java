package com.harshit.assignment;

public class Calculator {
	public double sinOf(double value){
		double b = Math.toRadians(value);
		return Math.sin(b);
	}
	
	public double cosOf(double value){
		double b = Math.toRadians(value);
		return Math.cos(b);
	}
	
	public double tanOf(double value){
		double b = Math.toRadians(value);
		return Math.tan(b);
	}
	
	public double log2(double value){
		return  (Math.log(value) / Math.log(2));
	}
	
	public double logBase(double value,int base){
		return  (Math.log(value) / Math.log(base));
	}
	
	public int factorial(double number){
		int result=1;
		
		for(int i=1;i<number;i++)
			result*=i;
		return result;
	}
}
