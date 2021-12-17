package com.adam;

public class Student {
	private int age;
	private String nameString;

	public Student(int age, String nameString) {
		super();
		this.age = age;
		this.nameString = nameString;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

}
