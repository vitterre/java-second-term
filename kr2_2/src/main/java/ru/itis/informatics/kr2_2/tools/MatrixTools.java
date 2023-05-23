package ru.itis.informatics.kr2_2.tools;

public class MatrixTools {
	public static void makeSymmetric(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = i + 1; j < cols; j++) {
				matrix[j][i] = matrix[i][j];
			}
		}
	}
}
