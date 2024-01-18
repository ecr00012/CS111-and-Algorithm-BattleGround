package lab3;

import java.util.List;

import org.junit.Assert;

public class Utils {

	public static <E extends Comparable<E>> void assertListHasBeenSorted(List<E> original, List<E> customSort) {
		original.sort(E::compareTo);
		Assert.assertArrayEquals(original.toArray(), customSort.toArray());
	}

	public static <E extends Comparable<E>> Boolean isSorted(List<E> input) {
		if (input.size() <= 1)
			return true;

		E a = input.remove(0);
		E b = input.remove(0);
		return a.compareTo(b) < 0 ? isSorted(input) : false;
	}
}
