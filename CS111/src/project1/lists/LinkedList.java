package project1.lists;

import java.util.*;

/**
* Custom LinkedList Implementation
*
* @author Eli Richmond
* @version 1.0
* @since 2023-03-10
*/
	public class LinkedList<E> implements List<E> {

		Node<E> head;
		Node<E> last;
		private int length;
		
		public LinkedList() {
			
			head = last = null;
			length = 0;
			
		}
	
		
		/*add, appends element to end of list
		 * 
		 * @Param E arg0
		 * @Returns true if successful
		 */
		@Override
		public boolean add(E arg0) throws NullPointerException{
			//This method Appends the specified element to the end of this list
			
			if (arg0 == null)
				throw new NullPointerException();			//input validation
			
			var toAdd = Node.createNode(arg0);				
			if (head == null) {								// if empty
				head = toAdd;
				last = head;
			} else {
				
				last.next = toAdd;
				last = toAdd;
			}
			length++;										// increment length
			return true; 
		}

		/*add, adds element to the specified position
		 * 
		 * @Param int indexToAddAt, E arg1
		 */
		@Override
		public void add(int indexToAddAt, E arg1) throws NullPointerException, IndexOutOfBoundsException {
			if (indexToAddAt < 0 || indexToAddAt > length)
				throw new IndexOutOfBoundsException();
			
			if (arg1 == null)
				throw new NullPointerException(); 						// input validation
			
			
			Node<E> node = head;
			Node<E> node2 = null;
			
			if (isEmpty())												// if empty
			{
				head = new Node<E> (arg1);
				last = head;
			}
			
			if (indexToAddAt == length) {
			 node = last.next = new Node<E>(arg1);
			last = node;}
			
			else														// if adding at head
			{
				if (indexToAddAt == 0)
					{
					
				head  = new Node<E>(arg1, node);
				last = node;
				
					}
				
				else 													// regular case
					{
				for (int i = 0; i <indexToAddAt-1; i++)
				{
					node = node.next;
				}
				last = node2 = node.next;
				node.next = new Node<E>(arg1, node2);
					}
				
				
				
			}
			
			
	
			length++;													
		}
		
		/*addAll, appends all elements in collection to the end of the list
		 * 
		 * @Param Collection arg0
		 * @Returns true if successful
		 */
		@Override
		public boolean addAll(Collection<? extends E> arg0) throws NullPointerException{
			
			
			//This method Appends all of the elements in the specified collection to the end of this list,
			//in the order that they are returned by the specified collection’s iterator.
			if (arg0 == null)
				throw new NullPointerException();						//input validation
			
			
			arg0.forEach(x -> this.add(x));								// calls add for each element

			return true;
		}

		/*addAll, inserts all elements in collection at specified collection in the list
		 * 
		 * @Param int indexToAddAt, Collection<? extends E> arg1 
		 * @Returns true if successful
		 */
		@Override
		public boolean addAll(int indexToAddAt, Collection<? extends E> arg1) throws IndexOutOfBoundsException, NullPointerException {
		
			//This method Inserts all of the elements in the specified collection into this list, 
			//starting at the specified position
			if (arg1 == null)
				throw new NullPointerException();
			
			if (indexToAddAt < 0 || indexToAddAt > size())
				throw new IndexOutOfBoundsException();					//input validation
			
			var toAdd = new LinkedList<E>();
			arg1.forEach(x -> toAdd.add(x));							// create separate list of elements to add

			var curr = head;
			Node<E> prev = null;
			var index = 0;
			while (index < indexToAddAt && curr.hasNext()) {			// traversal
				prev = curr;
				curr = curr.getNext();
				index++;
			}
			var addToTail = curr;
			curr = toAdd.head;
			prev.setNext(toAdd.head);
			while (curr.hasNext()) {									// traversal
				curr = curr.getNext();
			}
			curr.setNext(addToTail);

			length+=arg1.size();
			return true;
			
		}

		/*clear, renders all nodes in list null, empties list and sets length to 0
		 * 
		 */
		@Override
		public void clear()
		{
			//This method removes all of the elements from this list
			
			/*for (int i = 0; i < length; i++)
			{
					Node<E> node = head.next;	
					head = null;
					head = node;	
			}*/
			head = null;
			last = null;
			length = 0;
		}

		// Don't worry about casting, just use equals
		
		/*contains, checks if element is in list 
		 * 
		 * @Param Object arg0 
		 * @Returns true if element is in list 
		 */
		@Override
		public boolean contains(Object arg0) throws NullPointerException {
			//This method returns true if this list contains the specified element
			if (arg0 == null )
				throw new NullPointerException();									//input validation
			
			if (length == 0)
				return false;
			
			Node<E> curr = head;

			while (curr.hasNext()) {												// traversal
				
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
		@Override
		public E get(int index) throws IndexOutOfBoundsException {
			//This method returns the element at the specified position in this list
			
			if (index < 0 || index > length)
				throw new IndexOutOfBoundsException();				//input validation
			Node<E> node = head;
			
			for (int i = 0; i < index; i++)							// traversal
			{
				
				node = node.next;
				
			}
			return node.item;
		}

		/*indexOf, returns first occurrence of element in list
		 *
		 * @Param Object arg0 to be searched for
		 * @Returns index of first arg0
		 */
		@Override
		public int indexOf(Object arg0) throws NullPointerException {
			//This method returns the index of the first occurrence of the specified element in this list
			//or -1 if this list does not contain the element
			
			Node<E> node = head;
			
			if (arg0 == null)
				throw new NullPointerException();							//input validation
			
			
			int count = 0;
			do {															// compares to locate index
				if (node.item == arg0)
				return count;
				node = node.next;
				count++; 
				} while (node.hasNext());
				
		
			return -1;
		}

		/*isEmpty, checks if list is empty
		 * @Returns true if empty
		 */
		@Override
		public boolean isEmpty() {
			
			return length == 0;
		}

		/* lastIndexOf returns last occurrence of arg0 in the list
		 * 
		 * @Param	arg0 to be searched for
		 * @Returns index 
		 */
		@Override
		public int lastIndexOf(Object arg0) throws NullPointerException{
			//This method returns the index of the last occurrence of the specified element in this list
			//or -1 if this list does not contain the element
		
			if (arg0 == null)
				throw new NullPointerException();								//input validation
			
			Node<E> node = head;
			int maxCount = -1;
			int count = 0;
		
			while (node.hasNext())												// traversal
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
		 * @Returns true if arg0 is found and removal is successful
		 */
		@Override
		public boolean remove(Object arg0) throws NullPointerException {
			
			//This method removes the first occurrence of the specified element from this list if it is present
			
			
			if (arg0 == null)
				throw new NullPointerException();							//input validation
			
	Node<E> p = head;
	boolean found = false;

	int count = 0;
	do
	{										
		if (p.item == arg0)
		{	
			remove(count);													// calling remove(indexToRemoveAt)
			return true;	
		}

	count++;
	} while (!found || count < this.size());

	
		return found;
		}
		
		/* remove, removes node at index from list
		 * 
		 * @Param index whose Node is removed
		 * @Returns E, removed Node's element
		 */
		@Override
		public E remove(int indexToRemoveAt) throws IndexOutOfBoundsException {
			
			if (indexToRemoveAt > length || indexToRemoveAt < 0) 
				throw new IndexOutOfBoundsException();			//input validation
			
			E element = null;
			Node<E> p = head;
			if (indexToRemoveAt == 0)							// if removal object is at index 0
			{
				element = head.item;
				head = head.next;
			}
			else {
			for (int i = 0; i < indexToRemoveAt-1; i++)			// regular case
			{
				p = p.next;
			}
			element = p.next.item;
			p.next = p.next.next;
			
			
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
		@Override
		public int size() {
			//This method returns the number of elements in this list
			//Fill this portion to complete this method
return length;

		}

		/* subList, returns reference to new list of DLNodes 
		 * 
		 * @Param ints start, end: range of new list 
		 * @Returns DoublyLinkedList<E> of  Nodess from start index to end 
		 */
		@Override
		public List<E> subList(int start, int end) throws IndexOutOfBoundsException {
			
			if (start < 0 || start > length || end < 0 || end > length || start > end) 
				throw new IndexOutOfBoundsException();					//input validation
							
			List<E> list = new ArrayList<E>();
			var curr = head;
			var index = 0;
			var arrayIndex = 0;
			
				if (curr == null )
					return null;

			while (index < start) {
				//Complete this portion
				curr = curr.next;
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
		
		
		private class itr implements Iterator<E>
		{
			private Node<E> cursor;
			private int index;
			private int size;
			itr()
			{
				cursor = head;
				index = 0;
				size = length;
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
			public E next() 
			{
				if (!hasNext())
					throw new NoSuchElementException();
				if (index == 0)
				{index++; return cursor.item;}
				index ++;
				cursor = cursor.next;
				return cursor.item;
			}
			
			
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return new itr();
		
		
		
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
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
			
			if (element == null)
				throw new NullPointerException();						//input validation
			
			Node<E> p = head;
			for (int i = 0; i < index; i++)								// traversal
			p = p.next;
			p.item = element;
			return element;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
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
		Node<E> curr = head;

		while (curr.next != null) {
		curr = curr.next;
		result += curr.item + ", ";
		}
		return result;
		}
}
