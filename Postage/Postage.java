//Sanvitti Shah
//10-28-25
//Per. 2
//Postage.java
/*Program Description:
 * Ask user to pick a postage class and weight and print how much 
 * it costs to mail it according to the postage class (postage rates)
 * 
 * 
 * Working on:
 * if - else
 * nested if - else
 * multiple methods
 * no printing in main
 * scanners
 * instances of classes
 * constructors
 * printf
 * finals
 * limited field variables
 */

import java.util.Scanner;
public class Postage
{
	private int selected;
	private int weight;
	private double cost;
	
	public Postage()
	{
		selected = 0;
		weight = 0;
		cost = 0.0;
	}
	
	public static void main(String [] args)
	{
		Postage mail = new Postage();
		mail.sendThis();
	}
	
	public void getData()
	{
		System.out.println("\n\n\n");
		System.out.println("Hello, and welcome to the US Post Office\n");
		System.out.print("	(1) First class, domestic\n");
		System.out.print("	(2) Postcards, domestic\n");
		System.out.print("	(3) Media Mail\n\n");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Using the menu above, please enter the category of your postage -> ");
		selected = keyboard.nextInt();
		if(selected == 1)
		{
			System.out.print("Enter the weight, in ounces, of your letter (a positive integer less than 2 million) -> ");
			weight = keyboard.nextInt();
		}
		else if(selected == 3)
		{
			System.out.print("\nEnter the weight, in pounds, of your package (a positive integer less than 2 million) -> ");
			weight = keyboard.nextInt(); 
		}
			
				
	}
	public void calculateCost()
	{
		final double FIRST_OUNCE_ONE = 0.78;
		final double FIRST_RATE = 0.29;
		final double POSTCARDS = 0.61;
		final double MEDIA_OUNCE_ONE = 4.47;
		final double MEDIA_RATE = 0.72;
		if(selected == 1)
		{
			if(weight<=0)
			{
				System.out.print("\nThe weight you entered is not a valid input. Rerun the program and input a positive integer."); 
			}
			else
			{
				cost = FIRST_OUNCE_ONE + (FIRST_RATE*(weight-1));
			}
		}
		else if(selected == 2)
		{
			cost = POSTCARDS;
		}	
		
		else if(selected == 3)
		{
			if(weight<=0)
			{
				System.out.print("\nThe weight you entered is not a valid input. Rerun the program and input a positive integer."); 
			}
			else
			{
				cost = MEDIA_OUNCE_ONE + (MEDIA_RATE*(weight-1));
			}
			
		}
		else
		{
			System.out.print("\nPlease enter a valid postage class!");
		}
	}
	
	public void printInfo()
	{
		if(selected == 1 && weight>0)
		{
			System.out.printf("\n%-30s%-30s", "Your postage class:", "First class, domestic");
			System.out.printf("\n%-30s%-1d ounces", "Weight:", weight);
			System.out.printf("\n%-30s%-1s%.2f", "Charge:", "$", cost);
		}
		else if(selected == 2)
		{
			System.out.printf("\n%-30s%-30s", "Your postage class:", "Postcards, domestic");
			System.out.printf("\n%-30s%-1s", "Weight:", "--");
			System.out.printf("\n%-30s%-1s%.2f", "Charge:", "$", cost);
		}
		else if(selected == 3)
		{
			System.out.printf("\n%-30s%-30s", "Your postage class:", "Media Mail");
			if(weight == 1)
			{
				System.out.printf("\n%-30s%-1d pound", "Weight:", weight);
			}
			else
			{
				System.out.printf("\n%-30s%-1d pounds", "Weight:", weight);
			}
			System.out.printf("\n%-30s%-1s%.2f", "Charge:", "$", cost);
		}
		
		System.out.println("\n\nHave a nice day!");
		System.out.print("\n\n\n");
	}
	
	public void sendThis()
	{
		getData();
		calculateCost();
		printInfo();
	}
}

