package com.syngenta.project.unittesting.buisness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleBuisnessTest {

	@Test
	public void calculateSomeTest_basic() {
		SimpleBuisnessImpl simpleBuisnessImpl = new SimpleBuisnessImpl();
		int actualResult = simpleBuisnessImpl.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSomeTest_empty() {
		SimpleBuisnessImpl simpleBuisnessImpl = new SimpleBuisnessImpl();
		int actualResult = simpleBuisnessImpl.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSomeTest_single() {
		SimpleBuisnessImpl simpleBuisnessImpl = new SimpleBuisnessImpl();
		int actualResult = simpleBuisnessImpl.calculateSum(new int[] {1});
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
}
