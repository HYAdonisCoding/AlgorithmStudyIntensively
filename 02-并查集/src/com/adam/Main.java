package com.adam;

import com.adam.tools.Asserts;
import com.adam.union.UnionFind;
import com.adam.union.UnionFind_QF;
import com.adam.union.UnionFind_QU;

public class Main {

	static void test1() {
		UnionFind unionFind = new UnionFind_QF(12);
		unionFind.union(0, 1);
		unionFind.union(0, 3);
		unionFind.union(0, 4);
		unionFind.union(2, 3);
		unionFind.union(2, 5);

		unionFind.union(6, 7);

		unionFind.union(8, 10);
		unionFind.union(9, 10);
		unionFind.union(9, 11);

		System.out.println(unionFind.isSame(6, 7));
		System.out.println(unionFind.isSame(8, 5));

		unionFind.union(4, 6);
		System.out.println(unionFind.isSame(2, 7));

	}

	static void test2() {
		UnionFind unionFind = new UnionFind_QU(12);
		unionFind.union(0, 1);
		unionFind.union(0, 3);
		unionFind.union(0, 4);
		unionFind.union(2, 3);
		unionFind.union(2, 5);

		unionFind.union(6, 7);

		unionFind.union(8, 10);
		unionFind.union(9, 10);
		unionFind.union(9, 11);

//		System.out.println(unionFind.isSame(6, 7));
//		System.out.println(unionFind.isSame(8, 5));
		Asserts.test(!unionFind.isSame(2, 7));
		unionFind.union(4, 6);
		Asserts.test(unionFind.isSame(2, 7));

	}

	public static void main(String[] args) {
		test2();
		System.out.println("Finish");
	}

}
