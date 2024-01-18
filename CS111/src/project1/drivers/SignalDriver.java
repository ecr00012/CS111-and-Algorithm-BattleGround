package project1.drivers;
import java.io.*;
import java.util.List;
import project1.lists.*;
import project1.datahandlers.*;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;

/**
* Runs tests for various sorting and searching algorithms on various data structures
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class SignalDriver {
	
	public static void main(String[] args) throws InvalidArgumentException, NullArgumentException, IOException
	
	{
		
		LinkedList<Signal> lL;
		ArrayList<Signal> aL;
		DoublyLinkedList<Signal> dL;
		
		// amount of signals
		final int capacity = 10100;
		DataLoader loader = null;;
		BufferedWriter fw = null;
		
		try {
		loader = new DataLoader(capacity, "src/doc/Signals.txt");			// instantiates the data
																			// loader and bufferedWriter
		File file = new File("src/doc/SignalResults.csv");
		fw = new BufferedWriter(new FileWriter(file, true));
		
		} catch (Exception e) {System.out.println("Failed to initialize dataloader and bufferedwriter");}
		
		
		fw.write("Algorithm,Data Structure, Mean Time\n"); // writing header line
		
		
		Results results = new Results(fw);
																			// instantiating each list
		List<List<Signal>> masterList = loader.loadMasterList(capacity);
		aL = (ArrayList<Signal>) masterList.get(DataLoader.ARRAYLIST);
		lL = (LinkedList<Signal>) masterList.get(DataLoader.LINKEDLIST);
		dL = (DoublyLinkedList<Signal>) masterList.get(DataLoader.DOUBLYLINKEDLIST);
																				// run tests for each algorithm and data structure
		
		String aListSortResults = SortingExperimentRunner.run(aL, capacity);
		results.sortingTestResults(aListSortResults, aL);
		
		String lListSortResults  = SortingExperimentRunner.run(lL, capacity);
		results.sortingTestResults(lListSortResults, lL);
		
		String dListSortResults  = SortingExperimentRunner.run(dL, capacity);
		results.sortingTestResults(dListSortResults, dL);
		
		String aListSearchResults = SearchingExperimentRunner.run(aL);
		results.searchingTests(aListSearchResults, aL);
		
		String lListSearchResults = SearchingExperimentRunner.run(lL);
		results.searchingTests(lListSearchResults, lL);
		
		String dListSearchResults = SearchingExperimentRunner.run(dL);
		results.searchingTests(dListSearchResults, dL);
		
		fw.close(); // close buffered writer
	
		
		
		
	}
	

}
