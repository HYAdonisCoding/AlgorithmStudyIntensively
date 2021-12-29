package com.adam;

import com.adam.graph.ListGraph;

public class Main {
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

		graph.bfs("V1");
	}

	public static void main(String[] args) {
		test3();
	}

}
