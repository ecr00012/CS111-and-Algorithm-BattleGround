import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListQueueTest {

	@Test
	void peek_QueueIsEmpty_ShouldReturnNull() {
		var queue = new LinkedListQueue<String>();

		assertEquals(null, queue.peek());
	}

	@Test
	void element_QueueIsEmpty_ShouldThrowNoSuchElementException() {
		var queue = new LinkedListQueue<String>();

		assertThrows(NoSuchElementException.class, () -> queue.element());
	}

	@Test
	void addThenPeek_QueueNotEmpty_ShouldReturnAddedItem() {
		var queue = new LinkedListQueue<String>();
		var expected = "C++";

		queue.add(expected);

		assertEquals(expected, queue.peek());
	}

	@Test
	void addThenPeek_QueueContainsSeveralItems_ShouldReturnFirstAddedItem() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		assertEquals(prefixes.get(0), queue.peek());
	}

	@Test
	void addThenElement_QueueNotEmpty_ShouldReturnAddedItem() {
		var queue = new LinkedListQueue<String>();
		var expected = "C++";

		queue.add(expected);

		assertEquals(expected, queue.element());
	}

	@Test
	void addThenElement_QueueContainsSeveralItems_ShouldReturnFirstAddedItem() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		assertEquals(prefixes.get(0), queue.element());
	}

	@Test
	void offerThenElement_QueueContainsSeveralItems_ShouldReturnFirstAddedItem() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.offer(x));

		assertEquals(prefixes.get(0), queue.element());
	}

	@Test
	void isEmpty_QueueIsEmpty_ShouldReturnTrue() {
		var queue = new LinkedListQueue<String>();

		assertTrue(queue.isEmpty());
	}

	@Test
	void isEmpty_QueueIsNotEmpty_ShouldReturnFalse() {
		var queue = new LinkedListQueue<String>();
		queue.add("Java");

		assertFalse(queue.isEmpty());
	}

	@Test
	void addThenSize_QueueIsNotEmpty_ShouldReturnAmountOfItemsAdded() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		assertEquals(prefixes.size(), queue.size());
	}

	@Test
	void addThenClearThenIsEmpty_QueueIsNotEmpty_ShouldBeEmptyAfterClear() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));
		queue.clear();

		assertTrue(queue.isEmpty());
	}

	@Test
	void addThenContains_ItemInQueue_ShouldReturnTrue() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		assertTrue(queue.contains(prefixes.get(2)));
	}

	@Test
	void addThenContains_ItemNotInQueue_ShouldReturnFalse() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		assertFalse(queue.contains("z"));
	}

	@Test
	void poll_QueueIsEmpty_ShouldReturnNull() {
		var queue = new LinkedListQueue<String>();

		assertNull(queue.poll());
	}

	@Test
	void addThenPoll_QueueNotEmpty_ShouldReturnItemInInsertOrder() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		prefixes.forEach(x -> assertEquals(x, queue.poll()));
	}

	@Test
	void remove_QueueIsEmpty_ShouldThrowNoSuchElementException() {
		var queue = new LinkedListQueue<String>();

		assertThrows(NoSuchElementException.class, () -> queue.remove());
	}

	@Test
	void addThenRemove_QueueNotEmpty_ShouldReturnItemInInsertOrder() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		prefixes.forEach(x -> queue.add(x));

		prefixes.forEach(x -> assertEquals(x, queue.remove()));
	}

	@Test
	void addThenSize_ShouldReturnCorrectSize() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab", "ababa", "ababab");

		prefixes.forEach(x -> queue.add(x));

		assertEquals(prefixes.size(), queue.size());
	}

	@Test
	void addAllThenSizeThenPoll_ShouldBeExpectedSizeAndRemoveInExpectedOrder() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		queue.addAll(prefixes);

		assertEquals(prefixes.size(), queue.size());
		prefixes.forEach(x -> assertEquals(x, queue.poll()));
	}

	@Test
	void add_AddANullValue_ShouldThrowNullPointerException() {
		var queue = new LinkedListQueue<String>();

		assertThrows(NullPointerException.class, () -> queue.add(null));
	}

	@Test
	void offer_AddANullValue_ShouldThrowNullPointerException() {
		var queue = new LinkedListQueue<String>();

		assertThrows(NullPointerException.class, () -> queue.offer(null));
	}

	@Test
	void iterator_addAllToQueue_ShouldEqualOriginalListIterator() {
		var queue = new LinkedListQueue<String>();
		var prefixes = List.of("a", "ab", "aba", "abab");

		queue.addAll(prefixes);

		assertIterableEquals(prefixes, queue);
	}
}
