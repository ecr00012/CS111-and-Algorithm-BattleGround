package project1.lists;


import java.util.*;

/**
* Custom DoublyLinkedList Implementation
*
* @author Eli Richmond
* @version 1.0
* @since 2023-03-10
*/


public class DoublyLinkedList<E> implements List<E>  {

	DoublyLinkedNode<E> head;
	DoublyLinkedNode<E> last;
	private int length;
	
	public DoublyLinkedList(){
		
		length = 0;
		head = last = null;
		
	}
	/* add, appends element to end of list
	 * 
	 * @Param E arg0
	 * @Returns true if successful
	 */
	public boolean add(E arg0) throws NullPointerException
	{
	
		
		if (arg0 == null)
			throw new NullPointerException();								//input validation
		
		DoublyLinkedNode<E> toAdd = new DoublyLinkedNode<E>(arg0, last);
		
		if (head == null)													// if list is empty
			head = last = new DoublyLinkedNode<E>(arg0);
			
		else																// regular case
			{
			last.next= toAdd; 
			last = toAdd; 
			}
		
		
			
		length++;
		
		return true;
	}

	/*add, adds element to the specified position
	 * 
	 * @Param int indexToAddAt, E arg1
	 */
	public void add(int indexToAddAt, E arg1) throws NullPointerException, IndexOutOfBoundsException{
		
		if (arg1 == null)
			throw new NullPointerException();						
		
		if (indexToAddAt > length || indexToAddAt < 0)
			throw new IndexOutOfBoundsException();					//input validation
		
		DoublyLinkedNode<E> node = head;
		
		
		if (isEmpty())												// if list is empty
		{
			head = new DoublyLinkedNode<E> (arg1);
			last = head;
		}
		
		
		else														
		{
			if (indexToAddAt == 0)  								// if adding at head
				{
			
			head  = new DoublyLinkedNode<E>(arg1, null, node);
			node.previous = head;
			
			
			
				}
			
			else 													// regular case + traversal
				{	
				if (indexToAddAt < length/2)
			node = this.forwardTraversal(indexToAddAt);
				
				else
			node =	this.backwardTraversal(indexToAddAt);
			
			node.setNext(new DoublyLinkedNode<E>(arg1, node, node.next));
			 if (last == node)
			last = node.next;
		
				}
			
			
		}
		length++;
		// Fill this portion to complete this method
		// This method Inserts the specified element at the specified position in this list

	}
	
	/*forwardTraversal, returns a node to the position before the desired node at the index by walking forwards from the head
	 * 
	 * @Param index
	 * @Returns DoublyLinkedNode<E> node, before the desired index
	 */
		public DoublyLinkedNode<E> forwardTraversal(int index) {
			var node = head;
			for (int i = 0; i < index-1; i++)
			node = node.next;
			return node;
		}
		
		/*backwardTraversal, returns a node to the position before the desired node by walking backwards from the last node
		 * 
		 * @Param 	 index
		 * @Returns  DoublyLinkedNode<E> node, before the desired index
		 */
		public DoublyLinkedNode<E> backwardTraversal(int index) {
			var node = last;
			for (int i = length-1; i > index-1; i--)
			node = node.previous;
			return node;
		}
			
		
		/*addAll, appends all elements in collection to the end of the list
		 * 
		 * @Param Collection arg0
		 * @Returns true if successful
		 */
	public boolean addAll(Collection<? extends E> arg0) throws NullPointerException {
		
		//This method Appends all of the elements in the specified collection to the end of this list,
		//in the order that they are returned by the specified collection’s iterator.
		if (arg0 == null)
			throw new NullPointerException();					//input validation
		
		arg0.forEach(x -> this.add(x)); 						// calls add for each element of arg0
		
		return true;
	}

