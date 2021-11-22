package com.adam.union;

/**
 * Quick Union - 基于rank的优化 - 路径减半 Path Halving*
 * 
 * @author adam
 *
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {
	public UnionFind_QU_R_PS(int capacity) {
		super(capacity);
	}

	@Override
	public int find(int v) {
		rangeChack(v);
		if (parents[v] != v) {
			parents[v] = parents[parents[v]];
			v = parents[v];
		}
		return parents[v];
	}
}
