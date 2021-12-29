package com.adam.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unused")
public class ListGraph<V, E> implements Graph<V, E> {
	private Map<V, Vertex<V, E>> vertices = new HashMap<>();

	private Set<Edge<V, E>> edges = new HashSet<>();

	public void print() {
		System.out.println("[顶点]------------------------------");
		vertices.forEach((V v, Vertex<V, E> vertex) -> {
			System.out.println(v);
			System.out.println("---------------out---------------");
			System.out.println(vertex.outEdges);
			System.out.println("---------------in---------------");
			System.out.println(vertex.inEdges);

		});
		System.out.println("[边]------------------------------");
		edges.forEach((Edge<V, E> edges) -> {
			System.out.println(edges);
		});
	}

	@Override
	public void bfs(V begin, VertexVisitor<V> visitor) {
		//
		if (visitor == null) {
			return;
		}
		Vertex<V, E> beginVertex = vertices.get(begin);
		if (beginVertex == null) {
			return;
		}
		Set<Vertex<V, E>> visitVertices = new HashSet<>();
		Queue<Vertex<V, E>> queue = new LinkedList<>();
		queue.offer(beginVertex);
		visitVertices.add(beginVertex);
		while (!queue.isEmpty()) {

			Vertex<V, E> vertex = queue.poll();

			if (visitor.visit(vertex.value))
				return;
			for (Edge<V, E> edge : vertex.outEdges) {
				if (visitVertices.contains(edge.to)) {
					continue;
				}
				queue.offer(edge.to);
				visitVertices.add(edge.to);
			}

		}
	}

	@Override
	public void dfs(V begin, VertexVisitor<V> visitor) {
		if (visitor == null) {
			return;
		}
		Vertex<V, E> beginVertex = vertices.get(begin);
		if (beginVertex == null) {
			return;
		}
		Set<Vertex<V, E>> visitVertices = new HashSet<>();
		Stack<Vertex<V, E>> stack = new Stack<>();
		// 访起点
		stack.push(beginVertex);
		visitVertices.add(beginVertex);
		if (visitor.visit(begin))
			return;

		while (!stack.isEmpty()) {

			Vertex<V, E> vertex = stack.pop();
			for (Edge<V, E> edge : vertex.outEdges) {
				if (visitVertices.contains(edge.to)) {
					continue;
				}
				stack.push(edge.from);
				stack.push(edge.to);
				visitVertices.add(edge.to);
				if (visitor.visit(edge.to.value))
					return;
				break;
			}
		}

	}
//	@Override
//	public void dfs(V begin) {
//		Vertex<V, E> beginVertex = vertices.get(begin);
//		if (beginVertex == null) {
//			return;
//		}
//		Set<Vertex<V, E>> visitVertices = new HashSet<>();
//		Stack<Vertex<V, E>> stack = new Stack<>();
//		// 访起点
//		stack.push(beginVertex);
//		visitVertices.add(beginVertex);
//		System.out.println(beginVertex.value);
//
//		while (!stack.isEmpty()) {
//
//			Vertex<V, E> vertex = stack.pop();
//			for (Edge<V, E> edge : vertex.outEdges) {
//				if (visitVertices.contains(edge.to)) {
//					continue;
//				}
//				stack.push(edge.from);
//				stack.push(edge.to);
//				visitVertices.add(edge.to);
//				System.out.println(edge.to.value);
//				break;
//			}
//		}
//	}

	/// 递归
	public void dfs1(V begin) {
		Vertex<V, E> beginVertex = vertices.get(begin);
		if (beginVertex == null) {
			return;
		}
		Queue<Vertex<V, E>> queue = new LinkedList<>();
		dfs(beginVertex, new HashSet<>());
	}

	private void dfs(Vertex<V, E> vertex, Set<Vertex<V, E>> visitVertices) {
		System.out.println(vertex.value);
		visitVertices.add(vertex);
		for (Edge<V, E> edge : vertex.outEdges) {
			if (visitVertices.contains(edge.to)) {
				continue;
			}
			dfs(edge.to, visitVertices);
		}

	}
//	@Override
//	public void bfs(V begin) {
//		Vertex<V, E> beginVertex = vertices.get(begin);
//		if (beginVertex == null) {
//			return;
//		}
//		Set<Vertex<V, E>> visitVertices = new HashSet<>();
//		Queue<Vertex<V, E>> queue = new LinkedList<>();
//		queue.offer(beginVertex);
//		visitVertices.add(beginVertex);
//		while (!queue.isEmpty()) {
//
//			Vertex<V, E> vertex = queue.poll();
//
//			System.out.println(vertex.value);
//			for (Edge<V, E> edge : vertex.outEdges) {
//				if (visitVertices.contains(edge.to)) {
//					continue;
//				}
//				queue.offer(edge.to);
//				visitVertices.add(edge.to);
//			}
//
//		}
//	}

