package Chapter16;

public class IntBubbleSorter {

	
	public static void bubbleSort(int[] array) 
	{

		boolean swap = true;
		for (int last = array.length - 1; last > 0 && swap; last--) {
			swap = false;
			for (int i = 0; i < last; i++) {
				
				if (array[i]<array[i+1])
				{swap(array, i, (i+1));
				swap = true;}
				 // end while
											}
																	}
		} // end bubbleSort
	
	public static void swap(int[] array, int val1, int val2)
	{
		int temp = array[val1];
		array[val1] = array[val2];
		array[val2] = temp;
		
		
	}
	
	public static void print(int[] array) {
		
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
}
