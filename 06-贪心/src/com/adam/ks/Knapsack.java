package com.adam.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {
	public static void main(String[] args) {
		// 价值主导
		select("价值主导", (Article a1, Article a2) -> a2.value - a1.value);
		select("重量主导", (Article a1, Article a2) -> a1.weight - a2.weight);

		select("价值主导", (Article a1, Article a2) -> Double.compare(a2.valueDensity, a1.valueDensity));
	}

	/**
	 * 0-1 背包问题 1 价值主导 2 重量主导 3 价值密度主导（价值密度= 价值 ÷ 重量）
	 */
	static void select(String title, Comparator<Article> cmp) {
		Article[] articles = new Article[] { //
				new Article(35, 10), new Article(30, 40), //
				new Article(60, 30), new Article(50, 50), //
				new Article(40, 35), new Article(10, 40), //
				new Article(25, 30) };
		Arrays.sort(articles, cmp);

		int capacity = 150, weight = 0, value = 0;
		List<Article> selectedArticles = new LinkedList<>();

		for (int i = 0; i < articles.length && weight < capacity; i++) {
			int newWeight = weight + articles[i].weight;
			if (newWeight <= capacity) {

				weight = newWeight;
				value += articles[i].value;
				selectedArticles.add(articles[i]);
			}
		}
		System.out.println("【" + title + "】");
		System.out.println("总价值: " + value);
		System.out.println("总重量: " + weight);
		for (int i = 0; i < selectedArticles.size(); i++) {
			Article article = selectedArticles.get(i);
			System.out.println(article);
		}
		System.out.println("--------------------------------------------------------");
	}
}
