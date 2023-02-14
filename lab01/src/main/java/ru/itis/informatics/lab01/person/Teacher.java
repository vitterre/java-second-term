package ru.itis.informatics.lab01.person;

public final class Teacher extends Person {
	private String caphedra;

	public Teacher(String name, String caphedra) {
		super(name);
		this.caphedra = caphedra;
	}

	public String getCaphedra() {
		return caphedra;
	}
}
