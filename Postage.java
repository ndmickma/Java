//Sanvitti Shah
//10-28-25
//Per. 2
//Postage.java
/*Program Description:
 * 
 * 
 * 
 * 
 * Working on:
 * if - else
 * 
 * 
 * 
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
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Using the menu above, please enter the category of your postage -> ");
		selected = keyboard.nextInt();
		if(selected == 1)
		{
			System.out.print("\nEnter the weight, in ounces, of your letter (a positive integer less than 2 million) -> ");
			weight = keyboard.nextInt();
		}
		else if(selected == 3)
		{
			System.out.print("\nEnter the weight, in pounds, of your package (a positive integer less than 2 million) -> ");
			weight = keyboard.nextInt(); 
		}
			
				
	}
	public double calculateCost()
	{
		if(selected == 1)
		{
			if(weight<=0)
			{
				System.out.println("The weight you entered is not a valid input. Rerun the program and input a positive integer."); 
			}
			else
			{
				cost = 0.78 + (0.29*(weight-1));
			}
		}
		else if(selected == 2)
		{
			cost = 0.61;
		}	
		
		else if(selected == 3)
		{
			if(weight<=0)
			{
				System.out.println("The weight you entered is not a valid input. Rerun the program and input a positive integer."); 
			}
			else
			{
				cost = 4.47 + (0.72*(weight-1));
			}
			
		}
		else
		{
			System.out.println("Please enter a valid postage class!");
		}

	}
	
	public static void printMenu()
	{
		System.out.println("\n\n\n");
		System.out.println("Hello, and welcome to the US Post Office");
		System.out.print("	(1)First class, domestic/n");
		System.out.print("	(2)Postcards, domestic/n");
		System.out.print("	(3)Media Mail/n");
	}
	public static void printCost()
	{
		if(selected == 1)
		{
			System.out.printf("");
		}
		else if(selected == 2)
		{
			System.out.printf("");
		}
		else if(selected == 3)
		{
			System.out.printf("");
		}
		else
		{
			System.out.println("Have a nice day!");
			System.out.print("\n\n\n");
	}
	public void sendThis() 
	{
		getData();
		calculateCost();
		printInfo();
	}
}
