package ru.itis.informatics.lab215;

import java.util.concurrent.*;

/**
 * 1: 19118834
 * 2: 14116958
 * 3: 14527208
 * 4: 11698167
 * 5: 14744917
 * 6: 12182459
 * 7: 13950292
 * 8: 11337500
 * 9: 11379500
 * 10: 18316792
 */
public class Main {

	private static final int THREADS_AMOUNT = 4;

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final long startTime = System.nanoTime();

		final double a = 0;
		final double b = 1;
		final int steps = 100000;
		final double h = (b - a) / steps;

		double[] x = new double[steps + 1];
		double[] y = new double[steps + 1];

		ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

		int stepsPerThread = steps / THREADS_AMOUNT;

		Future<?>[] futures = new Future[THREADS_AMOUNT];

		for (int i = 0; i < THREADS_AMOUNT; i++) {
			final int threadIndex = i;
			futures[i] = executorService.submit(() -> {
				int start = threadIndex * stepsPerThread;
				int end = (threadIndex + 1) * stepsPerThread;
				for (int j = start; j < end; j++) {
					x[j] = a + j * h;
					y[j] = function(x[j]);
				}
			});
		}

		for (int i = 0; i < THREADS_AMOUNT; i++) {
			futures[i].get();
		}

		double integral = h * (0.5 * y[0] + sum(y, 1, steps) + 0.5 * y[steps]);
		System.out.println("Integral: " + integral);

		final long endTime = System.nanoTime();

		System.out.println("Estimated time: " + (endTime - startTime));

		executorService.shutdown();
	}

	private static double function(double x) {
		return x * x * Math.exp(x);
	}

	private static double sum(double[] array, int fromIndex, int toIndex) {
		double sum = 0.0;
		for (int i = fromIndex; i < toIndex; i++) {
			sum += array[i];
		}
		return sum;
	}
}
