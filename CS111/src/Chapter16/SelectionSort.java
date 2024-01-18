package Chapter16;

import java.util.Random;

public class SelectionSort {
	public static void main(String[] args) {
	
		int[] values = new int[10];
		Random rando = new Random();
		for (int i = 0; i < values.length; i++)
			
		{values[i] = rando.nextInt(10);}
		IntBubbleSorter.print(values);
		
		int max;
		for (int last = values.length - 1; last > 0; last--) {
			max = 0;
			for (int i = 1; i <= last; i++ ) {
			if (values[i]>values[max])
				max = i;						}
			IntBubbleSorter.swap(values, max, last);
			
		}
		
			IntBubbleSorter.print(values);
		
	} // end main
} // end class
