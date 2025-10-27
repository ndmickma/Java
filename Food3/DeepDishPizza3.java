//Sanvitti Shah
//Per 2.
//10-25-25
//DeepDishPizza3.java
/*Description of program:
 * DeepDishPizza3 is a sub class of Pizza3 and a sub sub class of Food3
 * It adds a new parameter called name
 * 
 * Working on:
 * Inheritance
 * Contstructors
 * sub sub classes
 * overloading constructors
 * OOP
 * super keyboard
 * adding new variables to completed code
 * 
 */
 
 
//make DeepDishPizza3 class (sub sub class) and have it inherit from Pizza3 (super class) 
public class DeepDishPizza3 extends Pizza3
{
	
	//create 4 protected field variables
	protected String toppingDeepDish, name;
	protected int piecesDDIn, priceDDIn
	
	//create constructor and pass in parameters
	public DeepDishPizza3(String toppingDeepDishIn, String nameIn, piecesDDIn2, priceDDIn2)
	{
		//use the super keyword to go to super class (Pizza) and pass in these parameters so when
			//it goes into the superclass it can go through the constructor
		super(toppingDeepDishIn,nameIn);
	
		//set FVs equal to parameter vals
		toppingDeepDish = toppingDeepDishIn;
		name = nameIn;
		piecesDDIn = piecesDDIn2;
		priceDDIn = priceDDIn2;
	}
	 
	 
}

