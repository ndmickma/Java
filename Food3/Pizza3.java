//Sanvitti Shah
//10-25-25
//Pizza3.java
/*Description of Program
 * Pizza3 is a subclass of Food
 * It will use it's constuctor to go to Food3's constructor and put in parameters
 * it
 * 
 * Working on
 * contructors
 * inheritance
 * overloading constructor
 * OOP
 * super keyword
 * adding new variables to a completed code
 */


//make Pizza3 class (sub class) and have it inherit from Food3 (superclass)
public class Pizza3 extends Food3
{
	//create default constuctor for Pizza3 and take ingredientIn, piecesIn, and priceIn as parameters
	public Pizza3(String ingredientIn, int piecesIn, int priceIn)
	{
		
		//use super keyword to go to super class (Food) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super("baked", ingredientIn, "pizza", piecesIn, priceIn);
		
		//set field variables equal to parameter val
		ingredient = ingredientIn;
		pieces = piecesIn;
		price = priceIn;
		 
	}
	public Pizza3(String ingredientDD, String nameDD, int piecesDD, int priceDD)
	{
		//use super keyword to go to super class (Food) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super("baked", ingredientDD, "deep dish pizza", piecesDD, priceDD);
		
		//set field variables equal to parameter val 
		ingredient = ingredientDD;
		pieces = piecesDD;
		price = priceDD;
		 
	} 
}

