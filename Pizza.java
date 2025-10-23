//Sanvitti Shah
//10-21-25
//Pizza.java
/*
 * 
 * 
 */
 
 public class Pizza extends Food
 {
	// protected String topping;
	 public Pizza(String ingredient)
	 {
		 super("baked", ingredient, "pizza");
		 //topping = ingredient;
	 }
	 public Pizza(String ingredient, String name)
	 {
		 super("baked", ingredient, "deep dish pizza");
	 }
	 
 }
