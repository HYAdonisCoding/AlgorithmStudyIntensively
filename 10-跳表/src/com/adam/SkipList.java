package com.adam;

import java.util.Comparator;

@SuppressWarnings({ "unused", "unchecked" })
public class SkipList<K, V> {

	/**
	 * 最高层数
	 */
	private static final int MAX_LEVEL = 32;
	/**
	 * 概率
	 */
	private static final double P = 0.25;

	/**
	 * 有效层数
	 */
	private int level;

	public SkipList(Comparator<K> comparator) {
		this.comparator = comparator;

		first = new Node<>(null, null, MAX_LEVEL);
	}

	public SkipList() {
		this(null);
	}

	private Comparator<K> comparator;

	private int size;

	private Node<K, V> first;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public V put(K key, V value) {
		keyCheck(key);
		Node<K, V> node = first;
		Node<K, V>[] prevs = new Node[level];
		for (int i = level - 1; i >= 0; i--) {
			int cmp = -1;
			while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
				node = node.nexts[i];
			}
			if (cmp == 0) {// 节点存在

				V oldV = node.nexts[i].value;
				node.nexts[i].value = value;

				return oldV;
			}
			prevs[i] = node;
		}
		int newLevel = randomLevel();
		// 节点不存在 添加新节点
		Node<K, V> newNode = new Node<>(key, value, newLevel);
		// 设置前驱和后继
		for (int i = 0; i < newLevel; i++) {
			if (i >= level) {
				first.nexts[i] = newNode;
			} else {
				newNode.nexts[i] = prevs[i].nexts[i];
				prevs[i].nexts[i] = newNode;
			}

		}
		/// 节点数量增加
		size++;
		/// 计算跳表的最终层数
		level = Math.max(level, newLevel);
		return null;
	}

	public V get(K key) {
		keyCheck(key);
		Node<K, V> node = first;
		for (int i = level - 1; i >= 0; i--) {
			int cmp = -1;
			while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
				node = node.nexts[i];
			}
			if (cmp == 0) {
				return node.nexts[i].value;
			}
		}
		return null;
	}

	public V remove(K key) {
		keyCheck(key);
		Node<K, V> node = first;
		Node<K, V>[] prevs = new Node[level];
		boolean exist = false;
		for (int i = level - 1; i >= 0; i--) {
			int cmp = -1;
			while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
				node = node.nexts[i];
			}
			if (cmp == 0) {// 节点存在
				exist = true;
			}
			prevs[i] = node;
		}
		if (!exist) {
			return null;
		}
		// 数量减少
		size--;
		// 需要被删除的节点
		Node<K, V> removedNode = node.nexts[0];
		// 设置前驱和后继
		for (int i = 0; i < removedNode.nexts.length; i++) {
			prevs[i].nexts[i] = removedNode.nexts[i];
		}
		// 跟新level
		int newLevel = level;
		while (--newLevel >= 0 && first.nexts[newLevel] == null) {
			level = newLevel;

		}
		return removedNode.value;
	}

	private int randomLevel() {
		int level = 1;
		while (Math.random() < P && level < MAX_LEVEL) {
			level++;
		}
		return level;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("一共" + level + "层").append("\n");
		for (int i = level - 1; i >= 0; i--) {
			Node<K, V> node = first;
			while (node.nexts[i] != null) {
//				sb.append("key: " + node.nexts[i].key).append(", value: " + node.nexts[i].value + " ");
				sb.append(node.nexts[i] + " ");
				node = node.nexts[i];
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void keyCheck(K key) {
		if (key == null) {
			throw new IllegalArgumentException("key must be not null.");
		}
	}

	private int compare(K k1, K k2) {
		return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>) k1).compareTo(k2);
	}

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V>[] nexts;

		public Node(K key, V value, int level) {
			this.key = key;
			this.value = value;
			nexts = new Node[level];
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{" + key + ":" + value + "}_" + nexts.length;
		}
	}
}
