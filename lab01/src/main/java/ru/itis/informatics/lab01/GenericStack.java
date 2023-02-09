package ru.itis.informatics.lab01;

public class GenericStack<T> {
	private static final int CAPACITY = 100;

	private Object[] body = new Object[CAPACITY];

	private int countOfElements = 0;

	public void push(final T t) {
		if (countOfElements < CAPACITY) {
			body[countOfElements++] = t;
		}
	}

	public T pop() {
		return countOfElements > 0 ? (T)body[--countOfElements] : null;
	}
}
