package ru.itis.informatics.lab26;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

	@org.junit.jupiter.api.Test
	void sort() {
		HeapSort heapSort = new HeapSort();
		final int[] actual = new int[] { 2, 5, 1, 2, 8, 0, 4, 5 };
		final int[] expected = new int[] { 0, 1, 2, 2, 4, 5, 5, 8 };

		heapSort.sort(actual);

		Assertions.assertArrayEquals(actual, expected);
	}
}