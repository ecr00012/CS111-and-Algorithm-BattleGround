/**
 * CS111 Lab 1
 * 
 * A collection of Integer Array sorting algorithms. You must fill in the
 * following method stubs and get all the tests to pass inside of
 * IntSortsTests.java
 * 
 * All sorts are explained in Ch16 slides. Also, some links have been provided
 * above each method with explanations/animations.
 * 
 * Tip: Make a swap function that takes two indexes and an array and swaps the
 * elements at those indexes. All sorts can use this swapping function.
 * 
 * Please updated your author name below:
 * 
 * @author Eli Richmond Section 11 
 */
public class IntSorts {

	/**
	 * bubbleSort
	 * 
	 * sorts the provided array using the bubbleSort algorithm
	 * 
	 * See here for a detailed explanation of bubble sort:
	 * https://brilliant.org/wiki/bubble-sort/
	 * 
	 * @param input The int array that will be sorted via bubble sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	public static void bubbleSort(int[] input) {


boolean swap = true;
for(int last = input.length - 1; last > 0 && swap; last--) {
	swap = false;
	for(int i = 0; i < last; i++)
	{
		if (input[i]>input[i+1])
			swap(input, i, i+1);
		swap = true;
		
	}
	
}
// Fill this portion to complete the algorithm



	}

	/**
	 * selectionSort
	 * 
	 * sorts the provided array using the selectionSort algorithm
	 * 
	 * See here for a detailed explanation of selection sort:
	 * https://runestone.academy/runestone/books/published/pythonds/SortSearch/TheSelectionSort.html
	 * 
	 * @param input The int array that will be sorted via selection sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	public static void selectionSort(int[] input) {
		int max;
		for (int last = input.length - 1; last > 0; last--)
		{
			max = 0;
			for (int i = 1; i<=last; i++)
			if(input[i]>input[max])
				max = i;
			
			swap(input, max, last);
			
		}


//  Fill this portion to complete the algorithm






	}

	/**
	 * insertionSort
	 * 
	 * sorts the provided array using the insertion sort algorithm
	 * 
	 * See here for a detailed explanation of insertion sort:
	 * https://www.geeksforgeeks.org/insertion-sort/
	 * 
	 * @param input The int array that will be sorted via insertion sort. The input
	 *              arrays elements are modified to be sorted after this method call
	 * 
	 **/
	static public void insertionSort(int[] input) {

		for (int index = 1; index < input.length; index++)
		{
			int scan = index;
			int unSortedValue = input[index];
			while (scan > 0 && input[scan-1] > unSortedValue)   {
				input[scan]=input[scan-1];
				scan--;
												}
														
			input[scan]=unSortedValue;}
		

	}
	
	public static void Quicksort(int [] values) 
	{
			doQuickSort(values, 0, values.length-1);
	
	}
	
	public static void doQuickSort(int [] values, int start, int end) 
	{
		if (start >= end)
		return;
		
		int pivotPoint = partition(values, start, end);
		
		doQuickSort(values, start, pivotPoint-1);
		
		doQuickSort(values, pivotPoint+1, end);
		
		
		
		
	}
	
	public static int partition(int [] values, int start, int end) 
	{
		int pivotIndex = start;
		int pivotValue = values[start];
		for (int scan = pivotIndex + 1; scan < values.length; scan++) 
		{
			if (values[scan] < pivotValue)
			{ 
				pivotIndex++;
				swap(values, scan, pivotIndex);
			}
			
			
			
		}
		
		swap(values, start, pivotIndex);
		return pivotIndex;
	}
	

	
	public static void swap(int[] input, int i, int j) {
int temp = input[i];
input[i]=input[j];
input[j]=temp;
// Fill this portion to complete the swap method

	}
}
