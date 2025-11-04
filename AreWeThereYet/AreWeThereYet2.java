//Sanvitti Shah
//11-04-25
//Per. 2
//AreWeThereYet2.java
/*
 */


public class AreWeThereYet2
{
	public static void main(String [] args)
	{
		AreWeThereYet2 arewe2 = new AreWeThereYet2();
		arewe2.journey();
	}
	
	public void journey()
	{
		System.out.println("\n\n\n");	//3 blank lines
		int miles;					//D&I miles to 50
		int counter = 0;				//D&I counter for formatting purposes 
		
		
		for(miles = 50; miles >=0 ; miles-=5)
		{
			counter++;
			printLines(miles, counter);	//call printLine() to output to a screen
										//subtract 5 from miles
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
