package com.adam.graph;

public interface Graph<V, E> {

	int edgesSize();

	int verticesSize();

	void addVertex(V v);

	void addEdge(V from, V to);

	void addEdge(V from, V to, E weighet);

	void removeVertex(V v);

	void removeEdge(V from, V to);

	/// 广优先搜索
	void bfs(V begin);
}
