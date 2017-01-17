package com.jfinal.demo;

public class TestInit {
	public static void main(String[] args) {
		System.err.println(Subclass.i);
		System.err.println(SuperClass.value);
	}

}

class SuperClass {
	static {
		System.err.println("super class init....");
	}

	public final static int value = 123;
}

class Subclass extends SuperClass {
	static {
		System.err.println("sub class init....");
	}

	public static int i = 3;
}
