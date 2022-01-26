package com.adam;

@SuppressWarnings("unused")
public class LIS {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS2(new int[] { 10, 2, 2, 5, 1, 7, 101, 18 }));
	}

	/**
	 * 再次优化 二分查找的优化 思路（假设数组是 nums，也就是最初的牌数组） top[i] 是第 i 个牌堆的牌顶，len 是牌堆的数量，初始值为 0
	 * 遍历每一张牌 num ✓ 利用二分搜索找出 num 最终要放入的牌堆位置 index ✓ num 作为第 index 个牌堆的牌顶，top[index]
	 * = num ✓ 如果 index 等于 len，相当于新建一个牌堆，牌堆数量 +1，也就是 len++
	 * 
	 * @param nums
	 * @return
	 */
	private static int lengthOfLIS2(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		// 牌堆的数组
		int[] top = new int[nums.length];
		// 牌堆的数量
		int len = 0;
		// 遍历所有的牌
		for (int num : nums) {
			int end = len;
			int begin = 0;
			while (begin < end) {
				int mid = (begin + end) >> 1;
				if (num <= top[mid]) {
					end = mid;
				} else {
					begin = mid + 1;
				}
			}
			// 覆盖牌顶 
			top[begin] = num;
			if (begin == len) // 新建一个牌堆
				len++;
		}

		return len;
	}

	/**
	 * 二分查找的优化 思路（假设数组是 nums，也就是最初的牌数组） top[i] 是第 i 个牌堆的牌顶，len 是牌堆的数量，初始值为 0 遍历每一张牌
	 * num ✓ 利用二分搜索找出 num 最终要放入的牌堆位置 index ✓ num 作为第 index 个牌堆的牌顶，top[index] = num ✓
	 * 如果 index 等于 len，相当于新建一个牌堆，牌堆数量 +1，也就是 len++
	 * 
	 * @param nums
	 * @return
	 */
	private static int lengthOfLIS1(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		// 牌堆的数组
		int[] top = new int[nums.length];
		// 牌堆的数量
		int len = 0;

		for (int num : nums) {
			int j = 0;
			while (j < len) {
				// 找到一个>=num的牌顶
				if (top[j] >= num) {
					top[j] = num;
					break;
				}
				j++;
			}
			// 牌顶< num
			if (j == len) {// 新建一个牌堆
				len++;
				top[j] = num;
			}

		}

		return len;
	}

	/**
	 * 动态规划
	 * 
	 * @param nums
	 * @return
	 */
	private static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int[] dp = new int[nums.length];

		int max = dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] <= nums[j])
					continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);

			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

}
