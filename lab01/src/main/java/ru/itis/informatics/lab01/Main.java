package ru.itis.informatics.lab01;

public class Main {
	public static void main(String[] args) {
		final QueueG<Integer> queueG = new QueueG<>();

		queueG.add(20);
		queueG.add(23);
		queueG.add(26);

		System.out.println(queueG);

		queueG.remove();
		
		System.out.println(queueG);
	}
}