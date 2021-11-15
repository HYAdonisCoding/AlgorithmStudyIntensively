package com.adam;

public class Person {
	int age;
	String name;

	@Override
	public String toString() {
		return "Person [age = " + age + ", name = " + name + "]";
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
}