	@Override
	public int edgesSize() {
		//
		return edges.size();
	}

	@Override
	public int verticesSize() {
		//
		return vertices.size();
	}

	@Override
	public void addVertex(V v) {
		//
		if (vertices.containsKey(v))
			return;
		vertices.put(v, new Vertex<>(v));
	}

	@Override
	public void addEdge(V from, V to) {
		//
		addEdge(from, to, null);
	}

	@Override
	public void addEdge(V from, V to, E weighet) {
		// 判断 from to 是否存在

		Vertex<V, E> fromVertex = vertices.get(from);
		if (fromVertex == null) {

			fromVertex = new Vertex<>(from);
			vertices.put(from, fromVertex);
		}

		Vertex<V, E> toVertex = vertices.get(to);
		if (toVertex == null) {

			toVertex = new Vertex<>(to);
			vertices.put(to, toVertex);
		}
		Edge<V, E> edge = new Edge<>(fromVertex, toVertex, weighet);
		// 直接删了 再添加
		if (fromVertex.outEdges.remove(edge)) {
			toVertex.inEdges.remove(edge);
			edges.remove(edge);
		}
		fromVertex.outEdges.add(edge);
		toVertex.inEdges.add(edge);
		edges.add(edge);
//		// 如果以前有边 则看权值是否相等 不相同则更新权值
//		if (fromVertex.outEdges.contains(edge)) {
//
//		} else {
//			// 没有边直接添加
//
//			fromVertex.outEdges.add(edge);
//		}

	}

	@Override
	public void removeVertex(V v) {
		// 删除顶点
		Vertex<V, E> vertex = vertices.remove(v);
		if (vertex == null) {
			return;
		}
		// 删除边 迭代器
		for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext();) {
			Edge<V, E> edge = iterator.next();
			edge.to.inEdges.remove(edge);

			iterator.remove();// 将当前遍历到的元素 从iterator删除
			edges.remove(edge);
		}
		for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext();) {
			Edge<V, E> edge = iterator.next();
			edge.from.outEdges.remove(edge);

			iterator.remove();// 将当前遍历到的元素 从iterator删除
			edges.remove(edge);
		}
//		vertex.outEdges.forEach((Edge<V, E> edge) -> {
//			removeEdge(edge.from.value, edge.to.value);
//		});
//		vertex.inEdges.forEach((Edge<V, E> edge) -> {
//			removeEdge(edge.from.value, edge.to.value);
//		});
	}

	@Override
	public void removeEdge(V from, V to) {
		//
		Vertex<V, E> fromVertex = vertices.get(from);
		if (fromVertex == null) {
			return;
		}
		Vertex<V, E> toVertex = vertices.get(to);
		if (toVertex == null) {
			return;
		}
		Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
		if (fromVertex.outEdges.remove(edge)) {
			toVertex.inEdges.remove(edge);
			edges.remove(edge);
		}
	}

	private static class Vertex<V, E> {
		V value;

		Set<Edge<V, E>> inEdges = new HashSet<>();
		Set<Edge<V, E>> outEdges = new HashSet<>();

		public Vertex(V value) {
			super();
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return Objects.equals(value, ((Vertex<V, E>) obj).value);
		}

		@Override
		public int hashCode() {
			return value == null ? 0 : value.hashCode();
		}

		@Override
		public String toString() {
			return value == null ? "null" : value.toString();
		}

	}

	private static class Edge<V, E> {
		Vertex<V, E> from;
		Vertex<V, E> to;

		E weight;

		@Override
		public boolean equals(Object obj) {
			Edge<V, E> edge = (Edge<V, E>) obj;
			return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
		}

		@Override
		public int hashCode() {

			return from.hashCode() * 31 + to.hashCode();
		}

		public Edge(Vertex<V, E> from, Vertex<V, E> to) {
			super();
			this.from = from;
			this.to = to;
		}

		public Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

	}




}
