package spe.dev.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CalculatorServiceTest {
	
	private CalculatorService calculatorService;	
	
	public CalculatorServiceTest() {
		super();
		calculatorService = new CalculatorService();
	}

	@Test
	public void squareRootTest() {
		String a = "9";
		String b = calculatorService.squareRoot(a);
		assertEquals("3.0", b);
	}
	
	@Test
	public void factorialTest() {
		String a = "5";
		String b = calculatorService.factorial(a);
		assertEquals("120", b);
	}
	
	@Test
	public void natLogTest() {
		String a = "10";
		String b = calculatorService.natLog(a);
		assertEquals("2.302585092994046", b);
	}
	
	@Test
	public void powerTest() {
		String a = "9", c = "2";
		String b = calculatorService.power(a, c);
		assertEquals("81.0", b);
	}

}
