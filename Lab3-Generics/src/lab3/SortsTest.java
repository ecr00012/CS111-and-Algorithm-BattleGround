package lab3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SortsTest {

	private static Stream<List<Integer>> provideIntArrays() {
		return Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(5, 3, 2, 1), Arrays.asList(9, 9, 9, 1),
				Arrays.asList(50, 1, 2, 21), Arrays.asList(5, 3, 2, 99, 1), Arrays.asList(1),
				Arrays.asList(-20, -40, 5, -25));
	}

	private static Stream<List<String>> provideStringArrays() {
		return Stream.of(Arrays.asList("cat", "dog"), Arrays.asList("Bob", "Tom", "Karen", "Jill"),
				Arrays.asList("Java", "Javascript", "Haskell", "C#", "C", "C++", "Ruby"));

	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void bubbleSort_SortsIntegersAsExpected(List<Integer> input) {
		List<Integer> output = input.stream().collect(Collectors.toList());
		Sorts.bubbleSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void bubbleSort_SortsStringsAsExpected(List<String> input) {
		List<String> output = input.stream().collect(Collectors.toList());
		Sorts.bubbleSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void selectionSort_SortsIntegersAsExpected(List<Integer> input) {
		List<Integer> output = input.stream().collect(Collectors.toList());
		Sorts.selectionSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void selectionSort_SortsStringAsExpected(List<String> input) {
		List<String> output = input.stream().collect(Collectors.toList());
		Sorts.selectionSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

	@ParameterizedTest
	@MethodSource("provideIntArrays")
	void insertionSort_SortsArrayAsExpected(List<Integer> input) {
		List<Integer> output = input.stream().collect(Collectors.toList());
		Sorts.insertionSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

	@ParameterizedTest
	@MethodSource("provideStringArrays")
	void insertionSort_SortsStringAsExpected(List<String> input) {
		List<String> output = input.stream().collect(Collectors.toList());
		Sorts.insertionSort(output);
		Utils.assertListHasBeenSorted(input, output);
	}

}
