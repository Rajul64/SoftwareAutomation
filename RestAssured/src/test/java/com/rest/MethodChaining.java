package com.rest;

public class MethodChaining {
	
	public static void main(String[]args)
	{
//		MethodChaining mc = new MethodChaining();
//		mc.method_a1().method_a2().method_a3();
		method_a1().
		method_a2().
		method_a3();
	}
	
	
	
	public static MethodChaining method_a1()
	{
		System.out.println("Method a1");
		return new MethodChaining();
	}
	
	public MethodChaining method_a2()
	{
		System.out.println("Method a2");
		return this;
	}
	
	public MethodChaining method_a3()
	{
		System.out.println("Method a3");
		return this;
	}

}
