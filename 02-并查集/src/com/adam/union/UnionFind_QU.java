package com.adam.union;

/**
 * Quick Union
 * 
 * @author adam
 *
 */
public class UnionFind_QU extends UnionFind {

	public UnionFind_QU(int capacity) {
		super(capacity);
	}

	/**
	 * 通过parent链表不断向上找,直到找到根节点
	 */
	@Override
	public int find(int v) {
		rangeChack(v);
		while (v != parents[v]) {
			v = parents[v];
		}
		return v;
	}

	/**
	 * 将V1的父节点嫁接到V2的根节点上
	 */
	@Override
	public void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (p1 == p2) {
			return;
		}
		parents[p1] = p2;
	}

}
