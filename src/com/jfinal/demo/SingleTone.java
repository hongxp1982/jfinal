package com.jfinal.demo;

public class SingleTone {

	private static SingleTone sin = new SingleTone();

	public static int counter1;
	public static int counter2 = 0;

	private SingleTone() {
		counter1++;
		counter2++;
	}

	public static SingleTone getInstance() {
		return sin;
	}

	public static void main(String[] args) {

	}
}