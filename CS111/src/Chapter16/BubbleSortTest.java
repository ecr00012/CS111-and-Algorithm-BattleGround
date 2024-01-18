package Chapter16;

import java.util.Random;
public class BubbleSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] values = new int[10];
Random rando = new Random();
for (int i = 0; i < values.length; i++) 
{
	values[i] = rando.nextInt(10);

}

System.out.print("The original order of the array values is ");

for(int i = 0; i < values.length; i++)
System.out.print(values[i]+ " ");
	System.out.println();
	
	IntBubbleSorter.bubbleSort(values);
	System.out.print("Sorted values: ");
	
IntBubbleSorter.print(values);
	} // end main

}
