package com.adam.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {

	@Override
	protected void sort() {
		List<Integer> stepSequence = shellStepQequence();
		stepSequence = sedgewickStepQequence();
		System.out.println(stepSequence);
		for (Integer step : stepSequence) {
			sort(step);
		}
	}

	/**
	 * 分成step列进行排序
	 * 
	 * @param step
	 */
	private void sort(int step) {
		// col: 第几列, column的简称
		for (int col = 0; col < step; col++) {
			// 对[0, array.length)范围内进行插入排序
			for (int begin = col + step; begin < array.length; begin += step) {
				int cur = begin;
				while (cur > col && cmp(cur, cur - step) < 0) {
					swap(cur, cur - step);
					cur -= step;
				}
			}
		}
	}

	/**
	 * 希尔本人给出的步长序列 最坏情况的时间复杂度是O(n^2)
	 * 
	 * @return 步长序列
	 */
	private List<Integer> shellStepQequence() {
		List<Integer> stepSequence = new ArrayList<>();
		int step = array.length;
		while ((step >>= 1) > 0) {
			stepSequence.add(step);
		}
		return stepSequence;
	}

	/**
	 * 已知的最好的步长序列 最坏情况的时间复杂度是O(n^(4/3))
	 * 
	 * @return [16001, 16001, 3905, 3905, 929, 929, 209, 209, 41, 41, 5, 1, 1]
	 */
	private List<Integer> sedgewickStepQequence() {
		List<Integer> stepSequence = new ArrayList<>();
		int k = 0, step = 0;
		while (true) {
			if (k >> 1 == 0) {
				int pow = (int) Math.pow(2, k >> 1);
				step = 1 + 9 * (pow * pow - pow);
			} else {
				int pow1 = (int) Math.pow(2, (k - 1) >> 1);
				int pow2 = (int) Math.pow(2, (k + 1) >> 1);
				step = 1 + 8 * pow1 * pow2 - 6 * pow2;
			}
			if (step >= array.length) {
				break;
			}

			stepSequence.add(0, step);
			k++;
		}
		return stepSequence;
	}
}
