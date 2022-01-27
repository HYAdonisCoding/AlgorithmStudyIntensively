package com.adam;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		test3();
	}

	private static void test3() {

	}

	private static void test2() {
		// 数组
		String[] urlStrings = {};
		BloomFilter<String> bFilter = new BloomFilter<>(1_0000_0000, 0.01);
		for (String url : urlStrings) {
			if (bFilter.put(url) == false) {
				continue;
			}
			/// 爬这个url
			// .....
		}
//		for (String url : urlStrings) {
//			if (bFilter.contains(url)) {
//				continue;
//			}
//			/// 爬这个url
//			// .....
//
//			// 放进BloomFilter中
//			bFilter.put(url);
//		}
	}

	private static void test1() {
		BloomFilter<Integer> bFilter = new BloomFilter<>(1_0000_0000, 0.01);
		for (int i = 0; i < 1_0000_0000; i++) {

			bFilter.put(i);
		}
		int count = 0;
		for (int i = 1_0000_0000; i < 1_0000_0000; i++) {
			if (bFilter.contains(i))
				count++;

		}
//		bFilter.put("abc");
		System.out.println(count + ", p = " + count / 1_0000_0000);
	}
}
