package com.adam;

public class TailCall {
	public static void main(String[] args) {

//		new TailCall().test1(5);
//		new TailCall().test2(5);

		System.out.println(facettorial(4));
	}

	static int facettorial(int n) {

		return facettorial(n, 1);
	}

	static int facettorial(int n, int result) {
		if (n <= 1) {
			return result;
		}
		return facettorial(n - 1, result * n);
	}

//	static int facettorial1(int n) {
//		if (n <= 1) {
//			return n;
//		}
//		return n * facettorial1(n - 1);
//	}
//	void test1() {
//
//		int a = 10;
//		int b = a + 10;
//		test2(b);
//	}
//
//	void test2(int b) {
//
//	}
//} 

	void test1(int n) {
		if (n < 0) {
			return;
		}
		System.out.println("test - " + n);
		test1(n - 1);
	}

	void test2(int n) {
		if (n < 0) {
			return;
		}
		while (n >= 0) {
			System.out.println("test - " + n);
			n--;
		}

	}

}