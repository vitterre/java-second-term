package ru.itis.informatics.lab22;

public class Main {
	public static void main(String[] args) {
		CustomList<Integer> customList = new CustomList<Integer>();

		customList.add(20);
		customList.add(30);
		customList.add(40);

		System.out.println(customList);

		customList.remove(30);

		System.out.println(customList);
	}
}
