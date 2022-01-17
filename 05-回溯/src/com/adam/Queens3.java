package com.adam;

/**
 * @author adam 8皇后的二进制优化
 */
public class Queens3 {

	public static void main(String[] args) {
		System.err.println();
		new Queens3().place8Queens();
	}

	/**
	 * 数组索引是行号， 数组元素是列号
	 */
	int[] queens;
	/**
	 * 标记着某一列是否有皇后
	 */
	byte cols;
	/**
	 * 标记着某一对角线是否有皇后 ，左上->右下
	 */
	short leftTop;
	/**
	 * 标记着某一对角线是否有皇后 ，右上->左下
	 */
	short rightTop;
	/**
	 * 一共有多少种摆法
	 */
	int ways;

	void place8Queens() {
		int n = 8;
		queens = new int[n];

		place(0);
		System.out.println(n + "皇后一共有" + ways + "种摆法");
	}

	/**
	 * 从第row行开始摆放皇后
	 * 
	 * @param row
	 */
	void place(int row) {
		if (row == 8) {
			ways++;
			show();
			return;
		}
		for (int col = 0; col < 8; col++) {
			// 剪枝
			int cv = 1 << col;
			if ((cols & cv) != 0) {
				continue;
			}
//			if (cols >> col == 1) {
//				continue;
//			}
			int lv = 1 << (row - col + 7);
			if ((leftTop & lv) != 0) {
				continue;
			}

			int rv = 1 << (row + col);
			if ((rightTop & rv) != 0)
				continue;
			// 第row行 第col列摆放皇后
			queens[row] = col;
			cols |= cv;
			leftTop |= lv;
			rightTop |= rv;
			place(row + 1);
			// 回溯
			cols &= ~cv;
			leftTop &= ~lv;
			rightTop &= ~rv;
		}
	}

	void show() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (queens[row] == col) {
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