	/*addAll, inserts all elements in collection at specified collection in the list
	 * 
	 * @Param int indexToAddAt, Collection<? extends E> arg1 
	 * @Returns true if successful
	 */
	public boolean addAll(int indexToAddAt, Collection<? extends E> arg1) throws NullPointerException, IndexOutOfBoundsException{
		
		if (arg1 == null)
			throw new NullPointerException();
		
		if (indexToAddAt > length || indexToAddAt < 0)
			throw new IndexOutOfBoundsException();							//input validation
		
		var toAdd = new DoublyLinkedList<E>();
	
		toAdd.addAll(arg1);
		var curr = this.head;
		
		
		
		if (indexToAddAt == 0)									// if adding at head
		{
			
			this.head = toAdd.head;
			toAdd.last.next = curr;
			curr.previous = toAdd.last;
			
			
		}
	//	
		else  {
			if (indexToAddAt < length/2)						// regular case + traversal
				 this.forwardTraversal(indexToAddAt);
				
				else 
					 this.backwardTraversal(indexToAddAt);
	
		var node = curr.next;
		curr.next = toAdd.head;
		toAdd.head.previous = curr;
		toAdd.last.next = node;
		}
		
		length+=arg1.size();
		
		return true;
	}

	
	/*clear, renders all nodes in list null, empties list and sets length to 0
	 * 
	 */
	public void clear()
	{
		head = null;
		last = null;
		/*for (int i = 0; i < length; i++)
		{
				DoublyLinkedNode<E> node = head.next;
				head = null;
				head = node;	
		}*/
		length = 0;
	}

	
	
	
	/*contains, checks if element is in list 
	 * 
	 * @Param Object arg0 
	 * @Returns true if element is in list 
	 */
	public boolean contains(Object arg0) throws NullPointerException {
		//This method returns true if this list contains the specified element
	
		if (arg0 == null)
			throw new NullPointerException();						//input validation
		if (length == 0)
			return false;
		
		DoublyLinkedNode<E> curr = head;

		while (curr.hasNextNode()) {								// 	comparison
			
			if (curr.item == arg0)
				return true;
			curr = curr.next;
		}
		return false;

		//return false otherwise
	}

	/*get, returns element at index
	 * 
	 * @Param int index
	 * @Returns element at index
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		//This method returns the element at the specified position in this list
	if (index > length || index < 0)
		throw new IndexOutOfBoundsException();									//input validation
	
		if (index == 0)
			
		return this.head.item;
		if (index > length/2)
			return this.backwardTraversal(index).next.item;						// traversal + returns
		
		else 
			return this.forwardTraversal(index).next.item;
	}

	/*indexOf, returns first occurrence of element in list
	 *
	 * @Param Object arg0 to be searched for
	 * @Returns index of first arg0
	 */
	public int indexOf(Object arg0) throws NullPointerException{
		
		DoublyLinkedNode<E> node = head;
		
		if (arg0 == null)
			throw new NullPointerException();									//input validation
		
		if (!node.hasNextNode() && node.item == arg0)
			return 0;
		
		int count = 0;
		
			do																	// comparisons
			{
				if (node.item == arg0)
					return count;
			node = node.next;
			count++;
			} while (node.hasNextNode());
			
	
		return -1;
	}

	/*isEmpty, checks if list is empty
	 * @Returns true if empty
	 */
	public boolean isEmpty() {
		
		return length == 0;
	}

	/* lastIndexOf returns last occurrence of arg0 in the list
	 * 
	 * @Param	arg0 to be searched for
	 * @Returns index 
	 */
	public int lastIndexOf(Object arg0) throws NullPointerException {
		
		
		if (arg0 == null)
			throw new NullPointerException();								// input validation
		DoublyLinkedNode<E> node = head;
		int maxCount = -1;
		int count = 0;
	
		while (node.hasNextNode())											// comparisons
		{	
			if (node.item == arg0)
				maxCount = count;
		node = node.next;
		count++;
		}
		
		return maxCount;

	}

	/*remove, removes Node from list by locating index and calling remove(int index)
	 * 
	 * @Param arg0 to be removed
	 * @Returns true if successful
	 */
	public boolean remove(Object arg0) throws NullPointerException {
		
		//This method removes the first occurrence of the specified element from this list if it is present
		if (arg0 == null)
			throw new NullPointerException();								// input validation
		
DoublyLinkedNode<E> p = head;
boolean found = false;

int index = 0;
do
{
	if (p.item.equals(arg0))												// traversal + removal
	{
		
		remove(index);														// call to remove(indexToAddAt)
		found = true;
		
	}
	p = p.next;
index++;
} while (!found && index < length);


	return found;
	}
	
	
	
