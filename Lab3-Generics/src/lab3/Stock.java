package lab3;

/**
 * Stock represent a stock on the stock market
 * 
 * 
 * Stocks contain a name, a market value, and a short version of their name.
 * 
 * Change Name Below:
 * 
 * @author creekrichmond
 */
public class Stock implements Comparable<Stock> {

	String name;
	double marketValue;
	String shortName;

	/**
	 * Default Constructor
	 * 
	 * @param name        = "Gamestop llc."
	 * @param shortName   = "GME"
	 * @param marketValue = "1000.00"
	 */
	public Stock(String name, String shortName, double marketValue) {
		
		super();
		this.name = name;
		this.shortName = shortName;
		this.marketValue = marketValue;
		//Fill this portion, you can use this keyword to eliminate the confusion between class attributes and parameters with same name 
		// example: this.name = name;
		//similarly for marketValue and shortName
	
	
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarketValue() {
		return this.marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;;
	}

	public String getShortName() {
		return this.shortName;	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * compareTo
	 * 
	 * compares the marketValue of *this* stock to the stock passed in
	 * 
	 * if this stocks price is less then the other stock: return -1
	 * 
	 * if both stocks have same price: return 0
	 * 
	 * if this stocks price is greater then the other stock: return 1
	 * 
	 * HINT: marketValue is a double...the Double class implements Comparable
	 * (Google Doubles Methods) if/elses are appropriate solutions to this as well.
	 */
	@Override
	public int compareTo(Stock arg0) {
		//Write the return statement here and compare marketValue
		 // AutoBoxing makes this work. 
		//Hint: You can use Type Casting too e.g. Double.compare();
		return Double.compare(this.marketValue, arg0.marketValue);
	}

	@Override
	public String toString() {
	return	this.shortName + ": " + this.marketValue;
		// Use this keyword with return statement for shortName and marketValue
		// Hint: You can add strings (this.shortName + ": " + this.marketValue;)
	}

	@Override
	public boolean equals(Object obj) {
		
		//Fill this portion
		// Use an If statement and check whether obj is an instance of Stock or not
		if ( obj instanceof Stock ) {
			  var s = (Stock) obj;
			return true;
		}
		return false;
		}

}
