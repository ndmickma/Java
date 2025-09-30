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
		InchesToFt();
		FeetToYd();
		InchesToCm();
		print();
	}
	 
	public static void input
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("\n\n\n");
		 System.out.print("Please enter a positive integer that is less " + 
			"than 2 billion -> ");
		 inches = scanner.nextInt();
	}
		 
		 
	public static void InchesToFt
	{
		final int CONVERT_INFEET = 12;
		inches = scanner.nextInt();
		feet = (double)inches/CONVERT_INFEET;
		return feet;
	}
	 
	public static void FeetToYards
	{
		final int CONVERT_FEETYD = 3;
		yards = feet/CONVERT_FEETYD;
		return yards;
	}
	
	public static void 
	
	
