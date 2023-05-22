package ru.itis.informatics.lab215;

public class ConsolePrinter {

	private void print(char c) {
		System.out.print(c);
	}

	public synchronized void print(String data) {
		for (int i = 0; i < data.length(); i++) {
			print(data.charAt(i));
		}
		System.out.println();
	}

}
