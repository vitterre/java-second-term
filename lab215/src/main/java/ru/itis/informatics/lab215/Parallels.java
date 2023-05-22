package ru.itis.informatics.lab215;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Parallels {
	private static double function(double x) {
		return x * x * Math.exp(x);
	}

	public static void main(String[] args) {
		final double a = 0;
		final double b = 1;
		final int steps = 100000;
		final double h = (b - a) / steps;

		double[] x = new double[steps + 1];
		double[] y = new double[steps + 1];

		IntStream.range(0, steps)
						.parallel()
						.forEach(i -> {
							x[i] = a + i * h;
							y[i] = function(x[i]);
						});

		double integral = h * (0.5 * y[0] + Arrays.stream(y).sum() + 0.5 * y[steps]);
		System.out.println(integral);
	}
}
