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

public class FoodTester3
{
	public FoodTester3()
	{
    }
	public static void main(String [] args)
	{
		System.out.println("\n\n\n");
		Food3 food1 = new Food3 ("baked", "banana", "muffins");
		food1.printForSale();
		Food3 food2 = new Food3 ("fried", "yam", "fritters");
		food2.printForSale();
		Pizza3 pizza = new Pizza3 ("pepperoni");
		pizza.printForSale();
		System.out.println("\n\n\n");
	}
	


}
