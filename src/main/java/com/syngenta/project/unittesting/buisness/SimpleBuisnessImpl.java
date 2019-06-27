	package com.syngenta.project.unittesting.buisness;

import com.syngenta.project.unittesting.data.SomeDataService;

public class SimpleBuisnessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum = sum + value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.getData();
		for (int value : data) {
			sum = sum + value;
		}
		return sum;
	}
}
