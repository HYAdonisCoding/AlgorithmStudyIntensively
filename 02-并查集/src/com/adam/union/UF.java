package com.adam.union;

public interface UF {
	/**
	 * 查找v所属的集合(根节点)
	 * 
	 * @param v
	 * @return
	 */
	int find(int v);

	void union(int v1, int v2);

	/**
	 * 检查v1\ v2是否属于一个集合
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	boolean isSame(int v1, int v2);
}
