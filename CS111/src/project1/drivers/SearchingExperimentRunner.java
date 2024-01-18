package project1.drivers;

import java.util.List;
import java.lang.System;

import project1.algorithms.Search;
import project1.algorithms.Sort;
import project1.datahandlers.Signal;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import java.util.Random;

/*
* runs each of the searching tests and records their times to be sent to the results class
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class SearchingExperimentRunner 
{
	
	private static final int REPETITIONS = 10;
	
	/* runs each searching tests and formats the times in a string separated by commas
	 * @Param list, algorithm to run the tests on
	 * @Returns String of average times each test took
	 * 
	 */
	public static String run(List<Signal> list) throws InvalidArgumentException, NullArgumentException
	{
		Random rand = new Random();
		Signal randomSignal;
		int size = list.size();
		double IBS = 0, RBS= 0, LS = 0;
		
		for (int i = 0; i < REPETITIONS; i++) {
		randomSignal = list.get(rand.nextInt(size));
		LS += linearSearchRunner(list, randomSignal);
		}
		
		Sort.quickSort(list, Sort.ASCENDING);		// necessary to sort the list before running
		for (int i = 0; i < REPETITIONS; i++)		// the binary searches
		{
		randomSignal = list.get(rand.nextInt(size));
		
		
		IBS += iterativeBinarySearchRunner(list, randomSignal);
		
		RBS += recursiveBinarySearchRunner(list, randomSignal);
		
		
		}
		
		RBS = RBS/10;
		IBS = IBS/10;
		LS =  LS/10;
		String vals = IBS +"," + RBS +"," + LS;
		return vals;
	}


	/* records the time iterative binary search takes in milliseconds
	 * @Param list to be run on
	 * @param randomSignal to be searched for
	 * @Returns the double value the algorithm takes, in milliseconds 
	 * 
	 */
public static double iterativeBinarySearchRunner(List<Signal> list, Signal randomSignal) throws NullArgumentException 
{
	double time1  = System.nanoTime()/1000000;
	
	Search.iterativeBinarySearch(randomSignal, list);
	
	double time2 = System.nanoTime()/1000000;
	

	return time2 - time1;
	
}

/* records the time recursive binary search takes in milliseconds
 * @Param list to be run on
 * @param randomSignal to be searched for
 * @Returns the double value the algorithm takes, in milliseconds 
 * 
 */
public static double recursiveBinarySearchRunner(List<Signal> list, Signal randomSignal) throws NullArgumentException
{
	double time1  = System.nanoTime()/1000000;
	
	Search.recursiveBinarySearch(randomSignal, list);
	
	double time2 = System.nanoTime()/1000000;
	

	return time2 - time1;
}

/* records the time linear search takes in milliseconds
 * @Param list to be run on
 * @param randomSignal to be searched for
 * @Returns the double value the algorithm takes, in milliseconds 
 * 
 */
public static double linearSearchRunner(List<Signal> list, Signal randomSignal) throws NullArgumentException 
{
double time1  = System.nanoTime()/1000000;
	
	Search.linearSearch(randomSignal, list);
	
	double time2 = System.nanoTime()/1000000;
	

	return time2 - time1;
}

}