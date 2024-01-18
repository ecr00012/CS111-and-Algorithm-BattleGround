package project1.datahandlers;

import java.io.BufferedWriter;

import java.io.IOException;
import java.util.List;

import project1.lists.ArrayList;
import project1.lists.DoublyLinkedList;
import project1.lists.LinkedList;

/**
* 
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class Results {
	
	BufferedWriter fw;
	
	// constructor 
	public Results(BufferedWriter fw) 
	{
		
		this.fw = fw;	
			
	}
	
	
		
	/* splits the string of results from the sorting tests and writes them to the output file
	 * @Param times, string of results from test
	 * @Param list, the data structure the tests were run on
	 * 
	 */
	public void sortingTestResults(String times, List<Signal> list) throws IOException 
	{
		String[] vals = times.split(",");
		String quick, bubble, insertion, selection;
		quick = vals[0];
		bubble = vals[1];
		selection = vals[2];
		insertion = vals[3];
		
		if (list instanceof ArrayList)
		
   fw.write(
			"Quick,ArrayList,"+quick+"\n"+
			"Bubble,ArrayList,"+bubble+"\n"+
			"Selection,ArrayList,"+selection+"\n"+
			"Insertion,ArrayList,"+insertion+"\n"
		   );
		
		if (list instanceof DoublyLinkedList)
		
   fw.write(
		   	"Quick,DoublyLinkedList,"+quick+"\n" 	+
			"Bubble,DoublyLinkedList,"+bubble+"\n"	+
			"Selection,DoublyLinkedList,"+selection+"\n"  +
			"Insertion,DoublyLinkedList,"+insertion+"\n"
			);
		
		
		if (list instanceof LinkedList)
		
   fw.write(
		   "Quick,LinkedList,"+quick+"\n"+
			"Bubble,LinkedList,"+bubble+"\n"+
			"Selection,LinkedList,"+selection+"\n"+
			"Insertion,LinkedList,"+insertion+"\n"
			);
		
		
		
	}
	
	/* splits the string of results from the searching tests and writes to the output file
	 * @Param times, the string of results
	 * @Param list, the list the tests were run on
	 */
	public void searchingTests(String times, List<Signal> list) throws IOException
	{
		String[] vals = times.split(",");
		String LS, IBS, RBS;
		IBS = vals[0];
		RBS = vals[1];
		LS = vals[2];
		// splits each value from the string of time values
		
		if (list instanceof ArrayList)
		{
			fw.write("Iterative Binary Search, ArrayList,"+IBS+"\n");
			fw.write("Recursive Binary Search, ArrayList,"+RBS+"\n");
			fw.write("Linear Search, ArrayList,"+LS+"\n");
		}
		
		if (list instanceof DoublyLinkedList)
		{
			fw.write("Iterative Binary Search, DoublyLinkedList,"+IBS+"\n");
			fw.write("Recursive Binary Search, DoublyLinkedList,"+RBS+"\n");
			fw.write("Linear Search, DoublyLinkedList,"+LS+"\n");
		}
		
		if (list instanceof LinkedList)
		{
			fw.write("Iterative Binary Search, LinkedList,"+IBS+"\n");
			fw.write("Recursive Binary Search, LinkedList,"+RBS+"\n");
			fw.write("Linear Search, LinkedList,"+LS+"\n");
		}
		
		
	}
	
}
