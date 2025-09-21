//Sanvitti Shah
//09-16-25
//Per. 2
/*InchesToFeet.java
 * 
 * 
 * This program outputs/converts inches to feet
 * 
 * Working on:
 * writing pseudocode and testing code
 * using Scanner class
 * final constants
 * use printf
 */ 
 
 
 /**Pseudocode
  * class header
  * import scanner
  * D & I final int convert = 12;
  * make a new Scanner
  * print 3 blank lines
  * prompt user for number of inches (int)
  * put the input into int inches;
  * calculate (divide by convert and store into double feet;)
  * use printf (round to 2 decimal places) and print the new value
  * print 3 blank lines
  * 
  * 
  * Testing plan:
  * input some number to see if they give the right answer:
  * input 23 output 1.92
  * input 24 output 2.00
  * input 0  output 0.00
  * input -12 output -1.00
  * input 3,000,000,000 output error (to big)
  */
 import java.util.Scanner;
 
 public class InchesToFeet
 {
	 
	 public static void main(String args [])
	 {
		 final int CONVERT = 12;
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.print("\n\n\n");
		 System.out.print("Please enter a positive integer that is less " + 
			"than 2 billion -> ");
		 int inches = 0;
		 inches = scanner.nextInt();
		 double feet = (double)inches/CONVERT;
		 System.out.printf("%d inches is equivalent to %.2f feet.", inches, feet);
		 System.out.println("\n\n\n");
	}
}
	 
 
 
 
 
