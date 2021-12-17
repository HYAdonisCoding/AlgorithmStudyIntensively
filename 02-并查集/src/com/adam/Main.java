package com.adam;

import com.adam.tools.Asserts;
import com.adam.tools.Times;
import com.adam.union.GenericUnionFind;
import com.adam.union.UnionFind;
import com.adam.union.UnionFind_QF;
import com.adam.union.UnionFind_QU;
import com.adam.union.UnionFind_QU_R;
import com.adam.union.UnionFind_QU_R_PC;
import com.adam.union.UnionFind_QU_R_PH;
import com.adam.union.UnionFind_QU_R_PS;
import com.adam.union.UnionFind_QU_S;

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
		UnionFind unionFind = new UnionFind_QU_S(12);
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

	static void testUF(UnionFind unionFind) {

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

	static void test3() {

		testUF(new UnionFind_QF(12));
		testUF(new UnionFind_QU(12));
		testUF(new UnionFind_QU_S(12));
		testUF(new UnionFind_QU_R(12));
	}

	private static final int count = 500000;

	static void testTime(GenericUnionFind<Integer> unionFind) {
		for (int i = 0; i < count; i++) {
			unionFind.makeSet(i);

		}

		unionFind.union(0, 1);
		unionFind.union(0, 3);
		unionFind.union(0, 4);
		unionFind.union(2, 3);
		unionFind.union(2, 5);

		unionFind.union(6, 7);

		unionFind.union(8, 10);
		unionFind.union(9, 10);
		unionFind.union(9, 11);

		Asserts.test(unionFind.isSame(6, 7) == true);
		Asserts.test(unionFind.isSame(8, 5) == false);

		unionFind.union(4, 6);

		Asserts.test(unionFind.isSame(2, 7) == true);
		Times.test(unionFind.getClass().getSimpleName(), () -> {
			for (int i = 0; i < count; i++) {
				unionFind.union((int) (Math.random() * count), (int) (Math.random() * count));
			}
			for (int i = 0; i < count; i++) {
				unionFind.isSame((int) (Math.random() * count), (int) (Math.random() * count));
			}
		});

	}

	static void testTime(UnionFind unionFind) {

		unionFind.union(0, 1);
		unionFind.union(0, 3);
		unionFind.union(0, 4);
		unionFind.union(2, 3);
		unionFind.union(2, 5);

		unionFind.union(6, 7);

		unionFind.union(8, 10);
		unionFind.union(9, 10);
		unionFind.union(9, 11);

		Asserts.test(unionFind.isSame(6, 7) == true);
		Asserts.test(unionFind.isSame(8, 5) == false);

		unionFind.union(4, 6);

		Asserts.test(unionFind.isSame(2, 7) == true);
		Times.test(unionFind.getClass().getSimpleName(), () -> {
			for (int i = 0; i < count; i++) {
				unionFind.union((int) (Math.random() * count), (int) (Math.random() * count));
			}
			for (int i = 0; i < count; i++) {
				unionFind.isSame((int) (Math.random() * count), (int) (Math.random() * count));
			}
		});

	}

	static void test4() {

//		testTime(new UnionFind_QF(count));
//		testTime(new UnionFind_QU(count));
//		testTime(new UnionFind_QU_S(count));
//		testTime(new UnionFind_QU_R(count));
		testTime(new UnionFind_QU_R_PC(count));
		testTime(new UnionFind_QU_R_PS(count));
		testTime(new UnionFind_QU_R_PH(count));
		testTime(new GenericUnionFind<>());
	}

	static void test5() {
		GenericUnionFind<Student> uf = new GenericUnionFind<>();
		Student stu1 = new Student(10, "Jack");
		Student stu2 = new Student(18, "Rose");
		Student stu3 = new Student(19, "Alice");
		Student stu4 = new Student(20, "Adam");
		uf.makeSet(stu1);
		uf.makeSet(stu2);
		uf.makeSet(stu3);
		uf.makeSet(stu4);

		uf.union(stu1, stu2);
		uf.union(stu3, stu4);
		uf.union(stu1, stu4);

		Asserts.test(uf.isSame(stu1, stu2));
		Asserts.test(uf.isSame(stu3, stu4));
		Asserts.test(uf.isSame(stu1, stu3));
	}

	public static void main(String[] args) {
//		test3();
		test4();
		test5();
		System.out.println("Finish");
	}

}
