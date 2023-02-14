package ru.itis.informatics.lab01.person;

public final class Student extends Person {

	private String group;

	public Student(String name, String group) {
		super(name);
		this.group = group;
	}

	public String getGroup() {
		return group;
	}
}
