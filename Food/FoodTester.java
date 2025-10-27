//Sanvitti Shah
//Per.2 
//10-21-25
//FoodTester.java
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
public class FoodTester
{
	//create empty constructor 
	public FoodTester()
	{
    }
    
    //create main
	public static void main(String [] args)
	{
		//print 3 blank lines
		System.out.println("\n\n\n");
		//make an instances of Food and pass in parameters for muffins
		Food food1 = new Food ("baked", "banana", "muffins");
		//use this instance to call printForSale method which will be in 
			//Food class and it will print out the statement
		food1.printForSale();
		//make and instance of Food and pass in parameters for fritters
		Food food2 = new Food ("fried", "yam", "fritters");
		//use this instance to call printForSale method
		food2.printForSale();
		//make and instance of Pizza and pass in ingredient parameter
		Pizza pizza = new Pizza ("pepperoni");
		//use this instance to call printForSale method
		pizza.printForSale();
		//print 3 blank lines
		System.out.println("\n\n\n");
	}
	


}

