package project1.datahandlers;

import java.io.BufferedReader;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import project1.lists.ArrayList;
import project1.lists.DoublyLinkedList;
import project1.lists.LinkedList;

/** Loads a Master List of Lists with signal data from a file
* 
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class DataLoader {

	
	
	public static final int ARRAYLIST =0;
	public static final int DOUBLYLINKEDLIST =1;
	public static final int LINKEDLIST =2;
	private ArrayList<Signal> list;
	
	/* Constructor reads signals from file and adds to a general arraylist of signals
	 * @Param capacity, max number of signals
	 * @Param fileName, path to data file to read from
	 * 
	 */
	public DataLoader(int capacity, String fileName)
	{
	
	String line;
	list = new ArrayList<Signal>(capacity);
	BufferedReader read = null;
		try {
		
		read = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
			try {
				read.readLine();
				} catch(IOException i) {System.out.println("First reading of file failure");}
				
				
				try {
					while ( (line = read.readLine()) != null)
					{
						try {
						Signal sig = new Signal(line);
						if (sig.getDm() >= 0 && sig.getDownfact() >= 0 && sig.getTime() >= 0 &&  sig.getSigma() >= 0 && sig.getSample() >= 0)
						list.add(sig);}
						catch(Exception a) {
							System.out.println("Invalid Signal Data caught");}
						
					}
				} catch (IOException i) {
					
					System.out.println("BufferedReader loop error");
					
				}
		}
	
	/* Loads a master list of a Linked, DoublyLinked, and ArrayList of the read signals
	 * @Param int capacity, max number of signals
	 * @Returns the master list of three lists
	 * 
	 */
	public List<List<Signal>> loadMasterList(int capacity)
	{
		ArrayList<List<Signal>> masterList = new ArrayList<>();
	
		{
			ArrayList<Signal> aryList = new ArrayList<Signal>(capacity);
			aryList.addAll(list);
		
			DoublyLinkedList<Signal> dList = new DoublyLinkedList<Signal>();
			dList.addAll(list);
			
			LinkedList<Signal> lList = new LinkedList<Signal>();
			lList.addAll(list);
			
			masterList.add(aryList); 
			masterList.add(lList);
			masterList.add(dList);
		
		
		}
		
		return masterList;
		
		
	}
	
		
}
