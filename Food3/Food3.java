//Sanvitti Shah
//10-25-25
//Per. 2
//Food3.java
/*Program Description:
 * This is the super class Food3
 * All subclasses will inherit from it
 * It prints out how a food is made, the name,the ingredient, the cost per piece
 * the cost for a certain amt of pieces
 * 
 * Working on:
 * Inheritance
 * multiple methods
 * field variables
 * constructors
 * overloading contructors
 * String.format()
 */


//create class (superclass)  
public class Food3
{
	//declare field variables
	protected String str, prepMethod, ingredient;
	//add new FVs for pieces and price 
	protected int pieces, price;
	protected double maxCost;
	
	//make constructor and initialize str
	public Food3 ()
	{
		str = new String("");
	}
	
	//overload constuctor with parameters needed for given statement
	public Food3 (String prepMethod, String ingredient, String name, int pieces, int price)
	{	
		//intialize maxCost value to how to calculate it
		maxCost = 0.01*(pieces*price);
		//set statement equal to str
		//use String.format to print
		str = String.format("At the sale: %s %s with %s", name, prepMethod, ingredient);
		//use += so that the code ends up in one variable 
		str += String.format(" will be sold for %d cents each. ", price);
		str += String.format("With %d %s(s), $%.2f can be made.", pieces,name, maxCost);
	}

	//print out str
	public void printForSale()
	{
		System.out.println(str);
	}
}


