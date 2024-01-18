package project1.lists;
import java.util.*;

//import project1.datahandlers.Signal;

/**
* Custom ArrayList Implementation
*
* @author Eli Richmond
* @version 1.0
* @since 2023-03-10
*/
public class ArrayList<E extends Object> implements List<E>  {

	private final int DEF = 10;
	private int capacity;
	private int length;
	private Object[] array;
	
	/* Default constructor
	 */
	public ArrayList()
	{
		this.capacity = DEF;
		this.length = 0;
		this.array = new Object[DEF];
	}
	
	/*constructor
	 * @Param int size, alters Obj array capacity to provided size
	 */
	public ArrayList(int size) throws IndexOutOfBoundsException
	{
		
		if (size < 1)
			throw new IndexOutOfBoundsException();
		this.capacity = size;
		this.length = 0;
		this.array = new Object[size];
	}
	
	

	/*expand, increases capacity by 10 by creating a new array with previous capacity+10 
	 */
	public void expand() 
	{
		Object[] temp =  new Object[capacity+10];
		for (int i = 0; i < length; i++)
		temp[i] = array[i];
		capacity+= 10;
		array = temp;
	}

	/* size, returns length
	 * @Returns int size, # of elements in the backing array
	 */
	@Override
	public int size() 
	{
		return length;
	}
	
	/* isEmpty, checks if backing Obj array has any elements
	 * @Returns true if arrayList is empty, false if not
	 */
	@Override
	public boolean isEmpty() 
	{
		return length == 0;
	}
	
	/* contains, checks if provided o is in the array
	 * 
	 * @Param Object o to be searched for
	 * @Returns true if array contains o
	 */
	@Override
	public boolean contains(Object o) throws NullPointerException
	{
		if (o == null)
			throw new NullPointerException();				// input validation
		
		for (Object e : array) 
			if (o == e)				
				return true;
		
		return false;
	}
	
	/*add, appends element to last index of array
	 * 
	 * @Param E element to be added
	 * @Returns true if successful
	 */
	@Override
	public boolean add( E element) throws NullPointerException
	{
		if (element == null)
			throw new NullPointerException();				// input validation
		// construct iterator
		
		if (length >= capacity)
		expand();
		array[length] = element;
		length++;
		
		return true;
	}
	
	/*remove, removes o from list by locating its index and calling remove(index)
	 * 
	 * @Param Object o to be removed
	 * @Returns true if successful
	 */
	@Override
	public boolean remove(Object o) throws NullPointerException 
	{
		if (o == null)
			throw new NullPointerException();			// input validation
		int index = indexOf(o);	
		remove(index);									// call to remove(indexToRemoveAt)
		return true;
	}
	
	/*addAll, adds all elements in collection to the list 
	 * 
	 * @Param Generic Collection c 
	 * @Returns true if successful
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) throws NullPointerException
	{
		if (c == null)
			throw new NullPointerException();				// input validation	
		var cSize = c.size();
		var tSize = cSize + length;
		Iterator<? extends E> it = c.iterator();
		while (tSize > capacity)							// validate capacity
			expand();
		
		for (int i = 0; i < c.size(); i++)					// add all elements
			array[length + i] = it.next();	
		
		length+=c.size();
		
		return true;
	}
	
	/*addAll, adds all elements at specific index 
	 * 
	 * @Param int index, Collection<? extends E> c
	 * @Returns true if successful
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) throws NullPointerException, IndexOutOfBoundsException
	{
		if (index > length || index < 0)
		throw new IndexOutOfBoundsException();
		
		if (c == null)
			throw new NullPointerException();									// input validation
		
		int cSize = c.size();
		while (length + cSize > capacity)
		this.expand();
		
		if (cSize == 0)															// if nothing to add
			return true;
		
		for (int i =length-1 ; i >= index; i--)									// creating space
			array[cSize+ i] = array[i];
		
		for (E element: c)
			array[index++] = element;											// adding at element
	//	for(int i = 0; i < length-index; i++)
	//  array[index+i] = it.next();
	
		length+= cSize;
		return true;
	}
	
	/*clear, assigns array to new, empty Obj array
	 */
	@Override
	public void clear()
	{
		array = new Object[DEF];
		length = 0;
		capacity = DEF;
	}
	
