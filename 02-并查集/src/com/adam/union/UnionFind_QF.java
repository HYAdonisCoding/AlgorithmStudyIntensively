package com.adam.union;

/**
 * Quick Find
 * 
 * @author adam
 *
 */
public class UnionFind_QF extends UnionFind {

	public UnionFind_QF(int capacity) {
		super(capacity);
	}

	/**
	 * 查找v所属的集合(根节点) 父节点就是根节点
	 * 
	 * @param v
	 * @return
	 */
	@Override
	public int find(int v) {
		rangeChack(v);
		return parents[v];
	}

	/**
	 * 合并V1 V2 所属的集合 将V1所在集合的所有父节点嫁接到V3的父节点上
	 * 
	 * @param v1
	 * @param v2
	 */
	@Override
	public void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (p1 == p2) {
			return;
		}
		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == p1) {
				parents[i] = p2;
			}
		}
	}

	/**
	 * 检查v1\ v2是否属于一个集合
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	@Override
	public boolean isSame(int v1, int v2) {
		return find(v1) == find(v2);
	}

}
