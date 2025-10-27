//Sanvitti Shah
//Per 2.
//10-21-35
//DeepDishPizza.java
/* Description of program:
 * DeepDishPizza is a sub class of Pizza and a sub sub class to Food
 * It adds a new parameter called name
 * 
 * Working on:
 * Inheritance
 * Contstructors
 * sub sub classes
 * overloading constructors
 * OOP 
 * super keyboard
*/
 
//make DeepDishPizza class (sub sub class) and have it inherit from Pizza (super class)
public class DeepDishPizza extends Pizza
{
	//create 2 protected field variables
	protected String toppingDeepDish, name;
	
	//create constructor and pass in parameters
	public DeepDishPizza(String toppingDeepDishIn, String nameIn)
	{
		//use the super keyword to go to super class (Pizza) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super(toppingDeepDishIn,nameIn);
		
		//set toppingDeepDish equal to toppingDeepDishIn 
		toppingDeepDish = toppingDeepDishIn;
		//set name equal to nameIn 
		name = nameIn;
	}
	 
	 
}

