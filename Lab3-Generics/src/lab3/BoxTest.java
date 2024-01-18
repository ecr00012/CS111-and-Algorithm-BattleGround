package lab3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * BoxText
 * 
 * Checks to make sure all Box methods work correctly. Please read this test
 * suite to see how generics work and how to use the Comparable interface.
 * 
 * @author zadidhabib
 *
 */
class BoxTest {

	@Test
	public void Box_ToString_IsExpected() {
		var b = new Box<Integer>(5);
		Assert.assertEquals(b.toString(), "Box 5");
	}

	@Test
	public void Box_CompareTo_ExpectB1IsLessThanB2() {
		var b1 = new Box<Integer>(5);
		var b2 = new Box<Integer>(10);

		assertEquals(b1.compareTo(b2), -1);
	}

	@Test
	public void Box_CompareTo_ExpectB1IsEqualToB2() {
		var b1 = new Box<Integer>(5);
		var b2 = new Box<Integer>(5);

		assertEquals(b1.compareTo(b2), 0);
	}

	@Test
	public void Box_CompareTo_ExpectB1IsGreaterThanB2() {
		var b1 = new Box<Integer>(5);
		var b2 = new Box<Integer>(1);

		assertEquals(b1.compareTo(b2), 1);
	}

	@Test
	public void Box_Equals_DifferentBoxes_ExpectEqualsToBeFalse() {
		var x = new Box<Integer>(15);
		var y = new Box<String>("Box");

		assertNotEquals(x, y);
	}

	@Test
	public void Box_Equals_SameValuedBoxes_ExpectEqualsToBeFalse() {
		var x = new Box<String>("Box");
		var y = new Box<String>("Box");

		assertEquals(x, y);
	}

	@Test
	public void Box_UnsortedListOfBoxes_ShouldSortCorrectly() {
		List<Integer> intList = List.of(1, 0, 29, 51, 68, 201);

		// Don't worry about the stream stuff here
		// Just know that this turns the list of Integers into a List of Box<Integers>
		List<Box<Integer>> boxList = intList.stream().map(Box::new).collect(Collectors.toList());

		System.out.println(boxList);

		// Because Box implement Comparable, we can just use the Collections Sort
		// algorithm
		Collections.sort(boxList);

		System.out.println(boxList);

		assertTrue(Utils.isSorted(boxList));
	}
}
