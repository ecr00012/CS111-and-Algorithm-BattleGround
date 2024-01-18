import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * LinkedListStack Implementation
 * 
 * 
 * Replace your name below:
 * 
 * @author elirichmond
 *
 * @param <E>
 */
public class LinkedListStack<E> implements StackInterface<E> {

	LinkedList<E> list;
	private int length;
	
	public LinkedListStack() {
		list = new LinkedList<E>();
		length = 0;
	}

	@Override
	public E push(E item) {
		
		//Complete this portion
		list.add(0, item);
		length++;
		return item;
		//Add the input argument to the list and return the input argument 

	}

	@Override
	public E pop() throws EmptyStackException{
		
		//Complete this portion
		if (empty())
			throw new EmptyStackException();
		//Add a conditional statement and check whether the list is empty or not
		//In case of empty list throw exception
		var removed = list.get(0);
		list.remove(0);
		length--;
		return removed;
		//Then add the return statement in the end

	}

	@Override
	public E peek() {
		
		//Complete this portion
		
		//Add a conditional statement and check whether the list is empty or not
		//In case of empty list throw exception
		
		if (empty())
			throw new EmptyStackException();
		//Then add the return statement in the end
		return list.get(0);
	}

	@Override
	public boolean empty() {
		return length == 0;
		//Complete this portion
		//Add the return statement only

	}

	@Override
	public int search(Object searchFor) {
		//Complete this portion
		//Declare a variable for index and search for the index from the list
		int index = -1;
		boolean found = false;
		for ( int i = 0; i < length && !found; i++)
			if (list.get(i) == searchFor)
			{found = true; index = i;}
		//Add a Conditional statement, if the index is not equal to -1 then it will return index +1
		if (index !=-1 )
			return index+1;
		return index;
		//Otherwise it will return the index only
		
	}

}
