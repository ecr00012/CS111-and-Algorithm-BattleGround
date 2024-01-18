package lab3;

import java.util.Comparator;

/**
 * Comparators are another abstract way of comparing classes
 * 
 * The good thing about them is you can define multiple of them and pass them in
 * where a method take a Comparator at, like some sorting algorithms. This can
 * change the way the sorting is done on classes.
 * 
 * 
 * @author zadidhabib
 *
 */
public class StockShortNameComparator implements Comparator<Stock> {

	/**
	 * compare
	 * 
	 * compares the shortName of arg0 to arg1 passed in
	 * 
	 * if arg0.shortName is less then the other stock: return -1
	 * 
	 * if both stocks have the same shortName: return 0
	 * 
	 * if arg0.shortName is greater then the other stock: return 1
	 * 
	 * HINT: shortName is a String...the String class implements Comparable.
	 * if/elses are also appropriate solutions
	 */
	@Override
	public int compare(Stock arg0, Stock arg1) {
		return arg0.getShortName().compareTo(arg1.getShortName());
	}

}