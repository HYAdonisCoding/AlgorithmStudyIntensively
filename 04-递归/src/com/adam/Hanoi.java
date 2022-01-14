package com.adam;

public class Hanoi {
	public static void main(String[] args) {
		new Hanoi().hanoi(10, "A", "B", "C");
	}

	/**
	 * 将n个碟子从p1挪动到p3
	 * 
	 * @param n  碟数量
	 * @param p1 初始柱子
	 * @param p2 中间的柱子
	 * @param p3 目标柱子
	 */
	void hanoi(int n, String p1, String p2, String p3) {
		if (n == 1) {
			move(n, p1, p3);
			return;
		}
		hanoi(n - 1, p1, p3, p2);
		move(n, p1, p3);
		hanoi(n - 1, p2, p1, p3);
	}

	/**
	 * 将 no 碟子 从 from 移动到 to
	 * 
	 * @param no
	 * @param from
	 * @param to
	 */
	void move(int no, String from, String to) {
		System.out.println("将" + no + "号碟子从" + from + "移动到" + to);
	}

}
