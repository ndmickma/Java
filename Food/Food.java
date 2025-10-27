//Sanvitti Shah
//10-20-25
//Per. 2
//Food.java
/*
 * Program Description:
 * This is the super class Food
 * All subclasses will inherit from it
 * It prints out how a food is made, the name, and the ingredient
 * 
 * Working on:
 * Inheritance
 * multiple methods
 * field variables
 * constructors
 * overloading contructors
 */
 
//create class (superclass)
public class Food
{
	//declare field variables
	protected String str, prepMethod, ingredient; 
	
	//make constructor and initialize str
	public Food () 
	{
		str = new String("");
	}
	
	//overload constuctor with parameters needed for given statement
	public Food (String prepMethod, String ingredient, String name) 
	{	
		//set statement equal to str
		str = "At the sale: " + name + " " + prepMethod + " with " + ingredient;
	}
	
	
	//print out str
	public void printForSale()
	{
		System.out.println(str);
	}
}


