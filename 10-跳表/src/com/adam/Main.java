package com.adam;

import java.util.TreeMap;

import com.adam.tools.Asserts;
import com.adam.tools.Times;

public class Main {

	public static void main(String[] args) {
		time();
	}

	private static void time() {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		SkipList<Integer, Integer> list = new SkipList<>();
		int count = 100_0000;

		int delta = 10;

		Times.test("SkipList", () -> {

			test(list, count, delta);
		});
		Times.test("TreeMap", () -> {

			test(map, count, delta);
		});
	}

	private static void test1() {
		SkipList<Integer, Integer> list = new SkipList<>();
		test(list, 100, 5);
		test(list, 20, 5);
	}

	private static void test(SkipList<Integer, Integer> list, int count, int delta) {

		for (int i = 0; i < count; i++) {
			list.put(i, i + delta);
		}
//		System.out.println(list);
		for (int i = 0; i < count; i++) {
			Asserts.test(list.get(i) == i + delta);
		}
		Asserts.test(list.size() == count);

		for (int i = 0; i < count; i++) {
			Asserts.test(list.remove(i) == i + delta);
		}
		Asserts.test(list.size() == 0);

	}

	private static void test(TreeMap<Integer, Integer> list, int count, int delta) {

		for (int i = 0; i < count; i++) {
			list.put(i, i + delta);
		}
//		System.out.println(list);    
		for (int i = 0; i < count; i++) {
			Asserts.test(list.get(i) == i + delta);
		}
		Asserts.test(list.size() == count);

		for (int i = 0; i < count; i++) {
			Asserts.test(list.remove(i) == i + delta);
		}
		Asserts.test(list.size() == 0);

	}

}
