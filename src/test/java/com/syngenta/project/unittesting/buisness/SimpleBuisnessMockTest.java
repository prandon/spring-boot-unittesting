package com.syngenta.project.unittesting.buisness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.syngenta.project.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBuisnessMockTest {
	
	@InjectMocks
	private SimpleBuisnessImpl simpleBuisnessImpl;
	
	@Mock
	private SomeDataService someDataServiceMock;
	
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(someDataServiceMock.getData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, simpleBuisnessImpl.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(someDataServiceMock.getData()).thenReturn(new int[] {});
		assertEquals(0, simpleBuisnessImpl.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_single() {
		when(someDataServiceMock.getData()).thenReturn(new int[] {1});
		assertEquals(1, simpleBuisnessImpl.calculateSumUsingDataService());
	}
}
