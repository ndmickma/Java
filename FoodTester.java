//Sanvitti Shah
//Per.2 
//10-21-25
//FoodTester.java
/*
 * 
 * 
 * 
 * 
*/

public class FoodTester
{
	public FoodTester()
	{
    }
	public static void main(String [] args)
	{
		System.out.println("\n\n\n");
		Food food1 = new Food ("baked", "banana", "muffins");
		food1.printForSale();
		Food food2 = new Food ("fried", "yam", "fritters");
		food2.printForSale();
		Pizza pizza = new Pizza ("pepperoni");
		pizza.printForSale();
		System.out.println("\n\n\n");
	}
	


}
