import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void add_ExpectListSizeToIncreaseBy1() {
		var list = new LinkedList<Integer>();
		var expectedSize = 1;

		list.add(5);

		assertEquals(expectedSize, list.size());
	}

	@Test
	void add_addTwo_ExpectListSizeToIncreaseBy2() {
		var list = new LinkedList<Integer>();
		var expectedSize = 2;

		list.add(5);
		list.add(10);

		assertEquals(expectedSize, list.size());
	}

	@Test
	void add_atSpecificIndex_ExpectIndexToContainValue() {
		var list = new LinkedList<String>();
		var expectedSize = 3;

		list.add("Hello");
		list.add("World");
		list.add(1, ", ");

		assertEquals(expectedSize, list.size());
		assertEquals(", ", list.get(1));
	}

	@Test
	void addAll_ShouldAddAllItemsToEnd() {
		var list = new LinkedList<Integer>();
		var toAdd = List.of(3, 4, 5, 6);
		var expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(toAdd);

		assertEquals(expectedSize, list.size());
		var added = list.subList(2, 6);
		assertEquals(toAdd, added);
	}

	@Test
	void addAll_AtSpecificIndex_ShouldAddAllItemsAtIndex() {
		var list = new LinkedList<Integer>();
		var toAdd = List.of(3, 4, 5, 6);
		var expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(1, toAdd);

		assertEquals(expectedSize, list.size());
		var added = list.subList(1, 5);
		assertEquals(toAdd, added);
	}

	@Test
	void clear_ShouldMakeListSizeZero() {
		var list = new LinkedList<Integer>();
		var expectedSize = 0;

		list.add(1);
		list.add(2);
		list.clear();

		assertEquals(expectedSize, list.size());
	}

	@Test
	void contains_ItemIsInList_ShouldReturnTrue() {
		var list = new LinkedList<String>();
		var item = "42";

		list.add(String.valueOf(item));
		list.add("Hello World");

		assertTrue(list.contains(item));
	}

	@Test
	void contains_ItemIsNotInList_ShouldReturnFalse() {
		var list = new LinkedList<String>();
		var item = "42";

		list.add("39");
		list.add("Hello World");

		assertFalse(list.contains(item));
	}

	@Test
	void indexOf_ItemIsInList_ShouldReturnIndex() {
		var list = new LinkedList<Integer>();
		var expectedIndex = 4;
		var value = 42;

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(value);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	void indexOf_ItemIsNotInList_ShouldReturnNegative1() {
		var list = new LinkedList<Integer>();
		var expectedIndex = -1;
		var value = 39;

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	void isEmpty_EmptyList_ShouldReturnTrue() {
		var list = new LinkedList<String>();

		assertTrue(list.isEmpty());
	}

	@Test
	void isEmpty_ListHasItems_ShouldReturnFalse() {
		var list = new LinkedList<String>();

		list.add("hello");
		list.add("world");

		assertFalse(list.isEmpty());
	}

	@Test
	void lastIndexOf_ItemAppearsMultipleTimes_ShouldReturnIndex() {
		var list = new LinkedList<Integer>();
		var expectedIndex = 5;
		var value = 42;
		var toAdd = List.of(0, 1, value, value, 4, value, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	void lastIndexOf_ItemDoesNotAppear_ShouldReturnIndex() {
		var list = new LinkedList<Integer>();
		var expectedIndex = -1;
		var value = 42;
		var toAdd = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	void remove_Index_ShouldRemoveItemAtIndex() {
		var list = new LinkedList<String>();
		var removeAt = 0;
		var value = "hello";
		var toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		var sizeBeforeRemove = list.size();

		var valueBeforeRemove = list.get(removeAt);
		var removed = list.remove(removeAt);
		var valueAfterRemove = list.get(removeAt);

		assertEquals(value, removed);
		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	void remove_IndexDoesNotExist_ShouldReturnNull() {
		var list = new LinkedList<String>();
		var removeAt = 42;
		var value = "hello";

		var toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		var sizeBeforeRemove = list.size();

		var removed = list.remove(removeAt);

		assertNull(removed);
		assertEquals(sizeBeforeRemove, list.size());
	}

	@Test
	void remove_ObjectParam_ShouldReturnTrue() {
		var list = new LinkedList<String>();
		var removeAt = 0;
		var value = "hello";
		var toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		var sizeBeforeRemove = list.size();

		var valueBeforeRemove = list.get(removeAt);
		assertTrue(list.remove(value));
		var valueAfterRemove = list.get(removeAt);

		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}
}
