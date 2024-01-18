package project1.datahandlers;
import java.io.*;
import project1.lists.*;
import project1.lists.ArrayList;
import project1.lists.LinkedList;

import java.util.*;

public class SignalDataLoader {
	
	
	List<List<Signal>> MasterList;
	List<Signal> Arylist = new ArrayList<Signal>();
	
	static BufferedReader read;
	static String line;
	
	
	{
		try {
			read = new BufferedReader(new FileReader("signals.txt"));
			}
		catch(Exception e) {
			System.out.println("BufferedReader assignment error");
		}
	}
	
	public static List<Signal> loadData(List<Signal> list){
		
		try {
		read.readLine();
		} catch(IOException e) {System.out.println("First reading of file failure");}
		
		
		try {
			while ( (line = read.readLine()) != null)
			{
				try {
				Signal sig = new Signal(line);
				if (sig.getDm() >= 0 && sig.getDownfact() >= 0 && sig.getTime() >= 0 &&  sig.getSigma() >= 0 && sig.getSample() >= 0)
				list.add(sig);}
				catch(Exception e) {
					System.out.println("Invalid Signal Data caught");}
				
			}
		} catch (IOException e) {
			
			System.out.println("BufferedReader loop error");
		}
		return list;
		
		
	} // end loadData
	
	public static ArrayList<Signal> signalArrayList(List<Signal> list) {
		
		ArrayList<Signal> aryList = new ArrayList<>();
		aryList.addAll(list);
		return aryList;
		
		
	}
	
	public static LinkedList<Signal> signalLinkedList(List<Signal> list){
		
		LinkedList<Signal> lList = new LinkedList<>();
		lList.addAll(list);
		return lList;
		
	}
	
	public static DoublyLinkedList<Signal> signalDoublyLinkedList(List<Signal> list)
	{
		DoublyLinkedList<Signal> dLList = new DoublyLinkedList<>();
		dLList.addAll(list);
		return dLList;
		
	}
	
 	@SuppressWarnings("null")
	public static List<Signal> copyList(List<Signal> list)
 	{
 		List<Signal> newList = null;
 		for (Signal e: list)
 		newList.add(e);
 		return newList;
 	}
	// copy back into specific list types
	
	@SuppressWarnings("null")
	public  List<List<Signal>> createMasterList(){
		
		List<List<Signal>> masterList = null;
		List<Signal> list = null;
		loadData(list);
		List<Signal> aryList = signalArrayList(list);
		List<Signal> dLList = signalDoublyLinkedList(list);
		List<Signal> lList = signalLinkedList(list);
		masterList.set(0, aryList); 
		masterList.set(1, lList);
		masterList.set(2, dLList);
		
		
		
		return masterList;
		
		
		
	}
	
	
	
	
	
	
}
