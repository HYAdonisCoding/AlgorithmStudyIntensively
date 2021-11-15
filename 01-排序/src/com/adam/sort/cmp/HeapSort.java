package com.adam.sort.cmp;

import com.adam.sort.Sort;

public class HeapSort<E extends Comparable<E>> extends Sort<E> {
	private int heapSize;
	@Override
	protected void sort() {
		// 原地建堆
		heapSize = array.length;
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}
		
		while (heapSize > 1) {
			
			// 交换堆顶和尾部
			swap(0, --heapSize);
			// 对0位置经行侠侣
			siftDown(0);
		}

	}
	/*
	 * 让index位置的元素下滤
	 */
	private void siftDown(int index) {
		E element = array[index];
		int half = heapSize >> 1;
		// 第一个叶子结点的索引 非叶子结点的数量
		while (index < half) { // index是非叶子结点 小于第一个叶子结点的索引
			// index有两种情况
			// 1.只有左子节点
			// 2.同时有右子结点

			// 默认为左子节点的索引
			int childIndex = (index << 1) + 1;
			E child = array[childIndex];
			// 右子结点
			int rightIndex = childIndex + 1;
			// 找出左右子节点最大的那个
			if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
				child = array[childIndex = rightIndex];
			}
			if (cmp(element, child) >= 0) {
				break;
			}
			// 将子节点存放到index 位置
			array[index] = child;
			// 重新计算索引
			index = childIndex;
		}
		array[index] = element;
	}
}
