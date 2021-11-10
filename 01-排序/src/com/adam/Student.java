package com.adam;

@SuppressWarnings("unused")
public class Student implements Comparable<Student>{
	public int getAge() {
		return age;
	}

	public Student(int age, int score) {
		super();
		this.age = age;
		this.score = score;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int age;
	private int score;
	private String name;
	

	@Override
	public int compareTo(Student o) {
		return age - o.age;
	}

	public Student(int age, int score, String name) {
		super();
		this.age = age;
		this.score = score;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: " + this.name + ", score: " + this.score + ", age: " + this.age;
	}
	
}
