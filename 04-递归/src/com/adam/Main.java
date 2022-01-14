package com.adam;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(sum(100));

		log1(4);
	}

	private static void log1(int n) {

		for (int i = 1; i <= n; i++) {
			System.out.println(i + 10);
		}

	}

	private static void log(int n) {

		if (n < 1) {
			return;
		}
		log(n - 1);
		int v = n + 10;
		System.out.println(v);
	}

	private static int sum(int n) {
		if (n <= 1) {
			return n;
		}
		return n + sum(n - 1);
	}

}
