package project1.algorithms;

import java.util.List;

import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;


/**
* Collection of Generic sorting methods
*
* @author elirichmond
* @version 1.0
* @since 2023-02-07
*/



public class Sort<E extends Comparable<E>> {
	


	
	public final static int ASCENDING= 1;
	public final static int DESCENDING= -1;
	
	
	/*QuickSort Wrapper Method
	 * @Param <E> Generic Type
	 * @Param List<E> values, collection of data to sort
	 * @Param int order (ascending/descending)
	 */
	
	
	public static <E extends Comparable<E>> void quickSort(List<E> values, int order) throws InvalidArgumentException, NullArgumentException
	{
		if (values == null)
			throw new NullArgumentException();  // exception if List contains no values
		if (order == ASCENDING || order == DESCENDING)
		doQuickSort(values, 0, values.size()-1, order); 
		
		else throw new InvalidArgumentException(); // exception if invalid order is given
	}
	
	/* doQuicksort, recursive sorting method
	 * Uses partition method to sort a List
	 * @Param <E> Generic Type
	 * @Param List<E> values, Collection of values to sort
	 * @Param int start of list segment
	 * @Param int end of list segment
	 * @Param int order (ascending/descending)
	 */
	public static <E extends Comparable<E>> void doQuickSort(List<E> values, int start, int end, int order) {
		
			if (start >= end) // base case
			return;
			
			int pivotPoint = partition(values, start, end, order);
			
			doQuickSort(values, start, pivotPoint-1, order); // recursive calls
			
			doQuickSort(values, pivotPoint+1, end, order);
			
			
			
			
		}
		
	/*partition, used by doQuickSort
	 * Splits list into two segments, larger and smaller than E at start index
	 * @Param <E> Generic Type
	 * @Param List<E> values, collection of values to sort
	 * @Param int start of list segment
	 * @Param int end of list segment
	 * @Param int order (ascending/descending)
	 * 
	 * @Returns pivotIndex, index at which segment of list is 
	 * separated into E types greater and lesser than the list at that index
	 * 
	 */
		public static <E extends Comparable<E>> int partition(List<E>values, int start, int end, int order) 
		{
			int pivotIndex = start;
			E pivotValue = values.get(start);
			   
			if (order == ASCENDING) 									// ascending sort
			{
			for (int scan = pivotIndex + 1; scan < values.size(); scan++) 
			{
				if (values.get(scan).compareTo(pivotValue) < 0)          // condition to swap
				{ 
					pivotIndex++;
					swap(scan, pivotIndex, values);
				}
				
			}
			
			swap(start, pivotIndex, values);
			return pivotIndex;
			}
			
			else														// descending sort... another if statement is unnecessary because the 
			{															// wrapper method already ensured order 
				for (int scan = pivotIndex + 1; scan < values.size(); scan++) 
				{
					if (values.get(scan).compareTo(pivotValue) > 0)    // descends by putting values GREATER than PV before the PV final index
					{ 
						pivotIndex++;
						swap(scan, pivotIndex, values);
					}
					
					
					
				}
				
				swap(start, pivotIndex, values);
				return pivotIndex;
		}
		
		}
		
	/*bubbleSort, sorts array in ascending/descending order by comparing 
	 * each index to the next, "bubbling" the greater E type up in the list
	 * 
	 * @Param <E> Generic Type
	 * @Param List<E> input, collection values to be sorted
	 * @Param int order (ascending/descending)
	 */

