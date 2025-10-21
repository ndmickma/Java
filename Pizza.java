//Sanvitti Shah
//10-21-25
//Pizza.java
/*
 * 
 * 
 */
 
 public class Pizza extends Food
 {
	 protected String topping;
	 public Pizza(String ingredient)
	 {
		 topping = ingredient;
		 super.Food("baked", topping, "pizza")
	 }
	 
 }
