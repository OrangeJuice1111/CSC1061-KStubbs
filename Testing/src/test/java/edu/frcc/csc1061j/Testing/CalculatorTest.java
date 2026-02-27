package edu.frcc.csc1061j.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	void setup() {
		calc = new Calculator();
	}

	@Test
	
	@DisplayName("Simple Addition")
	void testAdd() {
		assertEquals(10, calc.add(8 , 2), "Addition no worky!");
		
	}
	
	
	@Test
	@DisplayName ("Simple Multiplication")
	void testMultiplication() {
		assertEquals(20, calc.multiply(4, 5), "Multiplication no worky!");
		assertTrue(calc.multiply(3, 6) == 18, "Answer should be 18");
	}
	
	@Test
	@DisplayName ("Simple division")
	@Disabled("Not ready for prime time")
	void testDivide() {
		assertEquals(3.0, calc.divide(6,2), "Divide no Worky");
	}
	
	
}
