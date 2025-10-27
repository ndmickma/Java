//Sanvitti Shah
//10-21-25
//Pizza.java
/*Description of Program
 * Pizza is a subclass of Food
 * It will use it's constuctor to go to Food's constructor and put in parameters
 * 
 * Working on
 * contructors
 * inheritance
 * overloading constructor
 * OOP
 * super keyword
 */
 
 
//make Pizza class and have it inherit from Food (subclass)
public class Pizza extends Food
{
	//create default constuctor for Pizza and take ingredient as parameter
	public Pizza(String ingredient)
	{
		//go to super class (Food) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super("baked", ingredient, "pizza");
	}
	 
	//overload constructor for DeepDishPizza
	//add another parameter for the name
	public Pizza(String ingredient, String name)
	{
		//go to super class (Food) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super("baked", ingredient, "deep dish pizza");
	}
	 
}

