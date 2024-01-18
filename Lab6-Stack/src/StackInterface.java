import java.util.EmptyStackException;

/**
 * STACK ADT
 * 
 * Operations a Stack Instance MUST fulfill.
 * 
 * Ripped operations and docs from:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#push(E)
 * 
 * @author zadidhabib
 *
 * @param <E> Whatever type the stack holds
 */
public interface StackInterface<E> {

	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 * 
	 * 
	 * @return The object at the top of this stack (the last item of the Vector
	 *         object).
	 * 
	 * @throws EmptyStackException - if this stack is empty.
	 */
	E pop();

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack (the last item of the Vector
	 *         object).
	 * 
	 * @throws EmptyStackException - if this stack is empty.
	 */
	E peek();

	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect
	 * as:
	 * 
	 * addElement(item)
	 * 
	 * 
	 * @param item- the item to be pushed onto this stack.
	 * @return the item argument.
	 * 
	 * @throws StackOverflowError - Only for stacks implementation that have a
	 *                            limited storage capacity
	 */
	E push(E item);

	/**
	 * Tests if the stack is empty
	 * 
	 * @return true if and only if this stack contains no items, false otherwise
	 */
	boolean empty();

	/**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * o occurs as an item in this stack, this method returns the distance from the
	 * top of the stack of the occurrence nearest the top of the stack; the topmost
	 * item on the stack is considered to be at distance 1. The equals method is
	 * used to compare o to the items in this stack.
	 * 
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack.
	 */
	int search(Object o);
}
