package com.adam.ks;

public class Article {
	int weight;
	int value;
	double valueDensity;

	public Article(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;

		this.valueDensity = value * 1.0 / weight;
	}

	@Override
	public String toString() {
		return "Article [weight=" + weight + ", value=" + value + ", valueDensity=" + valueDensity + "]";
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public double getValueDensity() {
		return valueDensity;
	}

	public void setValueDensity(double valueDensity) {
		this.valueDensity = valueDensity;
	}

}
