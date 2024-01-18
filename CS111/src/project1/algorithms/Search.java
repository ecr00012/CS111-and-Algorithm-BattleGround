package project1.algorithms;

import java.util.List;

import project1.exceptions.NullArgumentException;
/**
* Collection of Generic searching methods
*
* @author elirichmond
* @version 1.0
* @since 2023-02-07
*/

public class Search {

	/*iterativeBinarySearch, searches list for type E by comparing E at middle index to searched E 
	 * and splitting the list in half according to the comparison
	 * 
	 * <E> Generic Type
	 * @Param E value (what is searched for) 
	 * @Param List<E> values to be searched
	 * @Returns either the index of searched E or -1 if E is not found
	 */
	public static <E extends Comparable<E>> int iterativeBinarySearch(E value, List<E> values)  throws NullArgumentException
	{
		if (value == null || values == null)
			throw new NullArgumentException();					// throws exception if desired value or list are null
		int start = 0, end = values.size()-1;
		while (start <= end)
		{
			int mid = (start+end)/2;
			if (values.get(mid).compareTo(value)==0)
				return mid; 
			
			if ( values.get(mid).compareTo(value) < 0)
				start = mid+1;	
			
			if (values.get(mid).compareTo(value) > 0)
				end = mid-1;

		}


		return -1;												// if value is not in the list

	}
	
	/*linearSearch, searches List for desired E one index at a time
	 * 
	 * @Param <E> Generic Type
	 * @Param E value (what is searched for)
	 * @Param List<E> values to be searched
	 * @Returns either the index of searched E or -1 if E is not found
	 */
	
	public static <E extends Comparable<E>> int linearSearch(E value, List<E> values) throws NullArgumentException
	{
		if (value == null || values == null)
			throw new NullArgumentException();              // throws exception if desired value or list are null

		
		for (int i = 0; i < values.size(); i ++)
		{
		if (values.get(i).compareTo(value) == 0)
			return i;
		
		}
		return -1;											// if not in the list

	}
	
	/*
	 * recursiveBinarySearch wrapper method
	 * 
	 * @Param <E> Generic Type
	 * @@Param E value (what is searched for)
	 * @Param List<E> values to be searched
	 * @Returns either the index of searched E or -1 if E is not found
	 */
	 
	public static <E extends Comparable<E>> int recursiveBinarySearch(E value, List<E> values) throws NullArgumentException
	{
		if (value == null || values == null)
			throw new NullArgumentException();								// throws eception if desired value or list are null

		return doRecursiveBinarySearch(value, 0, values.size()-1, values);  // calls recursive method
	}
	/*
	 * doRecursiveBinarySearch
	 * @Param E value (what is searched for)
	 * @Param int low index of list segment
	 * @Param int high index of list segment 
	 * @Param List<E> generic type values
	 * @Returns either the index of searched E or -1 if E is not found
	 */
	public static <E extends Comparable<E>> int doRecursiveBinarySearch(E value, int low, int high, List<E> values)  
	{	if (low>high)      														// base case returns if value is not in list
		return -1;
		int mid = (low+high)/2;
		
		if (values.get(mid).compareTo(value) == 0)
			return mid;
		
		else if (values.get(mid).compareTo(value) > 0)					
			return doRecursiveBinarySearch(value, low, mid-1, values);			// recursive calls
		
		else return doRecursiveBinarySearch(value, mid+1, high, values);
	}
}
