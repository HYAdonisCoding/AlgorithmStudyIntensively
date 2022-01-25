package com.adam;

public class LCSubstring {

	public static void main(String[] args) {
		System.out.println(longestCS1("ABCDA", "BABCA"));
	}

	/**
	 * 最长公共子串（Longest Common Substring） 一维数组
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	private static int longestCS1(String text1, String text2) {
		if (text1 == null || text2 == null)
			return 0;
		char[] chars1 = text1.toCharArray();
		if (chars1.length == 0)
			return 0;
		char[] chars2 = text2.toCharArray();
		if (chars2.length == 0)
			return 0;
		char[] rowsNums = chars1, colsNums = chars2;
		if (chars1.length < chars2.length) {
			colsNums = chars1;
			rowsNums = chars2;
		}
		int[] dp = new int[colsNums.length + 1];
		int max = 0;
		for (int row = 1; row <= rowsNums.length; row++) {
			int cur = 0;
			for (int col = 1; col <= colsNums.length; col++) {
				int leftTop = cur;
				cur = dp[col];
				if (rowsNums[row - 1] != colsNums[col - 1]) {
					dp[col] = 0;
				} else {
					dp[col] = leftTop + 1;
					max = Math.max(max, dp[col]);
				}

			}
		}
		return max;
	}

	/**
	 * 最长公共子串（Longest Common Substring） 二维数组
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	private static int longestCS(String text1, String text2) {
		if (text1 == null || text2 == null)
			return 0;
		char[] chars1 = text1.toCharArray();
		if (chars1.length == 0)
			return 0;
		char[] chars2 = text2.toCharArray();
		if (chars2.length == 0)
			return 0;
		char[] rowsNums = chars1, colsNums = chars2;
		if (chars1.length < chars2.length) {
			colsNums = chars1;
			rowsNums = chars2;
		}
		int[][] dp = new int[rowsNums.length + 1][colsNums.length + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= rowsNums.length; i++) {
			for (int j = 1; j <= colsNums.length; j++) {
				if (rowsNums[i - 1] != colsNums[j - 1])
					continue;
				dp[i][j] = dp[i - 1][j - 1] + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
