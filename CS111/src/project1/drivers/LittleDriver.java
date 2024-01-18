package project1.drivers;

import java.io.*;
//import java.util.List;
import project1.lists.*;
import project1.datahandlers.*;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;

public class LittleDriver  {

	public static void main(String[] args) throws InvalidArgumentException, NullArgumentException, IOException {
		// TODO Auto-generated method stub

		DoublyLinkedList<Signal> aL = new DoublyLinkedList<Signal>();
		
		// amount of signals
		final int capacity = 50;
		DataLoader loader = null;;
		
		
	try {
		loader = new DataLoader(capacity, "src/doc/shortenedSignals.txt");
		} 
	catch (Exception e) {System.out.println("Failed to initialize dataloader and bufferedwriter");}
		
		
		var masterList = loader.loadMasterList(capacity);
		aL = (DoublyLinkedList<Signal>) masterList.get(2);
		
	System.out.println(aL.get(0));
		
	SortingExperimentRunner.run(aL, capacity);
		 
		 
	System.out.println(aL.get(0));
		
	
		
		
		

}}
