import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A LinkedList Implementation of a Queue
 * 
 * You may either use the LinkedList Class for data storage OR a custom node
 * class (This is how the slides show it)
 * 
 * Replace your name below:
 * 
 * @author elirichmond
 *
 * @param <E> type this queue holds
 */
public class LinkedListQueue<E> implements Queue<E> {  //defining a class called LinkedListQueue that implements the Queue interface for a generic type E.
	LinkedList<E> list;  //defining an instance variable list of type LinkedList<E> to hold the elements of the queue.

	public LinkedListQueue() {
		//This is a constructor method for the LinkedListQueue class that initializes the list variable to a new empty LinkedList object.
		list = new LinkedList<E>();
	}

	// Same as enqueue
	@Override
	public boolean add(E arg0) {
		//Complete this portion
		
		//This method adds a new element to the end of the queue. 
		//Hint: It first checks if the element being added (input argument) is null, and if so, it throws a NullPointerException.
		if (arg0 == null)
			throw new NullPointerException();
		//Hint: Otherwise, it adds the element to the end of the list and returns true.
		else return list.add(arg0);

	}

	@Override
	public boolean offer(E arg0) {
		//Complete this portion
		
		//This method adds a new element to the end of the queue.
		return this.add(arg0);
		//Hint: It simply calls the add method and returns its result. (Use this keyword with add method)

	}

	@Override
	public E element() {
		//Complete this portion
		if (isEmpty())
			throw new NoSuchElementException();
		//This method retrieves the element at the front of the queue without removing it.
		//Hint: It returns the first element of the list.
		return list.get(0);

	}

	@Override
	public E peek() {
		//Complete this portion
		if (isEmpty())
			return null;
		//This method retrieves the element at the front of the queue without removing it.
		//Hint: It returns the first element of the list.
		return list.get(0);
	}

	// Same as dequeue
	@Override
	public E poll() {
		//Complete this portion
		if (isEmpty())
			return null;
		//This method retrieves and removes the element at the front of the queue.
		//Hint: It removes and returns the first element of the list.
		
		return list.remove(0);
		

	}

	@Override
	public E remove() {
		//Complete this portion
		if (isEmpty())
			throw new NoSuchElementException();
		//This method retrieves and removes the element at the front of the queue.
		//Hint: It removes and returns the first element of the list.

		return list.remove(0);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		//Complete this portion
		
		//This method adds all the elements from a collection to the end of the queue.
		//Hint: It adds all the elements from the input collection to the end of the list and returns true.
		
	
		return list.addAll(arg0);
	}

	@Override
	public void clear() {
		//Complete this portion
		
		//This method removes all elements from the queue. 
		//Hint: It simply calls the clear method on the list object.
		
		list.clear();

	}

	@Override
	public boolean contains(Object arg0) {
		//Complete this portion
		
		//This method checks whether the queue contains a specific element.
		//It returns true if the list contains the input element, and false otherwise.

		return list.contains(arg0);

	}

	@Override
	public boolean isEmpty() {
		//Complete this portion
		
		//This method checks whether the queue is empty
		//Hint: It returns 'true' if the 'list' is empty, and 'false' otherwise.

		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		//Complete this portion
		
		//This method returns an iterator over the elements in the queue.
		//Hint: It returns an iterator over the elements in the list.
		return list.iterator();
	}

	@Override
	public int size() {
		//Complete this portion
		
		//This method returns the number of elements in the queue.
		//Hint: It returns the size of the list.
		return list.size();

	}

	// Don't Implement Below Methods (These methods come from inherited interfaces,
	// not necessary for Queue)

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
