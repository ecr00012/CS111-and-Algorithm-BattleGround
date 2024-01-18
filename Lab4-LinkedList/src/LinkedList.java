import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList
 * 
 * This class is a LinkedList that implements the api of the List Interface from
 * the Java Collections Framework. We do this so we can use our custom
 * LinkedList wherever any API needs a List instance (List the sorts methods
 * from Lab3).
 * 
 * 
 * You must implement all the blank methods in this class. I have provided some
 * example method implementation to get you started. The methods that have
 * "throw new UnsupportedOperationException();" you do not have to implement.
 * 
 * 
 * You can read how each method is supposed to work here ->
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * Great Explanations on how Linked List works ->
 * https://www.youtube.com/watch?v=_jQhALI4ujg
 * 
 * Replace with your name below:
 * 
 * @author elirichmond
 *
 * @param <E> = typed variable
 */
public class LinkedList<E> implements List<E> {

	Node<E> head;
	Node<E> last;
// This method is done for you
	

	@Override
	public boolean add(E arg0) {
		//This method Appends the specified element to the end of this list
		var toAdd = Node.createNode(arg0);
		if (head == null) {
			head = toAdd;
		} else {
			var curr = head;
			while (curr.hasNext()) {
				curr = curr.getNext();
			}
			curr.setNext(toAdd);
		}
		return true;
	}

	@Override
	public void add(int indexToAddAt, E arg1) {
		Node<E> node = head;
		Node<E> node2 = null;
		if (isEmpty())
		{
			head = new Node<E> (arg1);
			last = head;
			
		}
		
		else
		{
			
			for (int i = 0; i <indexToAddAt-1; i++)
			{
				node = node.next;
			}
			node2 = node.next;
			node.next = new Node<E>(arg1, node2);
			
			
			
		}
		// Fill this portion to complete this method
		// This method Inserts the specified element at the specified position in this list

	}
	

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		
		//This method is done for you
		//This method Appends all of the elements in the specified collection to the end of this list,
		//in the order that they are returned by the specified collection’s iterator.
		arg0.forEach(x -> this.add(x));

		return true;
	}

	
	@Override
	public boolean addAll(int indexToAddAt, Collection<? extends E> arg1) {
		//This method is done for you
		//This method Inserts all of the elements in the specified collection into this list, 
		//starting at the specified position
		var toAdd = new LinkedList<E>();
		arg1.forEach(x -> toAdd.add(x));

		var curr = head;
		Node<E> prev = null;
		var index = 0;
		while (index < indexToAddAt && curr.hasNext()) {
			prev = curr;
			curr = curr.getNext();
			index++;
		}
		var addToTail = curr;
		curr = toAdd.head;
		prev.setNext(toAdd.head);
		while (curr.hasNext()) {
			curr = curr.getNext();
		}
		curr.setNext(addToTail);

		return true;
	}

	
	@Override
	public void clear()
	{
		//This method removes all of the elements from this list
		//Fill this portion to complete this method
		for (int i = 0; i <= this.size(); i++)
		{
				Node<E> node = head.next;
				head = null;
				head = node;	
		}
	}

	// Don't worry about casting, just use equals
	
	
	@Override
	public boolean contains(Object arg0) {
		//This method returns true if this list contains the specified element
		//You can change the following structure if you want to do it in a different way
		if (this.size() == 0)
			return false;
		
		Node<E> curr = head;

		while (curr.hasNext()) {
			//Fill this portion to complete this method
			//complete this portion with an If statement and return true
			if (curr.item == arg0)
				return true;
			curr = curr.next;
		}
		return false;

		//return false otherwise
	}
/*
 * 
 * 
 */
	@Override
	public E get(int index) {
		//This method returns the element at the specified position in this list
		//Fill this portion to complete this method
		Node<E> node = head;
		for (int i = 0; i < index; i++)
		{
			
			node = node.next;
			
		}
		return node.item;
	}

	@Override
	public int indexOf(Object arg0) {
		//This method returns the index of the first occurrence of the specified element in this list
		//or -1 if this list does not contain the element
		////Fill this portion to complete this method
		Node<E> node = head;
		
		
		if (!node.hasNext() && node.item == arg0)
			return 0;
		
		int count = 0;
		while (node.hasNext()) {
			

			if (head.item == arg0)
				return 0;
			while (node.hasNext())
			{
				if (node.item == arg0)
					return count;
			node = node.next;
			count++;
			}
			
	}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		//just write the return statement and check whether the size is zero or not
		//Hint: you can use this keyword with size() method
		if (this.head == null)
			return true;
		
		else
			return false;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		//This method returns the index of the last occurrence of the specified element in this list
		//or -1 if this list does not contain the element
		//Fill this portion to complete this method
		Node<E> node = head;
		int maxCount = -1;
		int count = 0;
	
		while (node.hasNext())
		{
			if (node.item == arg0)
				maxCount = count;
		node = node.next;
		count++;
		}
		
		return maxCount;

	}

	@Override
	public boolean remove(Object arg0) {
		
		//This method removes the first occurrence of the specified element from this list if it is present
		//Fill this portion to complete this method
Node<E> p = head;
boolean found = false;

int count = 0;
do
{
	if (p.item == arg0)
	{
		remove(count);
		return true;
	}

count++;
} while (!found || count < this.size());


	return found;
	}
	
	
	@Override
	public E remove(int indexToRemoveAt) {
		if (indexToRemoveAt >= this.size() || indexToRemoveAt < 0) 
			return null;
		E element = null;
		Node<E> p = head;
		if (indexToRemoveAt == 0)
		{
			element = head.item;
			head = head.next;
		}
		else {
		for (int i = 0; i < indexToRemoveAt-1; i++)
		{
			p = p.next;
		}
		element = p.next.item;
		p.next = p.next.next;
		
		
		if (p.next == null)
			last = p;
			}
		
		return element;
		//This method removes the element at the specified position in this list
		////Fill this portion to complete this method

	}

	@Override
	public int size() {
		//This method returns the number of elements in this list
		//Fill this portion to complete this method
Node<E> p = head;
int count = 0;
while (p!= null)
	{
	count++;
p = p.next;

	}
	return count;

	}

	@Override
	public List<E> subList(int start, int end) {
		//You can change the following structure if you want to do it in a different way
		List<E> list = new ArrayList<E>();
		var curr = head;
		var index = 0;
		var arrayIndex = 0;
		
			if (curr == null )
				return null;

		while (index < start) {
			//Complete this portion
			curr = curr.getNext();
			index++;
		}											// takes the linkedList index up to the sublist starting index

		
		while (index < end && curr != null) {
			//Complete this portion
			list.add(arrayIndex, curr.getItem());
			curr = curr.getNext();
			arrayIndex++;
			index++;
		}
		return list;

		//This will return list
	}

	// Methods below should not be implemented
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
