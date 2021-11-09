package com.adam;

import com.adam.tools.Integers;

public class Main {
	static void bubbleSort1(Integer[] array) {
		for (int end = array.length-1; end > 0 ; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin-1] = tmp;
				}
			}
		}
	}
	
	static void bubbleSort2(Integer[] array) {
		for (int end = array.length-1; end > 0 ; end--) {
			boolean sorted = true;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin-1] = tmp;
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
		}
	}
	static void bubbleSort3(Integer[] array) {
		for (int end = array.length-1; end > 0 ; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin-1] = tmp;
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}

	public static void main(String[] args) {
//		Integer[] array1 = Integers.random(10000, 1, 100000);
		Integer[] array1 = Integers.ascOrder(1, 10000);
		Integer[] array2 = Integers.copy(array1);
		Integer[] array3 = Integers.copy(array1);
//		Integers.print(array3);
		
		Times.test("冒泡排序1", () -> {
			
			bubbleSort1(array1);
		});
		
		Times.test("冒泡排序2", () -> {
			
			bubbleSort2(array2);
		});
		Times.test("冒泡排序3", () -> {
			
			bubbleSort3(array3);
		});
	}

}
