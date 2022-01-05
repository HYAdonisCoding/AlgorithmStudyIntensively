package com.adam;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.adam.graph.Graph;
import com.adam.graph.Graph.EdgeInfo;
import com.adam.graph.Graph.PathInfo;
import com.adam.graph.Graph.VertexVisitor;
import com.adam.graph.Graph.WeightManager;
import com.adam.graph.ListGraph;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		testSp1();
//		testBfs();
	}

	private static void testSp1() {
//		Graph<Object, Double> graph = undirectedGraph(Data.SP);
		Graph<Object, Double> graph = directedGraph(Data.NEGATIVE_WEIGHT2);
		Map<Object, PathInfo<Object, Double>> sp = graph.shortestPath(0);
		sp.forEach((Object v, PathInfo<Object, Double> path) -> {
			System.out.println(v + " - " + path);
		});

	}

	private static void testSp() {
//		Graph<Object, Double> graph = undirectedGraph(Data.SP);
		Graph<Object, Double> graph = directedGraph(Data.NEGATIVE_WEIGHT1);
		Map<Object, PathInfo<Object, Double>> sp = graph.shortestPath("A");
		sp.forEach((Object v, PathInfo<Object, Double> path) -> {
			System.out.println(v + " - " + path);
		});

	}

	private static WeightManager<Double> weightManager = new WeightManager<>() {

		@Override
		public int compare(Double w1, Double w2) {
			// TODO Auto-generated method stub
			return w1.compareTo(w2);
		}

		@Override
		public Double add(Double w1, Double w2) {
			// TODO Auto-generated method stub
			return w1 + w2;
		}

		@Override
		public Double zero() {
			return 0.0;
		}
	};

	private static void testMst() {
		Graph<Object, Double> graph = undirectedGraph(Data.MST_01);
		Set<EdgeInfo<Object, Double>> set = graph.mst();
		for (EdgeInfo<Object, Double> edgeInfo : set) {
			System.out.println(edgeInfo);
		}

	}

	private static void testTopo() {
		Graph<Object, Double> graph = directedGraph(Data.TOPO);
		List<Object> list = graph.topologicalSort();
		System.out.println(list);
	}

	private static void testDfs() {
//		ListGraph<Object, Double> graph = (ListGraph<Object, Double>) undirectedGraph(Data.DFS_01);
//		graph.dfs(1);
		ListGraph<Object, Double> graph = (ListGraph<Object, Double>) directedGraph(Data.DFS_02);
		graph.dfs("a", (Object v) -> {
			System.out.println(v);
			return false;

		});
//		graph.dfs1("a");
//		graph.dfs("c");
//		graph.dfs1("c");
	}

	private static void test4() {

	}

	private static void testBfs() {
//		ListGraph<Object, Double> graph = (ListGraph<Object, Double>) undirectedGraph(Data.BFS_01);
//		graph.bfs("A");
		ListGraph<Object, Double> graph = (ListGraph<Object, Double>) directedGraph(Data.BFS_02);
//		graph.bfs(0);
		graph.bfs(0, (Object v) -> {
			System.out.println(v);
			return v.equals(2);

		});
	}

	private static void test1() {
		ListGraph<String, Integer> graph = new ListGraph<>();

		graph.addEdge("V1", "V0", 9);
		graph.addEdge("V1", "V2", 3);
		graph.addEdge("V2", "V0", 2);
		graph.addEdge("V2", "V3", 5);
		graph.addEdge("V3", "V4", 1);
		graph.addEdge("V0", "V4", 6);

		graph.print();

//		graph.removeEdge("V0", "V4");
		graph.removeVertex("V0");

		graph.print();
	}

	private static void test2() {
		ListGraph<String, Integer> graph = new ListGraph<>();
		graph.addEdge("V0", "V1");
		graph.addEdge("V1", "V0");

		graph.addEdge("V0", "V2");
		graph.addEdge("V2", "V0");

		graph.addEdge("V0", "V3");
		graph.addEdge("V3", "V0");

		graph.addEdge("V1", "V2");
		graph.addEdge("V2", "V1");

		graph.addEdge("V2", "V3");
		graph.addEdge("V3", "V2");

		graph.print();
	}

	private static void test3() {
		ListGraph<String, Integer> graph = new ListGraph<>();

		graph.addEdge("V1", "V0", 9);
		graph.addEdge("V1", "V2", 3);
		graph.addEdge("V2", "V0", 2);
		graph.addEdge("V2", "V3", 5);
		graph.addEdge("V3", "V4", 1);
		graph.addEdge("V0", "V4", 6);

		graph.bfs("V1", new VertexVisitor<String>() {

			@Override
			public boolean visit(String v) {
				System.out.println(v);

				return v.equals(2);
			}
		});
	}

	private static Graph<Object, Double> graph() {
		Graph<Object, Double> graph = new ListGraph<>(weightManager);
		return graph;
	}

	/// 有向图
	private static Graph<Object, Double> directedGraph(Object[][] data) {
		Graph<Object, Double> graph = graph();
		for (Object[] edge : data) {
			if (edge.length == 1) {
				graph.addVertex(edge[0]);
			} else if (edge.length == 2) {
				graph.addEdge(edge[0], edge[1]);
			} else if (edge.length == 3) {
				double weight = Double.parseDouble(edge[2].toString());
				graph.addEdge(edge[0], edge[1], weight);
			}
		}
		return graph;
	}

	/// 无向图
	private static Graph<Object, Double> undirectedGraph(Object[][] data) {
		Graph<Object, Double> graph = graph();
		for (Object[] edge : data) {
			if (edge.length == 1) {
				graph.addVertex(edge[0]);
			} else if (edge.length == 2) {
				graph.addEdge(edge[0], edge[1]);
				graph.addEdge(edge[1], edge[0]);
			} else if (edge.length == 3) {
				double weight = Double.parseDouble(edge[2].toString());
				graph.addEdge(edge[0], edge[1], weight);
				graph.addEdge(edge[1], edge[0], weight);
			}
		}
		return graph;
	}

}
