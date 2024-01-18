package project1.datahandlers;

/**
* Signal object with dm, signma, time, sample, and downfact values
*
* @author elirichmond
* @version 1.0
* @since 2023-04-09
*/
public class Signal implements Comparable<Signal>{

	private double dm, sigma, time;
	private int sample, downfact;
	
	// Def constructor
	public Signal() 
	{
		
		dm = sigma = time = sample = downfact = 0;
		
	}
	
	// Coinstructor with input
	public Signal(String line) 
	{
		//split(String regex) , parseInt()
		String[] lineAry = line.split(" ");
		
		// splits the string of signal values and assigns each field
		// try/catch for each value
		
		try {
		dm = Double.parseDouble(lineAry[0]);
		
		} catch (NumberFormatException e){
			
			dm = -1;
		}
		
		try {
		sigma = Double.parseDouble(lineAry[1]);
		} catch(NumberFormatException e) {
			
			sigma = -1;
		}
		try {
		time = Double.parseDouble(lineAry[2]);
		} catch(NumberFormatException e) {
			
			time = -1;
		}
		
		try {
		sample = Integer.parseInt(lineAry[3]);
		} catch(NumberFormatException e) {
			
			sample = -1;
			
		}
		
		try {
		downfact = Integer.parseInt(lineAry[4]);
		
		} catch(NumberFormatException e) {
			downfact = -1;
			
		}
		
	}
	
	public double getDm() 
	{
		return this.dm;
	}
	
	public double getSigma() 
	{
		return this.sigma;
	}
	
	public double getTime() 
	{
		return this.time;
	}
	
	public int getSample() 
	{
		return this.sample;
	}
	
	public int getDownfact() 
	{
		return this.downfact;
	}
	@Override
	public int compareTo(Signal Sig2)
	{
	if (this.sigma > Sig2.sigma )
		return 1;
	if (this.sigma < Sig2.sigma)
		return -1;
	
	return 0;
	}
	
	@Override
	public String toString()
	{
		return "" + this.sigma;
		
		
		
	}
	

}
