//Sanvitti Shah
//09-11-25
//Per. 2
//CalculatePi.java
/*Description of program
 * This approximates pi two different ways. It prints each result to 2,
 * then 6 decimal places. Each result is compared to 3.141592 and the 
 * difference is printed.
 * 
 * 
 * Working on:
 * Using printf and the Format class to format the decimals. Declare and
 * initialize variables (D&I) plus using a final constant for pi.
 */
 
 /**Pseudeocode = the plan
  * class header
  * D & I final constant for PI 
  * main header
  *  make and instance of the class
  *  use the instance to call firstApprox
  *  use the instance to call secondApprox
  * firstApprox header
  *  declare approx1 as a float
  *  initialize approx1 to  0.0f
  *  D&I diff1, set to -100.0f
  * 
  *  set approx1 equal to 22/7
  *  set diff1 to difference between approx 1 and final constant PI
  *  print 3 BLs (blank lines), then the intro sent using PI
  *  print approx1 to 2 decimal places, then 6, then diff1 to 6 places
  * 
  * secondApprox header
  *  D&I approx2 as a float, initialze to 0.0f
  *  D&I diff2, set to -100.0f
  * 
  *  set approx2 to (4+100)*8 + 62000 all divided by 20000
  *  set diff 2 to difference between approx2 and PI
  *  print approx2 to 2 places, then 6, then diff2 to 6 places
  *  (using both printf and Format)
  */
 
  
public class CalculatePi
{
	final float PI = 3.141592f; //this is a final constant 
	
	public static void main(String args [])
	{
		CalculatePi calcPi = new CalculatePi();
		calcPi.firstApprox();
		calcPi.secondApprox();
	}
	
	public void firstApprox()
	{
		float approx1 = 0.0f; 
		float diff1 = -1000f;
		approx1 = (float) 22/7;
		diff1 = approx1-PI;
		
		System.out.println("\n\n\n");
		System.out.println("I am approximating pi (a bit more than 3.141592). \n");
		System.out.printf("The calculation 22/7 yields %.2f or more" 
			+" specifically %.6f shown to 6 places.", approx1, approx1);
		System.out.printf(" It is - %.6f different from %.6f.\n\n", diff1, PI);
		
	}
	
	public void secondApprox()
	{
		float approx2 = 0.0f;
		float diff2 = -1000f;
		approx2 = (float)((4 + 100)*8+62000)/20000;
		diff2 = approx2-PI;
		
		System.out.printf("The calculation (4 + 100) x 8 + 62000, all "
			+"divided by 20000 yields %.2f or more specifically %.6f" 
				+" shown to 6 places. ", approx2, approx2);
		System.out.printf("It is %.6f different from %.6f. \n\n", diff2, PI);
		System.out.println("It is " +Format.left(diff2, 9, 6)
			+"different from "+ Format.left(PI, 9,6));
		System.out.println("\n\n\n");
		
	}
	
}
	
	

