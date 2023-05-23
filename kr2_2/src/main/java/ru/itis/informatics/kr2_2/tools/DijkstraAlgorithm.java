package ru.itis.informatics.kr2_2.tools;

import java.util.Arrays;

public class DijkstraAlgorithm {

	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[] dijkstra(int[][] graph, int source) {
		int numVertices = graph.length;
		int[] distances = new int[numVertices];
		boolean[] visited = new boolean[numVertices];

		Arrays.fill(distances, INFINITY);
		distances[source] = 0;

		for (int i = 0; i < numVertices - 1; i++) {
			int minVertex = findMinVertex(distances, visited);
			visited[minVertex] = true;

			for (int j = 0; j < numVertices; j++) {
				if (graph[minVertex][j] != 0 && !visited[j] && distances[minVertex] != INFINITY) {
					int newDistance = distances[minVertex] + graph[minVertex][j];
					if (newDistance < distances[j]) {
						distances[j] = newDistance;
					}
				}
			}
		}

		return distances;
	}

	private static int findMinVertex(int[] distances, boolean[] visited) {
		int minVertex = -1;
		for (int i = 0; i < distances.length; i++) {
			if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}
}

