package project1.drivers;
import java.lang.System;
import java.util.List;
import project1.algorithms.*;
import project1.datahandlers.Signal;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import project1.lists.ArrayList;

/**
* Tests the average time of the input data structure on different sorting algorithms
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class SortingExperimentRunner 


{

	private static final int REPETITIONS = 10;
	
	/* runs the sorting tests; clears and reloads from a control list after each test
	 * @Param List<Signal> , data structure to run the sorts on
	 * @Returns String of average times of each algorithm
	 * 
	 */
public static String run(List<Signal> list, int capacity) throws InvalidArgumentException, NullArgumentException 

{
	List<Signal> control = new ArrayList<Signal>(capacity);
	control.addAll(list);
	// instantiating control list 
	double QST, BST, SST, IST;
	
	QST = 0;
	
	for (int i = 0; i < REPETITIONS; i++) {
	
	QST+= QuickSortRunner(list);
	
	list.clear();
	list.addAll(control);
	}
	
	
	QST = QST/10;
	
	BST = 0;
	for (int i = 0; i < REPETITIONS; i++) {
	BST+= BubbleSortRunner(list);
	list.clear();
	list.addAll(control);	 
	}
	
	BST = BST/10;
	
	SST = 0;
	for (int i = 0; i < REPETITIONS; i++) {
	SST+= SelectionSortRunner(list);
	list.clear();
	list.addAll(control);	 
	}
	
	SST = SST/10;
	
	IST = 0;
	for (int i = 0; i < REPETITIONS; i++) {
	IST+= InsertionSortRunner(list);
	list.clear();
	list.addAll(control);          
	}	  
	
	IST = IST/10;
	
	String vals = QST + "," + BST + "," + SST + ","+ IST ;
	
	return vals;
}
	

	
/* runs quicksort
 * @Param list, data structure to run on
 * @Returns double, the time the sort took
 * 
 */
	public static double QuickSortRunner(List<Signal> list) throws InvalidArgumentException, NullArgumentException 
	
	{
		
		
		
		double time1  = System.nanoTime()/1000000;
		
		Sort.quickSort( list, Sort.ASCENDING);
		
		double time2 = System.nanoTime()/1000000;
		
		
		
		return time2 - time1;
	}
	
	/* runs bubblesort
	 * @Param list, data structure to run on
	 * @Returns double, the time the sort took
	 * 
	 */
	public static double BubbleSortRunner(List<Signal> list) throws InvalidArgumentException, NullArgumentException
	{
		
		double time1  = System.nanoTime()/1000000;
		
		Sort.bubbleSort( list, Sort.ASCENDING);
		
		double time2 = System.nanoTime()/1000000;
		
		
		return time2 - time1;
		
	}
	

	/* runs insertionSort
	 * @Param list, data structure to run on
	 * @Returns double, the time the sort took
	 * 
	 */
	public static double InsertionSortRunner(List<Signal> list) throws NullArgumentException, InvalidArgumentException
	{
		
		double time1  = System.nanoTime()/1000000;
		
		Sort.insertionSort(list, Sort.ASCENDING);
		
		double time2 = System.nanoTime()/1000000;
		
		return time2 - time1;
		
	}
	
/* runs selection sort
 * @Param list, data structure to run on
 * @Returns double, the time the sort took
 * 
 */
	public static double SelectionSortRunner(List<Signal> list) throws InvalidArgumentException, NullArgumentException
	{

		double time1  = System.nanoTime()/1000000;
		
		Sort.selectionSort( list, Sort.ASCENDING);
		
		double time2 = System.nanoTime()/1000000;
	

		return time2 - time1;
		
		
	}
	
	
	

	
}
