package ru.itis.informatics.lab24;

public class Main {
	public static void main(String[] args) {
		CustomHashMap customHashMap = new CustomHashMap();

		customHashMap.put("Linear Algebra", 86);
		customHashMap.put("Computer Science", 87);
		customHashMap.put("Mathematical Analysis", 88);
		System.out.println(customHashMap);

		customHashMap.removeByKey("Mathematical Analysis");
		System.out.println(customHashMap);

		System.out.println(customHashMap.getAllKeys());
		System.out.println(customHashMap.getKeysByValue(87));
		System.out.println(customHashMap.getValueByKey("Linear Algebra"));

	}
}