package com.adam;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		test1();
	}

	/**
	 * 海盗装载
	 */
	static void test1() {
		int[] weights = { 3, 5, 4, 10, 7, 14, 2, 11 };
		Arrays.sort(weights);
		int capacity = 30, weight = 0, count = 0;

		for (int i = 0; i < weights.length && weight < capacity; i++) {

			int newWeight = weight + weights[i];
			if (newWeight <= capacity) {
				System.out.println(weights[i]);
				// 可以装载
				weight = newWeight;
				count++;
			}
		}
		System.out.println("一共选了" + count + "件古董, " + "总计：" + weight);

	}

}