	/* remove, removes node at index from list
	 * 
	 * @Param index whose Node is removed
	 * @Returns E, removed Node's element
	 */
		public E remove(int indexToRemoveAt) throws IndexOutOfBoundsException {
			
			
			if (indexToRemoveAt >= length || indexToRemoveAt < 0) 
				throw new IndexOutOfBoundsException();							// input validation
			
			E element = null;
			DoublyLinkedNode<E> p = head;
			if (indexToRemoveAt == 0)											// if removing head
			{
				element = head.item;
				head = head.next;
			}
			else if (indexToRemoveAt == length-1)								// if removing last
			{
				last = last.previous;
				last.next = null;
				
			} 
			
			else {
				if (indexToRemoveAt < length/2)
					p = forwardTraversal(indexToRemoveAt+1);
				
				else 
					p = backwardTraversal(indexToRemoveAt+1);
			element = p.item;
			
			p.previous.next = p.next;
			p.next.previous = p.previous;
			
			if (p.next == null)
				last = p;
				}
			
			length--;
			
			return element;

	}
		

		/* size, # of Nodes in list
		 *
		 * @Returns length of list
		 */
	public int size() {
		//This method returns the number of elements in this list
		
return length;

	}

	/* subList, returns reference to new list of DLNodes 
	 * 
	 * @Param ints start, end: range of new list 
	 * @Returns DoublyLinkedList<E> of  Nodess from start index to end 
	 */
	public List<E> subList(int start, int end)  throws IndexOutOfBoundsException{
		
		if (start < 0 || start > length || end < 0 || end > length || start > end) 
			throw new IndexOutOfBoundsException();
		
		List<E> list = new ArrayList<E>();
		var curr = head;
		var index = 0;
		var arrayIndex = 0;
		
			if (curr == null )
				return null;

		while (index < start) {
			//Complete this portion
			curr = curr.getNextNode();
			index++;
		}											// takes the linkedList index up to the sublist starting index

		
		while (index < end && curr != null) {
			//Complete this portion
			list.add(arrayIndex, curr.getItem());
			curr = curr.getNextNode();
			arrayIndex++;
			index++;
		}
		return list;

		//This will return list
	}

	
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return new listItr();
	}
		private class listItr implements ListIterator<E>
		
		{
			
			private DoublyLinkedNode<E> cursor = head;
			private int index;
			private int size;
			
			public listItr()
			{
				index = 0;
				size = length;
				cursor = head;
			}
			
			/*hasNext, checks if index is not equal to size, ergo if current node's next reference is null
			 * 
			 * @Returns true if index is less than size
			 */
			@Override
			public boolean hasNext() 
			{
				return index != size;
			}
			
			/*next, returns cursor item then advances cursor
			 * 
			 * @Returns E item of cursor prior to advancement of cursor position
			 */
			@Override
			public E next() throws NoSuchElementException
			{
				if (!hasNext())
					throw new NoSuchElementException();
				index++;
				E value = cursor.item;
				cursor = cursor.next;
				if (cursor == null)
					cursor = last;
				
				return value;
				
			}
			
			/*hasPrevious, checks if index is not 0, ergo if cursor's previous field is null
			 * 
			 * @Returns true if cursor has previous node
			 */
			@Override
			public boolean hasPrevious() 
			{
				return index != 0;
				
			}
			
			/*previous, returns current item then sets cursor to previous position 
			 * 
			 * @Returns item at current position prior to cursor position change
			 */
			@Override
			public E previous() throws NoSuchElementException
			{
			if (!hasPrevious())
				throw new NoSuchElementException();
			index--;
			
			E value = cursor.item;
			cursor = cursor.previous;
			
			
			return value;
				
			}
			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void set(E e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void add(E e) {
				// TODO Auto-generated method stub
				
			}
		
		
		
		}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	/*set, changes node item at index to provided element
	 * 
	 * @Param int index, E element
	 * @Returns item that is added
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		// TODO Auto-generated method stub
		if (index > length || index < 0)
			throw new IndexOutOfBoundsException();
		if  (element == null)
			throw new NullPointerException();						// input validation
		
		DoublyLinkedNode<E> p = head;
		
		if (index < length/2)										// traversal
		p = this.forwardTraversal(index+1);
		
		else
		p = this.backwardTraversal(index+1);
		
		p.item = element;
		return element;
	}

	
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return  new listItr();
	}

	
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*toStirng, converts list to String
	 * 
	 * @Returns String format of list
	 */
	@Override
	public String toString() {
	if (head == null) {
	return "";
	}
	String result = head.item + ", ";
	DoublyLinkedNode<E> curr = head;

	while (curr.next != null) {
	curr = curr.next;
	result += curr.item + ", ";
	}
	return result;
	}
}

	

