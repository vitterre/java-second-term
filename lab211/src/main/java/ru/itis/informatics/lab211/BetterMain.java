package ru.itis.informatics.lab211;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BetterMain {
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("lab211/src/main/resources/USDRUB_220404_230404.csv"));
		lines = lines.subList(1, lines.size() - 1);
		List<Action> actions = lines.stream()
						.map(line -> line.split(","))
						.map(values -> new Action(values[0], values[1], values[2], Integer.parseInt(values[3]), Double.parseDouble(values[4])))
						.toList();

		// 1

		Action actionWithMaxPrice = actions.stream()
						.max(Comparator.comparingDouble(Action::getClose))
						.orElseThrow(NoSuchElementException::new);
		System.out.println(actionWithMaxPrice);

		// 2

		Action actionWithMinPrice = actions.stream()
						.min(Comparator.comparingDouble(Action::getClose))
						.orElseThrow(NoSuchElementException::new);
		System.out.println(actionWithMinPrice);

		// 3

		List<Double> midsForMonths = new ArrayList<>(actions.stream()
						.collect(Collectors.groupingBy(action ->
														LocalDate.parse(action.getDate(),
																		DateTimeFormatter.ofPattern("yyyyMMdd")).getMonth().toString(),
										Collectors.averagingDouble(Action::getClose)))
						.values());
		System.out.println(midsForMonths);

		// 4

		Double middleClose = actions.stream()
						.mapToDouble(Action::getClose)
						.average()
						.orElseThrow(NoSuchElementException::new);
		System.out.println(middleClose);


		// 5

		Map<String, List<Action>> actionsByMonth = actions.stream()
						.collect(Collectors.groupingBy(
										action ->LocalDate.parse(action.getDate(),
														DateTimeFormatter.ofPattern("yyyyMMdd")).getMonth().toString()));

		Double maxForApril = actionsByMonth.get("APRIL").stream()
						.mapToDouble(Action::getClose)
						.max()
						.orElseThrow(NoSuchElementException::new);

		Double minForApril = actionsByMonth.get("APRIL").stream()
						.mapToDouble(Action::getClose)
						.min()
						.orElseThrow(NoSuchElementException::new);

		System.out.println(maxForApril + ", " + minForApril);

		// 6

		Map<Boolean, Long> closeIsLowerAndGreater = actions.stream()
						.collect(Collectors.partitioningBy(
										action -> action.getClose() < middleClose, Collectors.counting()));
		System.out.println(closeIsLowerAndGreater.get(true) + ", " + closeIsLowerAndGreater.get(false));
	}
}
