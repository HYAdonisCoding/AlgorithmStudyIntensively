package com.adam;

public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	private static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int dp = nums[0];
		System.out.println("dp[" + 0 + "] = " + dp);

		int max = dp;
		for (int i = 1; i < nums.length; i++) {
			int prve = dp;
			if (prve <= 0) {
				dp = nums[i];
			} else {
				dp = prve + nums[i];
			}
			max = Math.max(dp, max);
			System.out.println("dp[" + i + "] = " + dp);
		}

		return max;
	}

	private static int maxSubArray(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		System.out.println("dp[" + 0 + "] = " + dp[0]);

		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			int prve = dp[i - 1];
			if (prve <= 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = prve + nums[i];
			}
			max = Math.max(dp[i], max);
			System.out.println("dp[" + i + "] = " + dp[i]);
		}

		return max;
	}

}
