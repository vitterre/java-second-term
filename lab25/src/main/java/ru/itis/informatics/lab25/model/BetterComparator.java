package ru.itis.informatics.lab25.model;

import java.util.Comparator;

public class BetterComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		int firstStudentGroup = Integer.parseInt(o1.getGroup().getNumber());
		int secondStudentGroup = Integer.parseInt(o2.getGroup().getNumber());

		int result = Integer.compare(firstStudentGroup, secondStudentGroup);

		if (result != 0) {
			return result;
		}

		result = o1.getLastName().compareTo(o2.getLastName());

		if (result != 0) {
			return result;
		}

		result = o1.getFirstName().compareTo(o2.getFirstName());

		if (result != 0) {
			return result;
		}

		return o1.getMiddleName().compareTo(o2.getMiddleName());
	}
}
