package com.adam;

public class Main {

	public static void main(String[] args) {
		int[] array = { 10, 2, 19, 123, 23, 234,244, 54, 34, 52, 90};
		for (int end = array.length-1; end > 0 ; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin-1] = tmp;
				}

			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "_"); 
			
		}
	}

}
