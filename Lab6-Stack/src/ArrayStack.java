import java.util.EmptyStackException;

/**
 * ArrayStack
 * 
 * ArrayBased Stack Implementation
 * 
 * Must throw a StackOverflowError if the stack can't hold anymore items
 * 
 * 
 * 
 * Replace your name below:
 * 
 * @author elirichmond
 *
 * @param <E>
 */
public class ArrayStack<E> implements StackInterface<E> {
	Object[] array;
	static final int DEFAULT_MAX_SIZE = 50;
	int maxSize;
	int top;

	public ArrayStack() {
		this(DEFAULT_MAX_SIZE);
	}

	public ArrayStack(int maxSize) {
		array = new Object[maxSize];
		top = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		
		//Complete this portion
		if (empty())
			throw new EmptyStackException();
		//Retrieve the top element of the stack without removing it and assign it to a variable (it can be type parameter E).
		var toReturn = array[top];
		//Decrement top
		array[top] = null;
		top--;
		//Return that variable
		return (E)toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		//Use conditional statement and check if the stack is empty or not
		//In case of empty stack throw exception
			if (empty())
				throw new EmptyStackException();
			return (E)array[top];
		//return the top element of the stack without removing it

	}

	@SuppressWarnings("unchecked")
	@Override
	public E push(E item) {
		//Complete this portion
		//Checks if the current position of the top of the stack is greater than or equal to the length of the array backing the stack
		//f the above condition is true, an error is thrown indicating that the stack has overflowed
if (top >= array.length-1)
throw new StackOverflowError();
		//assign the item being pushed to the next available position in the array backing the stack
array[top+1] = item;
top++;
		//Increment top pointer to point to the next available position in the array
		//returns the item that was just pushed onto the top of the stack
return (E)array[top];
	}

	@Override
	public boolean empty() {
		
		//Complete this portion
		//Add a return statement when top is equal to 0
		return top == 0;
			
		//It checks if the top of the stack is at the bottom (i.e., there are no elements in the stack)
		
	}

	@Override
	public int search(Object o) {
		
		//Complete this portion
		//This method returns the 1-based position of the object o in the stack, relative to the top of the stack.
		//Take a loop to iterate over the elements in the stack starting from top and going down to the bottom
		for (int i = top++; i > 0; i--)
			if (o.equals(array[i]))
			return top-i;
		
		//Inside the loop body check if 'o' is equal to 'array[i]'
		//If it is, then the method returns the 1-based position of the element by subtracting i from the top position 
		//If the loop completes without finding a match, the method returns -1 to indicate that 'o' is not present in the stack
		return -1;
	}

}
