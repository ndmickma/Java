//Sanvitti Shah
//Per.2 
//10-25-25
//FoodTester3.java
/*Program Description:
 * This program will create new objects and call the method(s) to print
 * and set the values needed
 * 
 * Working on:
 * creating instances of classes
 * multi-method programming
 * not printing in main
 * inheritance
 * 
*/

//create class
public class FoodTester3
{
	
	//create empty constructor 
	public FoodTester3()
	{
    }
    
    //create main
	public static void main(String [] args)
	{
		//print 3 blank lines
		System.out.println("\n\n\n");
		//make an instances of Food3 and pass in parameters for muffins
		Food3 food1 = new Food3 ("baked", "bananas", "muffins", 12, 60);
		//use this instance to call printForSale method which will be in 
			//Food3 class and it will print out the statement
		food1.printForSale();
		//make and instance of Food3 and pass in parameters for fritters
		Food3 food2 = new Food3 ("baked", "yams", "fritters", 3, 125);
		//use this instance to call printForSale method
		food2.printForSale();
		//make and instance of Pizza3 and pass in parameters for pizza
		Pizza3 pizza = new Pizza3 ("anchovies", 8, 250);
		//use this instance to call printForSale method
		pizza.printForSale();
		//print 3 blank lines
		System.out.println("\n\n\n");
	}
}

