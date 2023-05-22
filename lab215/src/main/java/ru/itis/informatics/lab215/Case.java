package ru.itis.informatics.lab215;

public class Case {
	public static void main(String[] args) {
		final ConsolePrinter printer = new ConsolePrinter();

		final PrintTask printTaskPuhkin =
						new PrintTask("Мой дядя самых честных правил, когда не в шутку занемог.", printer);
		final PrintTask printTaskLermontov =
						new PrintTask("Скажи-ка, дядя, ведь не даром, Москва спаленная пожаром французу отдана...", printer);

		new Thread(printTaskPuhkin).start();
		new Thread(printTaskLermontov).start();


	}
}
