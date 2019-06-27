package com.syngenta.project.unittesting.buisness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.syngenta.project.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] getData() {
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceStubOne implements SomeDataService{

	@Override
	public int[] getData() {
		return new int[] {1};
	}
	
}

class SomeDataServiceStubEmpty implements SomeDataService{

	@Override
	public int[] getData() {
		return new int[] {};
	}
	
}
public class SimpleBuisnessStubTest {
	private SimpleBuisnessImpl simpleBuisnessImpl = new SimpleBuisnessImpl();
	
	public SimpleBuisnessStubTest() {
		
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		simpleBuisnessImpl.setSomeDataService(new SomeDataServiceStub());
		int actualResult = simpleBuisnessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		simpleBuisnessImpl.setSomeDataService(new SomeDataServiceStubEmpty());
		int actualResult = simpleBuisnessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_single() {
		simpleBuisnessImpl.setSomeDataService(new SomeDataServiceStubOne());
		int actualResult = simpleBuisnessImpl.calculateSumUsingDataService();
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
}
