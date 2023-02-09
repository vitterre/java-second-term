package ru.itis.informatics.lab01;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		final Store store = new Store(100, "Kazan, Kremlevskaya 35");

		final SimpleImmutableMerch merch =
						new SimpleImmutableMerch(123, 100, 1000, store);

		System.out.println(merch);

		merch.getStore().setAddress("Kazan, Universitetskaya 40");

		System.out.println(merch);

		/*-----*/

		final GenericStack<Integer> genericStack = new GenericStack<>();

		genericStack.push(20);
		genericStack.push(30);

		System.out.println(genericStack.pop());

		/*
		HW: Stack, Queue, Deque generics
		 */
	}
}