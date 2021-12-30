package com.adam.graph;

import java.util.List;

public interface Graph<V, E> {

	int edgesSize();

	int verticesSize();

	void addVertex(V v);

	void addEdge(V from, V to);

	void addEdge(V from, V to, E weighet);

	void removeVertex(V v);

	void removeEdge(V from, V to);

	/// 广度优先搜索
	void bfs(V begin, VertexVisitor<V> visitor);

	/// 深度优先搜索
	void dfs(V begin, VertexVisitor<V> visitor);
	
	List<V> topologicalSort();

	interface VertexVisitor<V> {
		boolean visit(V v);
	}
}