	/*get, returns element at index
	 * 
	 * @Param index
	 * @Returns E element 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E get(int index)  throws IndexOutOfBoundsException
	{
		if (index >= length || index < 0)
			throw new IndexOutOfBoundsException();							// input validation
		
		return (E)array[index];
		
		
	}
	
	/*set, sets element at index to provided E
	 * 
	 * @Param int index, E element
	 * @Returns item that was previously at index
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException
	{
		if (index > length || index < 0)
			throw new IndexOutOfBoundsException();
		
		if (element == null)
			throw new NullPointerException();								// input validation
		
		
		E temp = (E)array[index];						
		array[index] = element;
		return temp;
	}
	
	/* adds element at index 
	 * @Param int index, E element 
	 */
	@Override
	public void add(int index, E element)  throws IndexOutOfBoundsException, NullPointerException
	{
		if (index > length || index < 0)
			throw new IndexOutOfBoundsException();
		
		if (element == null)
			throw new NullPointerException();								// input validation
		
		length++;
		if (length >= capacity)												// ensure capacity
			expand();
		int end = length-1;
		for (int i = end; i >= index; i--)									// move all elements after index over one space
			array[i+1] = array[i];
		array[index] = element;
		
	}
	
	/*removes element at index and shifts all elements down to compensate
	 * 
	 * @Param index to remove
	 * @Returns E previously at index
	 */
	@Override
	public E remove (int index) throws IndexOutOfBoundsException
	{
		if (index >= length || index < 0)
			throw new IndexOutOfBoundsException();							// input validation
		
		@SuppressWarnings("unchecked")
		E temp = (E)array[index];
		for (int i = index; i < length; i++)								// move elements over, rewriting element to be removed
		array[i] = array[i+1];
		length--;
		return temp;
	}
	
	/*indexOf, returns first occurrence of o
	 * 
	 * @Param Object to be searched for
	 * @Returns index of o
	 */
	@Override
	public int indexOf(Object o) throws NullPointerException {
		
		if (o == null)
			throw new NullPointerException();								// input validation
		
		for (int i = 0; i < length; i++)
		{
			if (array[i] == o)
			return i;
		}
		
		
		return -1;
		
	}
	
	/*returns index of last occurrence of o
	 * 
	 * @Param Object to be searched for
	 * @Returns int index of last occurrence
	 */
	@Override
	public int lastIndexOf(Object o) throws NullPointerException
	{
		if (o == null)
			throw new NullPointerException();								// input validation
		
		for (int i = length-1; i >= 0; i--)
		{
		
			if (o == array[i])
			return i;
		}
		
		return -1;
		
	}
	
	/*subList returns new ArrayList view of specified portion of ArrayList
	 * 
	 * @Param indexes of beginning + end of desired list
	 * @Returns new ArrayList
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException
	{
		
		if (fromIndex > length || fromIndex < 0 || toIndex > length || toIndex < 0 )
			throw new IndexOutOfBoundsException();										// input validation
		
		
		
		ArrayList<E> list = new ArrayList<E>();
		
		
		for (int i = fromIndex; i < toIndex; i++)
		list.add(this.get(i));	
		return list;
		
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Itr();
	}
	
	private class Itr implements Iterator<E>
	{
		private int index;
		private int size;
		
		Itr()
		{
			index = 0;
			size = length;
		}
		
		/*hasNext
		 * @Returns true if index is less than size, 
		 */
		public boolean hasNext() 
		{
			return index!= size;
			
		}
		
		/*next, returns current value + moves up iterator index
		 *
		 * @Returns current value E
		 */
		public E next() 
		{
			if (!hasNext())
				throw new NoSuchElementException();
			@SuppressWarnings("unchecked")
			E value = (E)array[index];	
			index++;
			return value;
		}
		
		
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
	
	/*converts ArrayList contents to string format
	 * 
	 * @Returns String of ArrayList contents
	 */
@Override
public String toString() 
{
	String stringy = "";
	if (array == null)
	return "";
	for (Object e: array)
	stringy += e + " ";
	return stringy;
	
	
}
	
}
