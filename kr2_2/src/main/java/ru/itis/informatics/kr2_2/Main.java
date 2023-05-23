package ru.itis.informatics.kr2_2;

import ru.itis.informatics.kr2_2.tools.DijkstraAlgorithm;
import ru.itis.informatics.kr2_2.tools.MatrixTools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		int[][] graph = new int[50][50];
		List<String> lines = Files.readAllLines(Paths.get("kr2_2/src/main/resources/kontr2_2.csv"));

		for (int i = 0; i < 50 && i < lines.size(); i++) {
			String[] elements = lines.get(i).split(";");
			for (int j = 0; j < 50 && j < elements.length; j++) {
				graph[i][j] = Integer.parseInt(elements[j]);
			}
		}

		MatrixTools.makeSymmetric(graph);
		int[] fromFirst = DijkstraAlgorithm.dijkstra(graph, 0);
		int[] fromLast = DijkstraAlgorithm.dijkstra(graph, 49);

		ExecutorService executor = Executors.newFixedThreadPool(49);

		for (int i = 0; i < 49; i++) {
			int start = 0;
			int destination = i + 1;

			executor.execute(() -> sendCourier(start, destination, fromFirst));
		}


		ExecutorService executor2 = Executors.newFixedThreadPool(49);

		for (int i = 49; i > 0; i--) {
			int start = 49;
			int destination = i - 1;

			executor2.execute(() -> sendCourier(start, destination, fromLast));
		}

		executor.shutdown();
		executor2.shutdown();
	}

	private static void sendCourier(int startPoint, int destination, int[] distancies) {
		int distance = distancies[destination];
		try {
			Thread.sleep(distance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Courier from point " + startPoint + " reached point " + destination + " and worked " + distance + " milliseconds.");
	}
}