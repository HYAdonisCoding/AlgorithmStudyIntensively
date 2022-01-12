package com.adam;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(100));
	}

	private static int sum(int n) {
		if (n <= 1) {
			return n;
		}
		return n + sum(n - 1);
	}

}
