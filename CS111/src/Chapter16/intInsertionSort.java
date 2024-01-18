package Chapter16;

import java.util.Random;

public class intInsertionSort {

	
	public static void main(String[] args) {
		
		Random rando = new Random();
		int[] values = new int[10];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = rando.nextInt(10);
		}
		
		IntBubbleSorter.print(values);
		
		for (int index = 1; index < values.length; index++) {
			
			int scan;
			int unSorted  = values[index];
				
				for (scan = index; scan > 0 && values[scan-1]> unSorted; scan--)
				{
					values[scan] = values[scan-1];
				}
			
			values[scan] = unSorted;
			
		}
		IntBubbleSorter.print(values);
		
	}
	
}
