//Sanvitti Shah
//11-04-25
//Per. 2
//AreWeThereYet1.java
/*
 */


public class AreWeThereYet1
{
	public static void main(String [] args)
	{
		AreWeThereYet1 arewe1 = new AreWeThereYet1();
		arewe1.journey();
	}
	
	public void journey()
	{
		System.out.println("\n\n\n");	//3 blank lines
		int miles = 50;					//D&I miles to 50
		int counter = 0;				//D&I counter for formatting purposes 
		
		
		while(miles >= 0)
		{
			counter++;
			printLines(miles, counter);	//call printLine() to output to a screen
			miles-=5;					//subtract 5 from miles
		} 
		System.out.println("\n\n\n");	//3 blank lines
	}
	
	public void printLines(int milesIn, int counterIn)
	{
		if(milesIn == 0)
			System.out.print("Yes, we finally made it there!");
		else
		{
			System.out.print("Are we there yet?");
			System.out.print("\tNo, " + milesIn + " miles to go.");
		}
		if(counterIn%2 == 0)
			System.out.println();
		else
			System.out.print("\t");
	}
}
