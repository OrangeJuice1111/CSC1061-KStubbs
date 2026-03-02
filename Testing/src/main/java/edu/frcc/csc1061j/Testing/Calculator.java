package edu.frcc.csc1061j.Testing;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int division(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Divide by 0");
		}
		return a / b;
	}
}
