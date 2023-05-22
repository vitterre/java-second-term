package ru.itis.informatics.lab22;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Collection<Integer> collection = new IterableCollection<>();
		collection.addAll(List.of(1, 2, 3, 4, 5));
		Iterator<Integer> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
