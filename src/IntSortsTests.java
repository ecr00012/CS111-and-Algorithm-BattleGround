import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * CS111 Lab 1
 * 
 * A collection of Integer Array sorting algorithms. You must fill in the
 * following method stubs and get all the tests to pass inside of
 * IntSortsTests.java
 * 
 * Please updated your author name below:
 * 
 * @author zadidhabib
 */
class IntSortsTests {

	static boolean isSorted(List<Integer> input) {
		if (input.size() <= 1)
			return true;
		int a = input.remove(0);
		int b = input.remove(0);
		return a < b ? isSorted(input) : false;
	}

	static void checkIfSorted(int[] input, int[] result) {
		Arrays.sort(input);
		Assert.assertArrayEquals(input, result);
	}

	private static Stream<List<Integer>> provideIntArrays() {
		return Stream.of(List.of(1, 2, 3), List.of(5, 3, 2, 1), List.of(9, 9, 9, 1), List.of(50, 1, 2, 21),
				List.of(5, 3, 2, 99, 1), List.of(1), List.of(-20, -40, 5, -25));
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_SortsArrayAsExpected(List<Integer> input) {
		int[] arrInput = input.stream().mapToInt(i -> i).toArray();
		int[] output = arrInput.clone();
		IntSorts.bubbleSort(output);
		checkIfSorted(arrInput, output);
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_SortsArrayAsExpected(List<Integer> input) {
		int[] arrInput = input.stream().mapToInt(i -> i).toArray();
		int[] output = arrInput.clone();
		IntSorts.selectionSort(output);
		checkIfSorted(arrInput, output);
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_SortsArrayAsExpected(List<Integer> input) {
		int[] arrInput = input.stream().mapToInt(i -> i).toArray();
		int[] output = arrInput.clone();
		IntSorts.insertionSort(output);
		checkIfSorted(arrInput, output);
	}
}