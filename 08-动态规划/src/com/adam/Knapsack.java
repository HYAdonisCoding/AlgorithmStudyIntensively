package com.adam;

public class Knapsack {

	public static void main(String[] args) {
		int[] values = { 6, 3, 5, 4, 6 };
		int[] weights = { 2, 2, 6, 5, 4 };
		int capacity = 10;
		System.out.println(maxValueExactly(values, weights, capacity));
	}

	/**
	 * 背包刚好装满 优化一维数组
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return 返回-1则没法刚好凑够capacity这个容量
	 */
	private static int maxValueExactly(int[] values, int[] weights, int capacity) {
		if (values == null || values.length == 0)
			return 0;
		if (weights == null || weights.length == 0)
			return 0;
		if (weights.length != values.length || capacity <= 0)
			return 0;
		int[] dp = new int[capacity + 1];
		for (int j = 1; j < dp.length; j++) {
			dp[j] = Integer.MIN_VALUE;
		}
		for (int i = 1; i <= values.length; i++) {
			for (int j = capacity; j >= weights[i - 1]; j--) {
				dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);

			}
		}
		return dp[capacity] < 0 ? -1 : dp[capacity];

	}

	/**
	 * 优化一维数组
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	private static int maxValue2(int[] values, int[] weights, int capacity) {
		if (values == null || values.length == 0)
			return 0;
		if (weights == null || weights.length == 0)
			return 0;
		if (weights.length != values.length || capacity <= 0)
			return 0;
		int[] dp = new int[capacity + 1];
		for (int i = 1; i <= values.length; i++) {
			for (int j = capacity; j >= weights[i - 1]; j--) {
				dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);

			}
		}
		return dp[capacity];

	}

	/**
	 * 一维数组
	 * 
	 * @param values
	 * @param weights
	 * @param capacity
	 * @return
	 */
	private static int maxValue1(int[] values, int[] weights, int capacity) {
		if (values == null || values.length == 0)
			return 0;
		if (weights == null || weights.length == 0)
			return 0;
		if (weights.length != values.length || capacity <= 0)
			return 0;
		int[] dp = new int[capacity + 1];
		for (int i = 1; i <= values.length; i++) {
			for (int j = capacity; j >= weights[i - 1]; j--) {
				if (j < weights[i - 1])
					continue;

				dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);

			}
		}
		return dp[capacity];

	}

	private static int maxValue(int[] values, int[] weights, int capacity) {
		if (values == null || values.length == 0)
			return 0;
		if (weights == null || weights.length == 0)
			return 0;
		if (weights.length != values.length || capacity <= 0)
			return 0;
		int[][] dp = new int[weights.length + 1][capacity + 1];
		for (int i = 1; i <= values.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weights[i - 1]) {

					dp[i][j] = dp[i - 1][j];
				} else {

					dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
				}
			}
		}
		return dp[values.length][capacity];
	}
}
