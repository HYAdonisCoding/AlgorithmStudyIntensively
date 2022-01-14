package com.adam;

public class ClimbStairs {
	int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	// 优化同fib
}
