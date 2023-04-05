package ru.itis.informatics.lab25;


import ru.itis.informatics.lab25.model.BetterComparator;
import ru.itis.informatics.lab25.model.Group;
import ru.itis.informatics.lab25.model.Student;
import ru.itis.informatics.lab25.model.StudentComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainStudent {

	public static void main(String[] args) {

		Group group1 = new Group("1");
		Group group2 = new Group("2");

		List<Student> students = new ArrayList<>();

		students.add(new Student("Евстафьев","Дмитрий",
						"Геннадиевич", group1));
		students.add(new Student("Эйд","Хоссам",
						"", group2));
		students.add(new Student("Хулиана","Мария",
						"", group1));
		students.add(new Student("Родригес","Джошуа",
						"", group1));
		students.add(new Student("Веснина","Анна",
						"Михайловна", group2));

		System.out.println(students);

		Collections.sort(students, new BetterComparator());

		System.out.println(students);

//		StudentComparator comparator = new StudentComparator();
//		// 1
//		Collections.sort(students, comparator);
//
//		// 2
//		Collections.sort(students, new StudentComparator());
//
//		// 3
//		Collections.sort(students, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getFirstName().compareTo(o2.getFirstName());
//			}
//		});
//
//		// 4 Лямбда выражение (функциональный стиль)
//		Collections.sort(students,
//						(o1,o2) -> {
//							return o1.getFirstName().compareTo(o2.getFirstName());
//						});
//
//		// 5
//		Collections.sort(students,
//						(o1,o2) ->  o1.getFirstName().compareTo(o2.getFirstName()));

	}

}