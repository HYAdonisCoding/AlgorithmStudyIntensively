package com.adam;

/**
 * @author adam
 *
 */
public class Queens {

	public static void main(String[] args) {

		new Queens().placeQueens(4);
	}

	/**
	 * 数组索引是行号， 数组索引是列号
	 */
	int[] cols;

	/**
	 * 一共有多少种摆法
	 */
	int ways;

	void placeQueens(int n) {
		if (n < 1) {
			return;
		}
		cols = new int[n];
		place(0);
		System.out.println(n + "皇后一共有" + ways + "种摆法");
	}

	/**
	 * 从第row行开始摆放皇后
	 * 
	 * @param row
	 */
	void place(int row) {
		if (row == cols.length) {
			ways++;
			show();
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			// 剪枝
			if (isValid(row, col)) {
				// 第row行 第col列摆放皇后
				cols[row] = col;
				place(row + 1);
				// 回溯
			} else {

			}
		}
	}

	/**
	 * 判断第row行 第col列是否可以摆放皇后
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			// 第row行 第col列已经有了皇后，不可以摆放皇后
			if (cols[i] == col) {
				System.out.println("[" + row + "][" + col + "] == false列已经有了皇后");

				return false;
			}
			// 斜线上是否有皇后
			if ((row - i) == Math.abs(col - cols[i])) {
				System.out.println("[" + row + "][" + col + "] == false斜线上已经有了皇后");
				return false;
			}
		}
		System.out.println("[" + row + "][" + col + "] == true");
		return true;
	}

	void show() {
		for (int row = 0; row < cols.length; row++) {
			for (int col = 0; col < cols.length; col++) {
				if (cols[row] == col) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
		System.out.println("---------------");
	}
}
