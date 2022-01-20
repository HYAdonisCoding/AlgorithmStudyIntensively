package com.adam;

public class Main {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray2(nums);
		System.out.println(result);
	}

	static public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		return maxSubArray2(nums, 0, nums.length);

	}

	/**
	 * 求解【begin，end】最大连续子序列的和 T(n) = T(n/2) + T(n/2) + O(n)
	 * 
	 * @param nums
	 * @param begin
	 * @param end
	 * @return
	 */
	static public int maxSubArray2(int[] nums, int begin, int end) {
		if (end - begin < 2) {
			return nums[begin];
		}
		int mid = (begin + end) >> 1;
		int leftMax = nums[mid - 1];
		int leftSum = nums[mid - 1];
		for (int i = mid - 2; i >= begin; i--) {

			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}
		int rightMax = nums[mid], rightSum = nums[mid];
		for (int i = mid + 1; i < nums.length; i++) {
			rightSum += nums[i];

			rightMax = Math.max(rightMax, rightSum);
		}
		return Math.max(leftMax + rightMax, //
				Math.max(//
						maxSubArray2(nums, begin, mid), //
						maxSubArray2(nums, mid, end))//
		);
	}

	static public int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int begin = 0; begin < nums.length; begin++) {
			int sum = 0;
			for (int end = begin; end < nums.length; end++) {

				sum += nums[end];
				max = Math.max(max, sum);

			}
		}
		return max;
	}

	static public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int begin = 0; begin < nums.length; begin++) {
			for (int end = begin; end < nums.length; end++) {
				int sum = 0;
				for (int i = begin; i <= end; i++) {
					sum += nums[i];
				}
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
}
