package com.jfinal.demo;

public class Main {
	public static void main(String[] args) {
		int var1 = 10, var2 = 13;
		badSwap(var1, var2);
		System.out.println("var1: " + var1);
		
		SingleTone sin = SingleTone.getInstance();
		System.err.println("counter1: " + SingleTone.counter1);
		System.err.println("counter2: " + SingleTone.counter2);
	}

	public static void badSwap(int var1, int var2) {
		int temp = var1;
		var1 = var2;
		var2 = temp;
	}
}

