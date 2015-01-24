package pl.bgora;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import pl.bgora.rpn.Calculator;
import pl.bgora.rpn.exceptions.RPNException;


public class CalculatorTest {
	
	private Calculator calc;

	@Before
	public void setUp() throws Exception {
		calc = Calculator.createDefaultCalculator();
	}

	@Test
	public void testCalculate() {
		BigDecimal result = null;
		try {
			result = calc.calculate("2^3*(12/6)+18/3+5.0/2");	
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("2^3*(12/6)+18/3+5.0/2", BigDecimal.valueOf(24.5), result);
	}
	
	@Test
	public void testMultiply(){
		BigDecimal result = null;
		try {
			result = calc.calculate("2*8");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("2*8",BigDecimal.valueOf(16), result);
	}
	
	@Test
	public void testPower(){
		BigDecimal result = null;
		try {
			result = calc.calculate("2^8");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("2^8", BigDecimal.valueOf(256), result);
	}
	
	@Test
	public void testAdd(){
		BigDecimal result = null;
		try {
			result = calc.calculate("2+8");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("2+8", BigDecimal.valueOf(10),  result);
	}
	
	@Test
	public void testSub(){
		BigDecimal result = null;
		try {
			result = calc.calculate("2-5");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("2-5", BigDecimal.valueOf(-3), result);
	}
	
	@Test
	public void testDiv(){
		BigDecimal result = null;
		try {
			result = calc.calculate("10.0/4");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals("10.0/4",BigDecimal.valueOf(2.5), result);
	}
	
	@Test
	public void testSinus(){
		BigDecimal result = null;
		try {
			result = calc.calculate("sin(2)");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals(BigDecimal.valueOf(Math.sin(2)), result);
	}
	

	@Test
	public void testSinusPlus(){
		BigDecimal result = null;
		try {
			result = calc.calculate("sin(1+1)");
		} catch (RPNException e) {
			e.printStackTrace();
		}
		assertEquals(BigDecimal.valueOf(Math.sin(1+1)), result);
	}
}
