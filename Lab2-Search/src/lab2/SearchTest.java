package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchTest {

	private static Stream<Arguments> sequentialSearchArrays() {
		return Stream.of(Arguments.of(1, 0, List.of(1, 2, 3)), Arguments.of(42, 0, List.of(42)),
				Arguments.of(-20, 4, List.of(55, 24, 62, 0, -20)), Arguments.of(3, 2, List.of(1, 2, 3)),
				Arguments.of(1000, 0, List.of(1000)));
	}

	private static Stream<Arguments> provideBinarySearchArrays() {
		return Stream.of(Arguments.of(1, 0, List.of(1, 2, 3)), Arguments.of(4, -1, List.of(1, 2, 3)),
				Arguments.of(-42, 0, List.of(55, -42, 22, 0, 55)), Arguments.of(1, 0, List.of(1)),
				Arguments.of(11, 8, List.of(1, 1, 1, 1, 1, 11, 1, 1, 1)));
	}

	@ParameterizedTest
	@MethodSource("sequentialSearchArrays")
	public void sequentialSearch_ShouldReturnExpected(int searchFor, int expectedIndex, List<Integer> arr) {
		int[] input = arr.stream().mapToInt(i -> i).toArray();

		assertEquals(Search.sequentialSearch(searchFor, input), expectedIndex);
	}

	@ParameterizedTest
	@MethodSource("provideBinarySearchArrays")
	public void binarySearch_ShouldReturnExpected(int searchFor, int expectedIndex, List<Integer> arr) {
		int[] input = arr.stream().sorted().mapToInt(i -> i).toArray();

		assertEquals(expectedIndex, Search.binarySearch(searchFor, input));
	}
}
