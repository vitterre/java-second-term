package ru.itis.informatics.lab25.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		int r = o1.getGroup().getNumber().compareTo(o2.getGroup().getNumber());
		if (r != 0 ) {
			return r;
		}
		r = o1.getLastName().compareTo(o2.getLastName());
		if ( r != 0 ) {
			return r;
		}
		r = o1.getFirstName().compareTo(o2.getFirstName());
		if (r != 0 ) {
			return r;
		}
		return o1.getMiddleName().compareTo(o2.getMiddleName());



	}
}