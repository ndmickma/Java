//Sanvitti Shah
//Per. 2
//02-02-26
//RecipeList.java
/*
 * Program Description:
 * get user input for what recipes they are making
 * search for the recipe in Recipes.txt
 * print out recipe to screen (no ingredients)
 * print ingredients to a different file to make a shopping list (including weekly staples)
 * 
 * Working on:
 * file I/O
 * reading from a file
 * writing to a file
 * hunting for a specific phrase in a large file
 * arrays
 */
 
 /** Pseudocode:
  * getInput()
  * 	 get recipe names from user until "Quit" is typed; store in array
  * makeFile()
  * 	 create ShoppingList.txt
 * searchAndPrint()
 * 		for each recipe in the array:
 * 		search in Recipes.txt for the recipe name
 * 		if recipe is in text file
 * 			print the recipe without the ingredient list
 * 		use PrintWriter to write the ingredients in ShoppingList.txt
 *		if recipe is not found
 * 			write the thing user entered to ShoppingList.txt with it's quantity. 
 * writeStaples()
 * 	 open Staples.txt and read line by line and append all lines to ShoppingList.txt
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
    private int recipeCount;
	
    public RecipeList()
    {
        reader = null;
        pr = null;
        ShoppingList = new String("ShoppingList.txt");
        Staples = new String("Staples.txt");
        Recipes = new String("Recipes.txt");
        userInput = "";
        ShoppingListArray = new String [10000];
        recipeCount = 0;
    }
	
    public static void main(String [] args)
    {
        RecipeList rl = new RecipeList();
        rl.callEverything();
    }
	
    public void callEverything()
    {      
        getInput();
        makeFile();
      
        for (int i = 0; i < recipeCount; i++)
        {
            searchAndPrint(ShoppingListArray[i]);
        }      
        writeStaples();	//call method to write the staples at end of ShoppingList.txt
        
        if (pr != null) 
        {
            pr.close();	//so that close() doesn't have to be typed multiple 
						//times, just use an if statement to check if there is anything to save and then use close()
        }

        System.out.println("\n\n\n"); // print 3 blank lines at the end
    }

    public void getInput()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("\n\n\n"); 	//print 3 blank lines
        System.out.println("Welcome to RecipeList! This program will ask"
            + " you for the recipes you will cook this week and then print out "
            + "the recipes and make a file containing your shopping list.");
        System.out.println("Please enter the recipes you will cook this week (Quit to stop).\n ");
        
        while (!(userInput.equalsIgnoreCase("Quit")) && recipeCount < ShoppingListArray.length) 
        {
			//while input is not "Quit" continue asking for 
			//recipes and while number of recipes doesn't exceed array length
            System.out.print("Recipe: ");
            userInput = kb.nextLine();
            
            if (!(userInput.equalsIgnoreCase("Quit")))
            {
                ShoppingListArray[recipeCount] = userInput;
                recipeCount++;
            }
        }
    }
	
    public void makeFile()
    {
        File ShoppingListFile = new File(ShoppingList);	//make output file in try catch (use PrintWriter)
        try
        {
            pr = new PrintWriter(ShoppingListFile);
        }
        catch (IOException e)
        {
            System.err.println("\nERROR: Cannot create " + ShoppingList);
            System.exit(1); 
        }
    }
	
    public void searchAndPrint(String look) //look is the specific recipe we are looking for currently (it changes)
    {
        boolean found = false;	//this variable will find if recipe is in Recipes.txt
        File RecipesFile = new File(Recipes);
        try
        {
            reader = new Scanner(RecipesFile);
            
            while (reader.hasNext())
            {
                String line = reader.nextLine();
                
                String lowerLine = line.toLowerCase();	//turn to lowercase so that if user types lowercase instead of upercase it matches with program
                String lowerLook = look.toLowerCase();
                
                if (lowerLine.indexOf("recipe:") != -1 && lowerLine.indexOf(lowerLook) != -1)
                {
                    found = true; //if recipe is found then found is true
                    System.out.println("\n\n");
                    System.out.println(line); 
                    
                    while (reader.hasNext() && line.indexOf("Ingredients:") == -1)
                    {
                        line = reader.nextLine();
                        if (line.indexOf("Ingredients:") == -1)
                        {
                            System.out.println(line);
                        }
                    }
                   
                    boolean isReadingIngredients = true;	//remains true while directions are being read, 
							//then becomes false so that ingredients are not printed to screen
                    while (reader.hasNext() && isReadingIngredients)
                    {
                        line = reader.nextLine();
                        if (line.indexOf("Directions:") != -1)
                        {
                            isReadingIngredients = false;
                        }
                        else if (line.length() > 0)
                        {
                            pr.println(line); 
                        }
                    }
                    
                    System.out.println("Directions:");
                    boolean isReadingDirections = true;
                    while (reader.hasNext() && isReadingDirections)
                    {
                        line = reader.nextLine();
                        if (line.indexOf("Recipe:") != -1 || line.length() == 0) //if "Recipe:" is read then that means next recipe has started
                        {
                            isReadingDirections = false; 	//no longer in directions
                        }
                        else
                        {
                            System.out.println(line);	//if still reading directions, print the line to screen
                        }
                    }
                }
            }
            reader.close();
                       
            if (!found)	//if recipe is not in file then just add it to ShoppingList and set quantity to 1
            {
                pr.println(look + " (1)");
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("ERROR: Could not find " + Recipes);
        }
    }

    public void writeStaples()
    {
        File StaplesFile = new File(Staples);
        try 	//use try catch to make sure Staples.txt exists
        {
            reader = new Scanner(StaplesFile);
            pr.println("\nSTAPLES:");
            while (reader.hasNext())
            {
                pr.println(reader.nextLine());	//read in each line and print it to ShoppingList.txt
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("ERROR: Could not find " + Staples);
        }
    }
}
