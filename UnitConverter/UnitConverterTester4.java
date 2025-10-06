//Sanvitti Shah 
//10-04-25
//Per. 2
//UnitConverterTester4.java
/*Program description
 * Get the input from user
 * print out info afterwards
 * 
 * Working on:
 * using methods
 * making instances of classes
 * field variables
 */
import java.util.Scanner;
public class UnitConverterTester4
{
	private int inches;
	public static void main (String [] args)
	{
		UnitConverterTester4 uct4 = new UnitConverterTester4();
		uct4.convertIt();
	}
	public UnitConverterTester4()
	{
		inches = 0;
	}
	public void getInches ()
	{
		
		Scanner keyboard = new Scanner (System.in);	
		System.out.println ("\n\n\n");
		System.out.println("Welcome to Unit Converter! This program will take in " +
			"the in the number of inches and print the number of feet, yards and " +
			"centimeters.\n");
		System.out.print ("Enter an integer greater than or equal to 0 for the " 
			 + "number of inches --> ");	
		inches = keyboard.nextInt();
	}
	public void print(double ftIn, double cmIn, double ydsIn)
	{
		System.out.printf ("%n%,d inches is equivalent to %,.2f feet, %,.2f yards" +
			" and %,.2f centimeters.\nThank you for using Unit"
			+" Converter", inches, ftIn, ydsIn, cmIn);
		System.out.println ("\n\n\n");
	}
	public void convertIt()
	{
		UnitConverter4 uc4 = new UnitConverter4();		
		double feet = -1.2;	
		double cm = -2.0;
		double yards = -3.0;
		getInches();
		feet = uc4.inchesToFeet (inches);  // call method
		cm = uc4.inchesToCm (inches);
		yards = uc4.feetToYards(feet);		// call method, parameter = feet
		print(feet, cm, yards);
	}
}


