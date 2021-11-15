package com.adam.sort.cmp;

import com.adam.sort.Sort;

public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {
//	@Override
//	protected void sort() {
//		for (int begin = 1; begin < array.length; begin++) {
//			int insertIndex = search(begin);
//			E v = array[begin];
////			for (int i = begin - 1; i >= insertIndex; i--) {
////				array[i] = array[i - 1];
////			}
//			for (int i = begin; i > insertIndex; i--) {
//				array[i] = array[i - 1];
//			}
//			array[insertIndex] = v;
//		}
//		
//	}
	@Override
	protected void sort() {
		for (int begin = 0; begin < array.length; begin++) {
			insert(begin, search(begin));
		}

	}

	// 将source位置元素的插入dest位置
	private void insert(int source, int dest) {
		E e = array[source];
		for (int i = source; i > dest; i--) {
			array[i] = array[i - 1];
		}
		array[dest] = e;
	}

	// 利用二分搜索查找到 index 位置元素的待插入位置
	private int search(int index) {
		int end = index;
		int begin = 0;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (cmp(array[index], array[mid]) < 0) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return begin;
	}

}
