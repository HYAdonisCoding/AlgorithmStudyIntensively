package com.adam;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {

	public static void main(String[] args) {
//		coinChange1();

		Integer[] faces = { 25, 10, 5, 1 };

		coinChange3(faces, 41);
		// error 20 + 20 + 1 -> 3枚
		coinChange3(new Integer[] { 25, 20, 5, 1 }, 41);
	}

	/**
	 * 零钱兑换
	 */
	static void coinChange3(Integer[] faces, int money) {
		Arrays.sort(faces);
		int coins = 0, idx = faces.length - 1;
		while (idx >= 0) {
			while (money >= faces[idx]) {
				money -= faces[idx];
				coins++;
				System.out.println(faces[idx] + "元硬币");
			}
			idx--;
		}
		System.out.println("共需要枚" + coins + "硬币");
	}

	/**
	 * 零钱兑换
	 */
	static void coinChange2(Integer[] faces, int money) {

		Arrays.sort(faces, (Comparator<Integer>) (Integer f1, Integer f2) -> f2 - f1);

		int coins = 0, i = 0;
		while (i < faces.length) {
			if (money < faces[i]) {
				i++;
				continue;
			}
			money -= faces[i];
			System.out.println(faces[i]);
			coins++;
		}
		System.out.println("共需要枚" + coins + "硬币");

	}

	/**
	 * 零钱兑换
	 */
	static void coinChange1() {
		Integer[] faces = { 25, 10, 5, 1 };
		Arrays.sort(faces, (Comparator<Integer>) (Integer f1, Integer f2) -> f2 - f1);

		int money = 41, coins = 0, i = 0;
		while (i < faces.length) {
			if (money < faces[i]) {
				i++;
				continue;
			}
			money -= faces[i];
			System.out.println(faces[i]);
			coins++;
		}
		System.out.println("共需要枚" + coins + "硬币");

	}

	/**
	 * 零钱兑换
	 */
	static void coinChange() {
		int[] faces = { 25, 10, 5, 1 };
		Arrays.sort(faces);
		int money = 41, coins = 0;
		for (int i = faces.length - 1; i >= 0; i--) {
			if (money < faces[i]) {
				continue;
			}
			money -= faces[i];
			System.out.println(faces[i]);
			coins++;
			i = faces.length;

		}
		System.out.println("共需要枚" + coins + "硬币");
	}
}
