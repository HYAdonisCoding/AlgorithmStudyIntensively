package com.adam;

import java.util.Arrays;

import com.adam.sort.CountingSort;
import com.adam.sort.Sort;
import com.adam.sort.cmp.BubbleSort3;
import com.adam.sort.cmp.HeapSort;
import com.adam.sort.cmp.InsertionSort3;
import com.adam.sort.cmp.MergeSort;
import com.adam.sort.cmp.QuickSort;
import com.adam.sort.cmp.SelectionSort;
import com.adam.sort.cmp.ShellSort;
import com.adam.tools.Asserts;
import com.adam.tools.Integers;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Main {
	static void bubbleSort1(Integer[] array) {

	}

	static void bubbleSort2(Integer[] array) {

	}

	static void bubbleSort3(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int tmp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = tmp;
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}

	static void test1() {
//		Integer[] array1 = Integers.random(10000, 1, 100000);
//		Integer[] array1 = Integers.ascOrder(1, 10000);
		Integer[] array1 = Integers.tailAscOrder(0, 10000, 2000);
		Integer[] array2 = Integers.copy(array1);
		Integer[] array3 = Integers.copy(array1);
//		Integer[] array4 = Integers.tailAscOrder(2, 10, 3);
//		Integers.print(array4);

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

	static void selectionSort1(Integer[] array) {

	}

	static void heapnSort(Integer[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (array[maxIndex] <= array[begin]) {
					maxIndex = begin;
				}
			}
			int tmp = array[maxIndex];
			array[maxIndex] = array[end];
			array[end] = tmp;
		}
	}

	static void test2() {

		Integer[] array1 = Integers.random(10000, 1, 20000);
//		Integer[] array1 = Integers.ascOrder(1, 10000);
//		Integer[] array1 = Integers.tailAscOrder(0, 10000, 2000);
		Integer[] array2 = Integers.copy(array1);
		Integer[] array3 = Integers.copy(array1);
//		Integer[] array4 = Integers.tailAscOrder(2, 10, 3);
//		Integers.print(array1);

		Times.test("HeapSort", () -> {

			new HeapSort().sort(array1);
			Asserts.test(Integers.isAscOrder(array1));

		});
		Times.test("SelectionSort", () -> {

			new SelectionSort().sort(array2);
			Asserts.test(Integers.isAscOrder(array2));

		});
		Times.test("BubbleSort3", () -> {

			new BubbleSort3().sort(array3);
			Asserts.test(Integers.isAscOrder(array2));

		});
	}

	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] data = Integers.copy(array);
			sort.sort(data);
			Asserts.test(Integers.isAscOrder(data));
		}
		Arrays.sort(sorts);
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}

	static void test3() {
		Integer[] array1 = Integers.random(30000, 1, 30000);
//		Integer[] array1 = { 7, 3, 5, 8, 6, 4, 5 };
		testSorts(array1, new QuickSort(), new CountingSort(),
//				new InsertionSort(),
				new MergeSort(),
//				new InsertionSort2(), 
				new ShellSort(),
//				new BubbleSort3(),
//				new SelectionSort(),
				new InsertionSort3(), new HeapSort());
	}

	static void test4() {
		int[] array = { 2, 4, 6, 8, 10 };
		Asserts.test(BinarySearch.indexOf(array, 4) == 1);
		Asserts.test(BinarySearch.indexOf(array, 2) == 0);
		Asserts.test(BinarySearch.indexOf(array, 10) == 4);
		Asserts.test(BinarySearch.indexOf(array, 40) == -1);
	}

	static void test5() {
		int[] array = { 2, 4, 8, 8, 8, 12, 14 };
		Asserts.test(BinarySearch.search(array, 1) == 0);
		Asserts.test(BinarySearch.search(array, 5) == 2);
		Asserts.test(BinarySearch.search(array, 8) == 5);
		Asserts.test(BinarySearch.search(array, 16) == 7);
//		Integer[] array = Integers.same(10, 0);
//		Integers.print(array);
//		Integers.reverse(array, 0, 10);
//		Integers.print(array);
	}

	static void test6() {
		/// 计数排序 自定义对象
		Person[] array = new Person[] { new Person(20, "A"), new Person(-13, "B"), new Person(17, "C"),
				new Person(12, "D"), new Person(-13, "E"), new Person(20, "F"), };

		// 找出最大值, 最小值
		int max = array[0].age, min = array[0].age;
		for (int i = 1; i < array.length; i++) {
			if (array[i].age > max) {
				max = array[i].age;
			}
			if (array[i].age < min) {
				min = array[i].age;
			}
		}
		/// 开辟内存空间
		int[] counts = new int[1 + max - min];
		// 统计每个整数出现次数
		for (int i = 0; i < array.length; i++) {
			counts[array[i].age - min]++;
		}
		// 累加次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		// 从后往前遍历,将它放到有序数组中的合适位置
		Person[] newArray = new Person[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			newArray[--counts[array[i].age - min]] = array[i];
		}
		/// 将有序数组 赋值到array
		for (int i = 0; i < newArray.length; i++) {
			array[i] = newArray[i];

			System.out.println(array[i]);
		}

	}

	public static void main(String[] args) {
//		test5();
//		test3();
		test6();

		System.out.println("完成");
	}

}
