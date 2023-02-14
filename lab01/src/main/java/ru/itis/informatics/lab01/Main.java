package ru.itis.informatics.lab01;

import ru.itis.informatics.lab01.person.Person;
import ru.itis.informatics.lab01.person.Student;
import ru.itis.informatics.lab01.person.Teacher;

public final class Main {
	public static void main(String[] args) {
		final QueueG<Person> queueG = new QueueG<>();

		queueG.add(new Student("Student A", "11-205"));
		queueG.add(new Teacher("Teacher A", "Computer Science"));

		System.out.println(queueG);
	}
}