		public static <E extends Comparable<E>> void bubbleSort(List<E> input, int order) throws InvalidArgumentException, NullArgumentException {
			
			if (input == null)
				throw new NullArgumentException();									// throws exception if the list contains no values
			
			
			if (order == ASCENDING) {												// ascending sort
				
			boolean swap = true;
			
			for (int last = input.size() - 1; last > 0 && swap == true; last--)
			{
				swap = false;
				for (int i = 0; i < last; i++) 
				{
				if (input.get(i).compareTo(input.get(i+1)) > 0)
						{swap(i, i+1, input); swap = true;}
				}
			}
									}
			
			else if (order == DESCENDING) {											// descending sort
				boolean swap = true;
				for (int last = input.size() - 1; last > 0 && swap == true; last--)
				{
					swap = false;
					for (int i = 0; i < last; i++) 
					{
					if (input.get(i).compareTo(input.get(i+1)) < 0)                // descends by swapping if the higher index is greater 
							{swap(i, i+1, input); swap = true;}                    // than the index
					}
				}
										}
			else throw new InvalidArgumentException();								// throws exception if order is incorrect
				
				
				
	/*selectionSort, sorts list in order, either ascending/descending by locating the 
	 * greatest type E and swapping it with the appropriate index
	 * 
	 * @Param <E> Generic Type 
	 * @Param List<E> input, collection of values to be sorted
	 * @Param int order (ascending/descending)
	 * 
	 */
										
		}

		public static <E extends Comparable<E>> void selectionSort(List<E> input,int order) throws InvalidArgumentException, NullArgumentException {

			
			if (input == null)
				throw new NullArgumentException();									// throws exception if list has no values
			
			
			int max;
			int min;
			if (order == ASCENDING)													// ascending sort
			for (int last = input.size() - 1; last > 0; last--)
			{
				max = last;
				for (int j = 0; j < last; j++) 
				{
					if (input.get(j).compareTo(input.get(max)) > 0)					
					max = j;
					
				}
				swap(last, max, input);
				
			}
			else if (order == DESCENDING)											// descending sort
				for (int last = input.size()-1; last > 0; last-- )
				{
					min = last;														// puts minimum value at end of list instead of maximum
					for (int j = 0; j < last; j++) 
					{
						if (input.get(j).compareTo(input.get(min)) < 0)
						min= j;
						
					}
					swap(last, min, input);
					
				}
			
			else throw new InvalidArgumentException();                              // throws exception if order is incorrect
		}

		
		/* insertionSort, sorts E type List by considering first index as sorted, 
		 * saving an E type and inserting it into its appropriate index
		 * 
		 * @Param <E> Generic Type
		 * @Param List<E> input, collection of values to be searched
		 * @Param int order (ascending/descending)
		 * 
		 */
		public static <E extends Comparable<E>> void insertionSort(List<E> list, int order) throws NullArgumentException, InvalidArgumentException
		{
			
			
			if (list == null)
				throw new NullArgumentException();                                 // throws exception if the list contains no values
			
			
			int vIndex;
			int scan;
			E storedValue;
			if (order == ASCENDING)                                                // ascending sort
			for (int i = 1; i < list.size(); i++) 
			{
				vIndex = i;
				scan = vIndex;
				storedValue = list.get(vIndex);
				while (scan > 0 && list.get(scan - 1).compareTo(storedValue) > 0) 
				{
					list.set(scan, list.get(scan-1));
					scan--;
				}
				
				list.set(scan, storedValue);
			}
			else	if (order == DESCENDING)                                       // descending sort
			
				for (int i = 1; i < list.size(); i++) 
			{
			vIndex = i;
			scan = vIndex;
			storedValue = list.get(vIndex);
			while (scan > 0 && list.get(scan - 1).compareTo(storedValue) < 0)     // descends by inserting value at point where 
					{    														   // greater values are behind it
				list.set(scan, list.get(scan-1));
				scan--;
					}
			
			list.set(scan, storedValue);
			}
			
			else throw new InvalidArgumentException();                             // throws exception if order is incorrect
		}
		/* Swap Method
		 * Swaps generic values in a List
		 * @Param int i, j (values to be swapped in list), List<E> input
		 */
		private static <E extends Comparable<E>> void swap(int i, int j, List<E> input) {

			
			final List<E> list = input;
		    list.set(i, list.set(j, list.get(i)));
		
		}
		
		
		
		
	}

