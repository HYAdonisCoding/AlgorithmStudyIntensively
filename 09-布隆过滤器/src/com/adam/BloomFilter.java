package com.adam;

public class BloomFilter<T> {

	/**
	 * 二进制向量的长度
	 */
	private int bitSize;

	/**
	 * 二进制向量
	 */
	private long[] bits;
	/**
	 * 哈希函数的个数
	 */
	private int hashSize;

	/**
	 * @param n 数据规模
	 * @param p 误判率,取值范围(0, 1)
	 */
	public BloomFilter(int n, double p) {
		if (n <= 0 || p <= 0 || p >= 1) {
			throw new IllegalArgumentException("Wrong n or p ");
		}
		double ln2 = Math.log(2);
		// 求出二进制向量的长度
		bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
		// 哈希函数的个数
		hashSize = (int) (bitSize * ln2 / n);
		System.out.println("bitSize: " + bitSize + ", hashSize: " + hashSize);
		// 二进制向量
		bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
	}

	/**
	 * 添加元素
	 * 
	 * @param value
	 */
	public boolean put(T value) {
		nullCheck(value);
		int hash1 = value.hashCode();
		int hash2 = hash1 >>> 16;
		boolean result = false;
		for (int i = 1; i <= hashSize; i++) {
			int combinedHash = hash1 + (i * hash2);
			if (combinedHash < 0) {

				combinedHash = ~combinedHash;
			}
//			System.out.println("put: " + value + ",idx: " + combinedHash % bitSize);

			// 设置index位置的二进制为1
			if (setBit(combinedHash % bitSize))
				result = true;
		}
		return result;
	}

	/**
	 * 判断一个元素是否存在
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(T value) {
		nullCheck(value);
		int hash1 = value.hashCode();
		int hash2 = hash1 >>> 16;
		for (int i = 1; i <= hashSize; i++) {
			int combinedHash = hash1 + (i * hash2);
			if (combinedHash < 0) {

				combinedHash = ~combinedHash;
			}
//			System.out.println("contains: " + value + ",idx: " + combinedHash % bitSize);
			// 查看index位置的二进制为是否为0
			if (!get(combinedHash % bitSize)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 设置index位置的二进制为1
	 * 
	 * @param index
	 */
	private boolean setBit(int index) {
		/// 获取到idx
		int idx = index / Long.SIZE;
		long value = bits[idx];
		int bitValue = 1 << (index - index * Long.SIZE);
		bits[idx] = value | bitValue;
		return (value & bitValue) == 0;
	}

	/**
	 * 设置index位置的二进制为1
	 * 
	 * @param index
	 */
	private boolean get(int index) {
		int idx = index / Long.SIZE;
		long value = bits[idx];
		return (value & (1 << (index - index * Long.SIZE))) != 0;
	}

	private void nullCheck(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value must be not null.");
		}
	}
}
