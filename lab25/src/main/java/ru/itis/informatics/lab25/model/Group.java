package ru.itis.informatics.lab25.model;

public class Group {

	private String number;

	public Group(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Group{" +
						"number='" + number + '\'' +
						'}';
	}
}