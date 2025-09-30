//Sanvitti Shah
//09-29-25
//Per. 2
//UnitConverter.java
/*Description of program
 * converting user input into feet, yards, and cm
 * 
 * Working on
 * using methods
 * not doing everything in main (OOP)
 * field variable
 * final variables
 */
 
import java.util.Scanner;

public class UnitConverter
{
	static int inches = 0;
	
	public static void main(String [] args)
	{
		double feet = 0.0;
		double yards = 0.0;
		double cm = 0.0;
		 
		input();
		feet = InchesToFt();
		yards = FeetToYards(feet);
		cm = InchesToCm();
		print(feet, yards, cm);
	}
	 
	public static void input()
	{
		 Scanner keyboard = new Scanner(System.in);
		 System.out.print("\n\n\n");
		 System.out.println("Welcome to Unit Converter! This program "
			+"will take in the number of inches and print the number "
			+"of feet, yards, and centimeters.");
		 System.out.print("\nPlease enter a positive integer that is less " + 
			"than 2 billion -> "); 
		 inches = keyboard.nextInt();
	}
		 
		 
	public static double InchesToFt()
	{
		final int CONVERT_INFEET = 12;
		double feet2 = (double)inches/CONVERT_INFEET;
		return feet2;
	}
	 
	public static double FeetToYards(double inFeet)
	{
		final int CONVERT_FEETYD = 3;
		double feet = inFeet;
		double yards2 = feet/CONVERT_FEETYD;
		return yards2;
	}
	
	public static double InchesToCm()
	{
		final double CONVERT_INCM = 2.54;
		double cm2 = inches*CONVERT_INCM;
		return cm2;
	}
	
	public static void print(double feet, double yards, double cm)
	{
		System.out.printf("\n%d is equivalent to %.2f feet, %.2f yards, "
			+"and %.2f centimeters.", inches, feet, yards, cm);
		System.out.println("\nThank you for using Unit Converter!");
		System.out.print("\n\n\n");
	}
}
		
	
	


