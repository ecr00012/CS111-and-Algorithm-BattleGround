package Chapter16;
import java.util.Random;
public class BubbleSortStudy {
				public static void main(String[] args) {
						
					Random rando = new Random();
					int[] values = new int[10];
					for (int i = 0; i < values.length; i++)
					{
						values[i] = rando.nextInt(10);
					}
					
					IntBubbleSorter.print(values);
			
					boolean swap = true;
					for (int last = values.length - 1; last>0 && swap; last--) {
						swap = false;
						for(int i = 0; i < last; i++)
						{
							if(values[i]>values[i+1])
							{
								int temp = values[i];
								values[i]=values[i+1];
								values[i+1]=temp;
								swap = true;
							}
							
							
						}
																				}
						
					IntBubbleSorter.print(values);
						
						
						
						
						
						
					
					
					
					
					
				}
				
				public static void selectionSort(int[] values) {
					int max;
					for(int last = values.length-1; last > 0; last--) {
						max = 0;
						for(int i = 1; i <= last; i++)
						{
							if(values[i]>values[max])
							{max = i;}
							
							
							
						}
						int temp = values[max];
						values[max]=values[last];
						values[last]=temp;
					}
					
					
					
					
				}
				
				
}
