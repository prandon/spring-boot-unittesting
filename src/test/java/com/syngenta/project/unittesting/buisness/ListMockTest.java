package com.syngenta.project.unittesting.buisness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	@Test
	public void sizeBasicTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}

	@Test
	public void returnDifferentValues() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	public void returnWithParameters() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("Pranjal").thenReturn("Rasika");
		assertEquals("Pranjal", mockList.get(0));
		assertEquals("Rasika", mockList.get(0));
	}

	@Test
	public void returnWithGenericParameterTest() {
		List mockList = mock(List.class);

		// Argument Matcher
		when(mockList.get(anyInt())).thenReturn("Pranjal");

		assertEquals("Pranjal", mockList.get(0));
		assertEquals("Pranjal", mockList.get(10));
	}

	// test to verify if some method is called or not
	// important when value is not returned back, we can check weather a perticular
	// method is called or not
	@Test
	public void verifyIfMethodCalledOrNot() {
		List<String> mockStringList = mock(List.class);

		String value = mockStringList.get(0);
		String value2 = mockStringList.get(1);
		String value3 = mockStringList.get(1);

		// verify if called
		verify(mockStringList).get(0);
		verify(mockStringList, times(2)).get(1);
		verify(mockStringList, atLeastOnce()).get(anyInt());
		verify(mockStringList, atMost(3)).get(anyInt());

	}

	// argument capturing
	@Test
	public void argumentCaptureTest() {
		// System Under Test
		List<String> stringListMock = mock(List.class);
		stringListMock.add("Pranjal");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(stringListMock).add(captor.capture());

		assertEquals("Pranjal", captor.getValue());
	}

	// argument capturing
	@Test
	public void multipleArgumentCaptureTest() {
		// System Under Test
		List<String> stringListMock = mock(List.class);
		stringListMock.add("Pranjal");
		stringListMock.add("Rasika");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(stringListMock, times(2)).add(captor.capture());

		List<String> list = captor.getAllValues();
		assertEquals("Pranjal", list.get(0));
		assertEquals("Rasika", list.get(1));
	}
	
	@Test
	public void spyingTest() {
		//spy behaves like real object instance unlike mockito
		//but we can override the real behavior of the spy
		
		ArrayList<String> spyList = spy(ArrayList.class);
		spyList.add("Pranjal");
		spyList.add("Rasika");
		assertEquals(2, spyList.size());
		
		//we can override as follows
		when(spyList.size()).thenReturn(10);
		assertEquals(10, spyList.size());
	}
}
