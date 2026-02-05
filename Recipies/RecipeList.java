//Sanvitti Shah
//Per. 2
//02-02-26
//RecipeList.java
/*
 * 
 * Program Description:
 * Get user input for what recpies they are making
 * Search for the recpie in Recpies.txt
 * 
 * 
 * Working on:
 * File I/O
 * Reading from a file
 * writing to a file
 * hunting for a specific phrase in a large file
 *
 */

/**
 * import everything
 * read in file
 */
 

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class RecipeList
{
	private Scanner reader;
	private PrintWriter pr;
	private String ShoppingList;
	private String Staples;	
	private String Recipes;
	private String userInput;
	private String [] ShoppingListArray;
	private String [] PrintToScreenArray;
	
	public RecipeList()
	{
		reader = null;
		pr = null;
		ShoppingList = new String("ShoppingList.txt");
		Staples = new String("Staples.txt");
		Recipes = new String("Recipes.txt");
		userInput = "";
		ShoppingListArray = new String [10000];
		PrintToScreenArray = new String [10000];
	}
	
	public static void main(String [] args)
	{
		RecipeList rl = new RecipeList();
		rl.callEverything();
	}
	
	public void callEverything()
	{
		//call everything
		getInput();
		
	}
	public void getInput()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("\n\n\nWelcome to RecipeList! This program will ask"
			+" you for the recipes you will cook this week and then print out "
			+"the recipes and make a file containing your shopping list.");
		
		while(!(userInput.equalsIgnoreCase("Quit"))
		{
			System.out.print("Please enter one recipe you will cook this week and press "
				+"enter after writing. If you have entered all recipes, type Quit to stop");
			userInput = kb.nextLine();
		}
	}
	
	public void makeFile()
	{
		File ShoppingListFile = new File(ShoppingList);
		try
		{
			pr = new PrintWriter(ShoppingListFile);
		}
		catch(IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + ShoppingList + "file\n\n\n");
			System.exit(1); 
		}
	}
	
	public void readFiles()
	{
		File StaplesFile = new File(Staples);
		try
		{
			reader = new Scanner(StaplesFile);
		}
		catch(FileNotFoundException e)
		{
			System.err.printf("\n\n\nERROR: Cannot find/open file %s.\n\n\n", StaplesFile);
		}
		
		File RecipesFile = new File(Recipes);
		try
		{
			reader = new Scanner(RecipesFile);
		}
		catch(FileNotFoundException e)
		{
			System.err.printf("\n\n\nERROR: Cannot find/open file %s.\n\n\n", RecipesFile);
		}
		
		while(RecipesFile.hasNext())
		{
			String line = RecipesFile.nextLine();
			if(line.substring(0,6).equals("Recipe:"))
			{
				
			}
			if(u.indexOf(userInput) != -1)		//fix this but use this idea---and search for the userinput if it is in recipe.txt
		}
	}
	
}
