import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	@Test
	public void pushThenPeek_Add1_ShouldBeAtTopOfStack() {
		var stack = new LinkedListStack<Integer>();
		var item = 5;

		stack.push(item);

		assertEquals(item, stack.peek());
	}

	@Test
	public void pushThenPeek_AddSeveral_ShouldHaveLastAddedAtTopOfStack() {
		var stack = new LinkedListStack<String>();
		var bestLanguages = List.of("C", "C++", "Java", "Javascript", "Haskell");

		bestLanguages.forEach((x) -> stack.push(x));

		assertEquals(Utils.getLast(bestLanguages), stack.peek());
	}

	@Test
	public void pushThenPop_Add1AndPop_ShouldPopOffAddedItem() {
		var stack = new LinkedListStack<Integer>();
		var item = 5;

		stack.push(item);
		var popped = stack.pop();

		assertEquals(item, popped);
	}

	@Test
	public void pushThenPop_AddSeveralAndPopSeveral_ShouldPopInExceptedOrder() {
		var stack = new LinkedListStack<String>();
		var bestLanguages = List.of("C", "C++", "Java", "Javascript", "Haskell");
		var expectedPopOrder = Utils.reverse(bestLanguages);

		bestLanguages.forEach((x) -> stack.push(x));

		expectedPopOrder.forEach((x) -> assertEquals(x, stack.pop()));
	}

	@Test
	public void empty_IsEmptyStack_ShouldReturnTrue() {
		var stack = new LinkedListStack<String>();
		assertTrue(stack.empty());
	}

	@Test
	public void pushThenEmpty_IsNotEmpty_ShouldReturnFalse() {
		var stack = new LinkedListStack<String>();
		var bestLanguages = List.of("C", "C++", "Java", "Javascript", "Haskell");

		bestLanguages.forEach((x) -> stack.push(x));

		assertFalse(stack.empty());
	}

	@Test
	public void pushThenSeek_ItemLies3PopsAway_ShouldReturnDistanceFromTop() {
		var stack = new LinkedListStack<String>();
		var correctStack = new Stack<String>();
		var bestLanguages = List.of("C", "C++", "Java", "Javascript", "Haskell");

		bestLanguages.forEach((x) -> stack.push(x));
		bestLanguages.forEach((x) -> correctStack.push(x));

		assertEquals(correctStack.search("Java"), stack.search("Java"));
	}

	@Test
	public void pushThenSeek_ItemNotInStack_ShouldReturnMinus1() {
		var stack = new LinkedListStack<String>();
		var bestLanguages = List.of("C", "C++", "Java", "Javascript", "Haskell");
		var expectedDistance = -1;

		bestLanguages.forEach((x) -> stack.push(x));

		var distanceToTop = stack.search("Ada");

		assertEquals(expectedDistance, distanceToTop);
	}

	@Test
	public void peek_StackIsEmpty_ShouldThrowStackException() {
		var stack = new LinkedListStack<String>();

		assertThrows(EmptyStackException.class, () -> stack.peek());
	}

	@Test
	public void pop_StackIsEmpty_ShouldThrowStackException() {
		var stack = new LinkedListStack<String>();

		assertThrows(EmptyStackException.class, () -> stack.pop());
	}
}
