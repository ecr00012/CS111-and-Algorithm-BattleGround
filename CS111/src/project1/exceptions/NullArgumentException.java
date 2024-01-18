package project1.exceptions;
/*Exception for null arguments in searching or sorting methods
* 
* @author elirichmond
* @version 1.0
* @since 2023-02-07
*/
@SuppressWarnings("serial")
public class NullArgumentException extends Exception {
	
			public NullArgumentException() 
			{
				
				super("ERROR: Null Argument Detected 😵😵😵");
				
			}
	
}
