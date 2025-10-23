//Sanvitti Shah
//10-21-25
//Pizza.java
/*
 * 
 * 
 */
 
 public class Pizza3 extends Food3
 {
	 public Pizza(String ingredientIn, int piecesIn, int priceIn)
	 {
		 super("baked", ingredientIn, "pizza", piecesIn, priceIn);
		 
		 ingredient = ingredientIn;
		 pieces = piecesIn;
		 price = priceIn;
		 
	 }
	 public Pizza3(String ingredientDD, String nameDD, int piecesDD, int priceDD)
	 {
		 super("baked", ingredientDD, "deep dish pizza", piecesDD, priceDD);
		 
		 ingredient = ingredientDD;
		 pieces = piecesDD;
		 price = priceDD;
		 
	 }
	 
 }
