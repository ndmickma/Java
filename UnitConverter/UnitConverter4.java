//Sanvitti Shah
//10-02-25
//Per. 2
//UnitConverter4.java
/*Program description
 * convert the input value into feet, yards, and centimeters
 * 
 * Working on:
 * making instances of classes
 * methods
 * field variables
 */
 
public class UnitConverter4 
{
	public UnitConverter4()
	{
	}
	public double inchesToFeet (int inches1)
	{
		final byte IN_TO_FT = 12;
		double ft = -1.2;	
		ft = (double)inches1/IN_TO_FT;
		return ft;	
	}
	
	public double inchesToCm (int inches2)
	{
		final double IN_TO_CM = 2.54;
		double centi = -5.0;
		centi = inches2*IN_TO_CM;		
		return centi;
	}
		
	public double feetToYards (double ft2)
	{												
		final byte FT_YD = 3;	
		double yds = -5.0;
		yds = ft2/FT_YD;		
		return yds;			
	}
 }
		 

