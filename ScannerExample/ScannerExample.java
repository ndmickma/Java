//Sanvitti Shah
//09-15-25
//Per. 2
/*ScannerExample.java
 * 
 * This program is an example of how to use the Scanner class
 * 
 * Working on:
 * 1. Inputting from the keyboard
 * 2. Using a Math method
 */
 
import java.util.Scanner;   //import our library

public class ScannerExample
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in); //Opens the Scanner
												   // System.in is the keyboard
		System.out.print("\n\n\n");
		System.out.print("Input a decimal please\t-> "); //prompt for user
		double input = 0;
		input= keyboard.nextDouble();   		//read integer unput
		System.out.println("Your decimal is " + input);		//print out input
		
		//It is basically the same for nextDouble, nextFloat, nextLong, etc.
		
		keyboard.nextLine();	//flush the buffer to use nextLine-take out
								//to see what happends
								
		System.out.print("\nInput a sentence please\t-> ");
		String str = new String("");
		str = keyboard.next(); 		//reads the first word of sentence
		System.out.println("Your first word of the sentence is: " + str);
	
		str = keyboard.nextLine(); 		//reads up to end of the line
		System.out.println("The rest of your sentence is: " + str);

		
		//Using Math methods
		double power = 0.0;
		power = Math.pow(input,3);
		System.out.println("\nInput number cubed, = " +power);
		
		power = Math.round(power);
		System.out.println("power round to nearest whole number = " + (int)power);
				//it is a double, so it gives the first decimal place
				//Math.round(float) returns an int
				//Math.round(double) returns a long, so you cannot save to an int!
				//To get around this, cast the double as a float, then round
				//or use a long vs. int
		System.out.println("\n\n\n");
		
		//sqrt and stuff we haven't done (you can look up Java math methods)
		
	}
}
