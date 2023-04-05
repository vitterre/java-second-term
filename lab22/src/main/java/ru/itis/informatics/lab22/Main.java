package ru.itis.informatics.lab22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		CustomSet<Integer> set = new CustomSet<>();
		List<Integer> list = new ArrayList<>();
		list.iterator();

		// Get set size
		System.out.println(set.size());

		// Is empty
		System.out.println(set.isEmpty());

		// Adding
		set.add(1);
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);

		// Removing
		set.remove(2);
		System.out.println(set);

		// Contains
		System.out.println(set.contains(1));

		// To array
		System.out.println(Arrays.toString(set.toArray()));

		// Clearing
		set.clear();
		System.out.println(set);

		System.out.println("A".equals("A"));
	}
}
