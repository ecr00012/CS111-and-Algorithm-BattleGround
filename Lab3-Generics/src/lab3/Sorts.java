package lab3;

import java.util.List;

/**
 * Reusable Sorting algorithms
 * 
 * 
 * Link to java api List methods:
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * Methods you will need to use on list:
 * 
 * <List>.size() -> Returns the length of a list
 * 
 * <List>.get(int index) -> Returns the element at the specified index
 * 
 * Change name below:
 * 
 * @author creekrichmond
 */

class Sorts {

	public static <E extends Comparable<E>> void bubbleSort(List<E> input) {
		
		boolean swap = true;
		for (int last = input.size() - 1; last > 0 && swap == true; last--)
		{
			swap = false;
			for (int i = 0; i < last; i++) 
			{
			if (input.get(i).compareTo(input.get(i+1)) > 0)
			{	swap(i, i+1, input); swap = true;}
				
			}
		}

	}

	public static <E extends Comparable<E>> void selectionSort(List<E> input) {

		//fill this portion
		int max;
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
	}

	public static <E extends Comparable<E>> void insertionSort(List<E> input) 	
	{
		int vIndex;
		int scan;
		E storedValue;
		for (int i = 1; i < input.size(); i++) 
		{
			vIndex = i;
			scan = vIndex;
			storedValue = input.get(vIndex);
			while (scan > 0 && input.get(scan - 1).compareTo(storedValue) > 0) 
			{
				input.set(scan, input.get(scan-1));
				scan--;
			}
			
			input.set(scan, storedValue);
		}
	}
	
	private static <E extends Comparable<E>> void swap(int i, int j, List<E> input) {

		E temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
		//sharing this swap method as a hint. You can see how Type E can be used here.
	}
}