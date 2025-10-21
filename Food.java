//Sanvitti Shah
//10-20-25
//Per. 2
//Food.java
/*
 * 
 * 
 */
 
public class Food
{
	protected String str, prepMethod, ingredient;
	
	public Food ()
	{
		str = new String("");
	}
	
	public Food (String prepMethod, String ingredient, String name)
	{	
		str = "At the sale: " + name + " " + prepMethod + " with " + ingredient;
	}

	public void printForSale()
	{
		System.out.println(str);
	}
}

