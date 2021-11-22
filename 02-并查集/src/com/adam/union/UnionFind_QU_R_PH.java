package com.adam.union;

/**
 * Quick Union - 基于rank的优化 - 路径分裂 Path Splitting*
 * 
 * @author adam
 *
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R {
	public UnionFind_QU_R_PH(int capacity) {
		super(capacity);
	}

	@Override
	public int find(int v) {
		rangeChack(v);
		if (parents[v] != v) {
			int p = parents[v];
			parents[v] = parents[parents[v]];
			v = p;
		}
		return parents[v];
	}
}
