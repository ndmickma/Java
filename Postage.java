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
	private boolean validWeight;
	private int weight;
	private int selected;
	
	public Postage()
	{
		validWeight = true;
		weight = 0;
		selected = 0;
	}
	
	public static void main(String [] args)
	{
		Postage mail = new Postage();
		mail.sendThis;
	}
	
	public static void getData()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Using the menu above, please enter the category of your postage -> ");
		selected = keyboard.nextInt;
		if(
	}
	public static double calculateCost()
	{
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
	}
	public void sendThis() 
	{
		getData();
		calculateCost();
		printInfo();
	}
}
