package ru.itis.informatics.lab25.model;

public class Student implements Comparable<Student> {

	private String lastName;
	private String firstName;
	private String middleName;
	private Group group;

	public Student(String lastName, String firstName, String middleName, Group group) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.group = group;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public int compareTo(Student o) {
		if (o == null) {
			throw new NullPointerException();
		}

		return this.lastName.compareTo(o.lastName);
	}

	@Override
	public String toString() {
		return "Student{" +
						"lastName='" + lastName + '\'' +
						", firstName='" + firstName + '\'' +
						", middleName='" + middleName + '\'' +
						", group=" + group +
						'}';
	}
}